package com.aluguelquadra.service.owner;

import com.aluguelquadra.service.day.renthour.RentHour;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.*;

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
    private Set<RentHour> rentHours =  new HashSet<>();

    @Deprecated
    private Owner(){}

    public Owner(@NotBlank String name,
                 @NotBlank @Email String email,
                 @NotBlank String telephone) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }


    public UUID getExternalId() {
        return externalId;
    }

    public void addRentHours(RentHour hour){
        rentHours.add(hour);
    }

    public Set<RentHour> getRentHours() {
        return rentHours;
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
