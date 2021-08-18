package com.aluguelquadra.service.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    private OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<OwnerResponse> register(@RequestBody OwnerDto ownerDto){
        Owner owner = ownerDto.toModel();
        ownerRepository.save(owner);
        var response = new OwnerResponse(owner.getName(), owner.getExternalId());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{externalId}").buildAndExpand(response.getExternalId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/search/{externalId}")
    public ResponseEntity<OwnerResponse> search (@PathVariable("externalId") UUID externalId){
        Owner owner =  ownerRepository.findByExternalId(externalId)
                .orElseThrow(
                        () -> new IllegalArgumentException("Usuário não encontrado")
                );
        return  ResponseEntity.ok(new OwnerResponse(owner.getName(), owner.getExternalId()));
    }

}
