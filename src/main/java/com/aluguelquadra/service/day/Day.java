package com.aluguelquadra.service.day;

import com.aluguelquadra.service.day.hours.Hour;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Integer day;

    @NotBlank
    private String dayOfWeek;

    @NotBlank
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
