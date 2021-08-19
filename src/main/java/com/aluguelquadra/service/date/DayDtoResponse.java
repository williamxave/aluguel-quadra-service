package com.aluguelquadra.service.date;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DayDtoResponse {

    private UUID externaId;
    private Integer day;
    private String month;
    private List<String> hours = new ArrayList<>();

    public DayDtoResponse(Day day) {
       this.externaId = day.getExternalId();
       this.day = day.getDay();
       this.month = day.getMonth();
       this.hours.addAll(day.getHoursDays());
    }

    public Integer getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public UUID getExternaId() {
        return externaId;
    }

    public List<String> getHours() {
        return hours;
    }
}
