package com.aluguelquadra.service.day.hours;

import com.aluguelquadra.service.day.enums.PossibleHour;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class Hour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID externalId = UUID.randomUUID();

    @Enumerated(EnumType.STRING)
    private PossibleHour possibleHour;

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

    public UUID getExternalId() {
        return externalId;
    }
}
