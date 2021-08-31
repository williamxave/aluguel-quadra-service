package com.aluguelquadra.service.day.hours;

import com.aluguelquadra.service.day.enums.PossibleHour;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PossibleHour possibleHour;

    private Boolean rentVerified;

    public Hour(PossibleHour possibleHour, Boolean rentVerified) {
        this.possibleHour = possibleHour;
        this.rentVerified = rentVerified;
    }

    @Deprecated
    public Hour(){}

    public PossibleHour getPossibleHour() {
        return possibleHour;
    }

    public Boolean getRentVerified() {
        return rentVerified;
    }

    public Long getId() {
        return id;
    }

}
