package com.aluguelquadra.service.day.enums;

import com.aluguelquadra.service.day.Hour;

import java.util.ArrayList;
import java.util.List;

public enum PossibleHour {

    FIRST_HOUR,
    SECOND_HOUR,
    THIRD_HOUR,
    FOURTH_HOUR;

    public static List<Hour> generetedHour (){
       List<Hour> hours =  new ArrayList<Hour>();

        for(PossibleHour x : PossibleHour.values()){
            var hour = new Hour(x, false);
            hours.add(hour);
        }
        return hours;
    }
}
