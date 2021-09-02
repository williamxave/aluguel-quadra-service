package com.aluguelquadra.service.day.hours;

import com.aluguelquadra.service.day.enums.PossibleHour;

import java.util.UUID;

public class HourResponse {

    private UUID id;

    private PossibleHour possibleHour;

    private Boolean rentVerified;


    public HourResponse(Hour hour){
        this.id = hour.getExternalId();
        this.possibleHour = hour.getPossibleHour();
        this.rentVerified = hour.getRentVerified();
    }

    public UUID getId() {
        return id;
    }

    public PossibleHour getPossibleHour() {
        return possibleHour;
    }

    public Boolean getRentVerified() {
        return rentVerified;
    }

}
