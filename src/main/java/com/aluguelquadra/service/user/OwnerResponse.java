package com.aluguelquadra.service.user;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OwnerResponse {

    private String name;
    private UUID externalId;


    public OwnerResponse(String name, UUID externalId) {
        this.name = name;
        this.externalId = externalId;
    }

    public OwnerResponse() {
    }

    public UUID getExternalId() {
        return externalId;
    }

    public String getName() {
        return name;
    }

}
