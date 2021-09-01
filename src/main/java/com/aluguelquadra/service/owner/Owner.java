package com.aluguelquadra.service.owner;

import com.aluguelquadra.service.day.Day;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    private UUID externalId = UUID.randomUUID();

    @NotBlank
    private String telephone;

    @OneToMany
    private List<Day> days = new ArrayList<>();

    @Deprecated
    private Owner(){}

    public Owner(@NotBlank String name,
                 @NotBlank @Email String email,
                 @NotBlank String telephone) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

    public void addDay(Day possibleDay){
        days.add(possibleDay);
    }

    public UUID getExternalId() {
        return externalId;
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
}
