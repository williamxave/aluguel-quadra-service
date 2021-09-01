package com.aluguelquadra.service.day;

import com.aluguelquadra.service.day.hours.Hour;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID externalId = UUID.randomUUID();

    private Integer day;

    private String dayOfWeek;

    private String month;

    @OneToMany
    @JoinColumn(name = "day_id")
    private List<Hour> hours = new ArrayList<>();

    @Deprecated
    private Day(){
    }

    public Day(@NotBlank Integer day,
               @NotBlank String dayOfWeek,
               @NotBlank String month) {
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.month = month;
    }

    public UUID getExternalId() {
        return externalId;
    }

    public Long getId() {
        return id;
    }

    public String getMonth() {
        return month;
    }

    public Integer getDay() {
        return day;
    }

    public List<Hour> getHours() {
        return hours;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void addHours(List<Hour> hours){
        this.hours.addAll(hours);
    }
}
