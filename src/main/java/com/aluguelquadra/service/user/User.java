package com.aluguelquadra.service.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String externalId = UUID.randomUUID().toString();

    @NotBlank
    private String name;
    @NotBlank
    private String day;
    @NotBlank
    private String hour;

    public User(@NotBlank String name,
                @NotBlank String day,
                @NotBlank String hour) {
        this.name = name;
        this.day = day;
        this.hour = hour;
    }

    public User() {
    }

    public String getExternalId() {
        return externalId;
    }

    public String getName() {
        return name;
    }
}
