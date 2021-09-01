package com.aluguelquadra.service.owner.response;

import com.aluguelquadra.service.day.Day;
import com.aluguelquadra.service.owner.Owner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OwnerResponse {

    private UUID id;

    private String name;

    private String email;

    private String telephone;

    private List<Day> days = new ArrayList<>();

    @Deprecated
    private OwnerResponse(){}

    public OwnerResponse(Owner owner) {
        this.id = owner.getExternalId();
        this.name = owner.getName();
        this.email = owner.getEmail();
        this.telephone = owner.getTelephone();
        this.days = owner.getDays();
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

    public List<Day> getDays() {
        return days;
    }

    public UUID getId() {
        return id;
    }
}
