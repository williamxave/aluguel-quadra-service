package com.aluguelquadra.service.day;

import com.aluguelquadra.service.day.enums.PossibleHour;

public class Hour {

    private Day day;

    private PossibleHour possibleHour;

    private Boolean rentVerified;


    public Hour(Day day, PossibleHour possibleHour, Boolean rentVerified) {
        this.day = day;
        this.possibleHour = possibleHour;
        this.rentVerified = rentVerified;
    }
    
    @Deprecated
    public Hour(){}

}
