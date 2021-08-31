package com.aluguelquadra.service.owner.request;

import com.aluguelquadra.service.owner.Owner;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class OwnerRequest {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String telephone;

    @Deprecated
    private OwnerRequest(){}

    public OwnerRequest(@NotBlank String name,
                        @NotBlank @Email String email,
                        @NotBlank String telephone) {
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
