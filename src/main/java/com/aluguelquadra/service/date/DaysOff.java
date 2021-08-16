package com.aluguelquadra.service.date;

import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Component
public class DaysOff {

    private List<LocalDate> daysOff  = new ArrayList<>();

    public List<LocalDate> showDaysOffs(){
        LocalDate  dayNow = LocalDate.now();

        YearMonth yearMonth = YearMonth.of(dayNow.getYear(), dayNow.getMonth());

        for(int day = 1; day < yearMonth.lengthOfMonth(); day++){
            LocalDate dates = yearMonth.atDay(day);

            if(!dates.getDayOfWeek().equals(DayOfWeek.SUNDAY) &&!dates.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
                daysOff.add(dates);
            }
        }
        return daysOff;
    }
}
