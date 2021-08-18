package com.aluguelquadra.service.date;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer day;
    private String month;

    @OneToMany
    private List<Hours> hoursDays = new ArrayList<>();

    public Day(Integer day, String month) {
        this.month = month;
        this.day = day;
        addHours();
    }

    public Day() {
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

    public List<Hours> getHoursDays() {
        return hoursDays;
    }

    public void addHours() {
      hoursDays.addAll(HoursDay.getHours());
    }

    @Override
    public String toString() {
        return "Day{" +
                ", day=" + day +
                ", month='" + month + '\'' +
                ", hoursDays=" + hoursDays +
                '}';
    }
}
