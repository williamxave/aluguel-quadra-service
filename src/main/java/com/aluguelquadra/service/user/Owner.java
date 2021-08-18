package com.aluguelquadra.service.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private UUID externalId = UUID.randomUUID();

    @NotBlank
    private String name;
    @NotBlank
    private String day;
    @NotBlank
    private String hour;

    public Owner(@NotBlank String name,
                 @NotBlank String day,
                 @NotBlank String hour) {
        this.name = name;
        this.day = day;
        this.hour = hour;
    }

    public Owner() {
    }

    public UUID getExternalId() {
        return externalId;
    }

    public String getName() {
        return name;
    }
}
