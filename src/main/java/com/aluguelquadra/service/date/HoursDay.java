package com.aluguelquadra.service.date;

import java.util.ArrayList;
import java.util.List;

public enum HoursDay {

    FIRST_TIME,
    SECOND_TIME,
    THIRD_TIME,
    FOURTH_TIME;

    public static List<Hours> getHours() {
        List<Hours> possibleHours = new ArrayList<>();
        for (HoursDay hora : HoursDay.values()) {
            var hour = new Hours(hora);
            possibleHours.add(hour);
        }

        return possibleHours;
    }
}