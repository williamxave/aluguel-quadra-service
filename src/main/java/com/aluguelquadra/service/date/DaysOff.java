package com.aluguelquadra.service.date;

import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class DaysOff {

    private List<LocalDate> daysOff = new ArrayList<>();
    private List<Day> listHours = new ArrayList<>();

    @Deprecated
    public DaysOff() {
    }

    public List<Day> showDaysOffs() {
        LocalDate dayNow = LocalDate.now();

        YearMonth yearMonth = YearMonth.of(dayNow.getYear(), dayNow.getMonth());

        for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {

            LocalDate dates = yearMonth.atDay(day);

            if (!dates.getDayOfWeek().equals(DayOfWeek.SUNDAY) &&
                    !dates.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {

                daysOff.add(dates);

                var createDay = new Day(dates.getDayOfMonth(), dates.getMonth().toString());
                listHours.add(createDay);

                System.out.println(createDay.toString());

                //dayRepository.save(createDay);
            }
        }
        return listHours;
    }


}
