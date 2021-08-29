package com.aluguelquadra.service.owner.response;

import com.aluguelquadra.service.day.Day;
import com.aluguelquadra.service.owner.Owner;

import java.util.ArrayList;
import java.util.List;

public class OwnerResponse {

    private String name;

    private String email;

    private String telephone;

    private List<Day> days = new ArrayList<>();

    @Deprecated
    private OwnerResponse(){}

    public OwnerResponse(Owner owner) {
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

    @Override
    public String toString() {
        return "OwnerResponse{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", days=" + days +
                '}';
    }
}
