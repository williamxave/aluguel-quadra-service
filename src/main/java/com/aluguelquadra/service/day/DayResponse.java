package com.aluguelquadra.service.day;

import com.aluguelquadra.service.day.hours.Hour;
import com.aluguelquadra.service.day.hours.HourResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class DayResponse {

    private UUID id;

    private Integer day;

    private String dayOfWeek;

    private String month;

    private List<HourResponse> hours = new ArrayList<>();

    public DayResponse(Day day) {
      this.id = day.getExternalId();
      this.day = day.getDay();
      this.dayOfWeek = day.getDayOfWeek();
      this.month = day.getMonth();
      this.hours.addAll(day.getHours().stream().map(hour -> new HourResponse(hour)).collect(Collectors.toList()));
    }

    public UUID getId() {
        return id;
    }

    public Integer getDay() {
        return day;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getMonth() {
        return month;
    }

    public List<HourResponse> getHours() {
        return hours;
    }
}
