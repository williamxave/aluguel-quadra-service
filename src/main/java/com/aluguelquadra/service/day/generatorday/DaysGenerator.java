package com.aluguelquadra.service.day.generatorday;

import com.aluguelquadra.service.day.Day;
import com.aluguelquadra.service.day.DayRepository;
import com.aluguelquadra.service.day.HourRepository;
import com.aluguelquadra.service.day.enums.PossibleHour;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

@Component
public class DaysGenerator {

    private DayRepository dayRepository;
    private HourRepository hourRepository;

    public DaysGenerator(DayRepository dayRepository, HourRepository hourRepository) {
        this.dayRepository = dayRepository;
        this.hourRepository = hourRepository;
    }

    @Transactional
    public void generated() {

        LocalDate dayNow = LocalDate.now();

        YearMonth yearMonth = YearMonth.of(dayNow.getYear(), dayNow.getMonth());

        for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {

            LocalDate dates = yearMonth.atDay(day);

            if (!dates.getDayOfWeek().equals(DayOfWeek.SUNDAY) &&
                    !dates.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {

                var newDay = new Day(dates.getDayOfWeek().toString(), dates.getMonth().toString());

                var possibleHours = hourRepository.saveAll(PossibleHour.generetedHour());

                newDay.addHours(possibleHours);

                dayRepository.save(newDay);
            }
        }
    }
}


