package com.aluguelquadra.service.day.enums;

import com.aluguelquadra.service.day.hours.Hour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum PossibleHour {

    FIRST_HOUR,
    SECOND_HOUR,
    THIRD_HOUR,
    FOURTH_HOUR;

    public static List<Hour> generetedHour (){
       List<Hour> hours =  new ArrayList<Hour>();

      Arrays.stream(PossibleHour.values())
              .map(s -> new Hour(s, false))
              .forEach(hour -> hours.add(hour));
        return hours;
    }
}
