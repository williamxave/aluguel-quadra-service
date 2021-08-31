package com.aluguelquadra.service.day.hours;

import com.aluguelquadra.service.day.enums.PossibleHour;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Hour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private PossibleHour possibleHour;

    @NotNull
    private Boolean rentVerified;

    public Hour(@NotBlank PossibleHour possibleHour,
                @NotNull Boolean rentVerified) {
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
