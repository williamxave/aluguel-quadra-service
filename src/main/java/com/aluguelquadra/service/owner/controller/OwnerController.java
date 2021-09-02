package com.aluguelquadra.service.owner.controller;

import com.aluguelquadra.service.day.repositories.OwnerRepository;
import com.aluguelquadra.service.owner.request.OwnerRequest;
import com.aluguelquadra.service.owner.response.OwnerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    private OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @PostMapping
    public ResponseEntity<OwnerResponse> userRegistration(@RequestBody @Valid OwnerRequest ownerRequest, UriComponentsBuilder builder) {
        var possibleOwner = ownerRepository.findByEmail(ownerRequest.getEmail()).isPresent();

        if (possibleOwner) {
            throw new IllegalArgumentException("Already registered user");
        }
        var owner = ownerRequest.toModel();

        ownerRepository.save(owner);
        URI uri = builder.path("/{id}").buildAndExpand(owner.getExternalId()).toUri();
        return ResponseEntity.created(uri).body(new OwnerResponse(owner));
    }

//    @GetMapping("/{id}")
//    public Owner test(@PathVariable Long id){
//       return ownerRepository.findById(id).get();
//    }

}
