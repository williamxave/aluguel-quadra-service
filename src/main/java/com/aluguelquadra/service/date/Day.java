package com.aluguelquadra.service.date;

import javax.persistence.*;
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

    private String month;

    @ElementCollection
    @CollectionTable(name = "hoursDay")
    private List<String> hoursDays = new ArrayList<>();

    public Day(Integer day, String month) {
        this.month = month;
        this.day = day;
    }

    @Deprecated
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

    public List<String> getHoursDays() {
        return hoursDays;
    }

    public UUID getExternalId() {
        return externalId;
    }

    public void rentime(String hora){
        for(int i = 0; i < hoursDays.size(); i++){
            if(hoursDays.get(i).equals(hora)){
                hoursDays.remove(i);
            }
        }
    }
    public void addHours() {
      hoursDays.add(HoursDay.getHours().toString());
    }

}
