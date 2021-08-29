package com.aluguelquadra.service.owner.controller;

import com.aluguelquadra.service.day.Day;
import com.aluguelquadra.service.day.DayRepository;
import com.aluguelquadra.service.owner.OwnerRepository;
import com.aluguelquadra.service.owner.request.OwnerRequest;
import com.aluguelquadra.service.owner.response.OwnerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    private OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OwnerResponse userRegistration(@RequestBody OwnerRequest ownerRequest) {
        var possibleOwner = ownerRepository.findByEmail(ownerRequest.getEmail()).isPresent();
        if (possibleOwner) {
            throw new IllegalArgumentException("Already registered user");
        }
        var owner = ownerRequest.toModel();
        ownerRepository.save(owner);
        return new OwnerResponse(owner);
    }
}
