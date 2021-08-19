package com.aluguelquadra.service.date;

import java.util.ArrayList;
import java.util.List;

public enum HoursDay {

    FIRST_TIME,
    SECOND_TIME,
    THIRD_TIME,
    FOURTH_TIME;

    public static List<String> getHours() {
        List<String> possibleHours = new ArrayList<>();
        for (HoursDay hora : HoursDay.values()) {
            possibleHours.add(hora.toString());
        }
        return possibleHours;
    }
}