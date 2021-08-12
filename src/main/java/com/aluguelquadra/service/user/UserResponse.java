package com.aluguelquadra.service.user;

import org.springframework.stereotype.Component;

@Component
public class UserResponse {

    private String name;
    private String externalId;


    public UserResponse(String name, String externalId) {
        this.name = name;
        this.externalId = externalId;
    }

    public UserResponse() {
    }

    public String getExternalId() {
        return externalId;
    }

    public String getName() {
        return name;
    }

}
