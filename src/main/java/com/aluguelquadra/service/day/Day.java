package com.aluguelquadra.service.day;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate day = LocalDate.now();

    private String hour;

    @Deprecated
    private Day(){
    }

    public Day(String hour) {
        this.day = day;
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Day{" +
                "day=" + day +
                ", hour='" + hour + '\'' +
                '}';
    }
}
