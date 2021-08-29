package com.aluguelquadra.service.day;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String day;

    private String month;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Hour> hours = new ArrayList<>();

    @Deprecated
    private Day(){
    }

    public Day(String day, String month) {
        this.day = day;
        this.month = month;
    }

    public Long getId() {
        return id;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public List<Hour> getHours() {
        return hours;
    }
    
    public void addHours(List<Hour> hours){
        this.hours.addAll(hours);
    }
}
