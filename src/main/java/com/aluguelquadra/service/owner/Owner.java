package com.aluguelquadra.service.owner;

import com.aluguelquadra.service.day.Day;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    private String email;

    private String telephone;

    @OneToMany
    private List<Day> days = new ArrayList<>();

    @Deprecated
    private Owner(){}

    public Owner(String name, String email, String telephone) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

    public void addDay(Day possibleDay){
        days.add(possibleDay);
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
