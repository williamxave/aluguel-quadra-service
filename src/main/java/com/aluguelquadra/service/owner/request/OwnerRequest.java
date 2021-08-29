package com.aluguelquadra.service.owner.request;

import com.aluguelquadra.service.owner.Owner;

public class OwnerRequest {

    private String name;

    private String email;

    private String telephone;

    @Deprecated
    private OwnerRequest(){}

    public OwnerRequest(String name, String email, String telephone) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

    public Owner toModel(){
        return new Owner(
                this.name,
                this.email,
                this.telephone
        );
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }
}
