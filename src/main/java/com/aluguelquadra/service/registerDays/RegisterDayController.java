package com.aluguelquadra.service.registerDays;

import com.aluguelquadra.service.date.Day;
import com.aluguelquadra.service.date.DayRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

@RestController
@RequestMapping("/api/register")
public class RegisterDayController {

    private DayRepository dayRepository;

    public RegisterDayController(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    @PostMapping
    public ResponseEntity<?> registerMonth() {
        LocalDate dayNow = LocalDate.now();
        var verifyExistMonth = dayRepository.existsByMonth(dayNow.getMonth().toString());

        if(verifyExistMonth){
            throw new IllegalArgumentException("Mes ja cadastrado");
        }
        YearMonth yearMonth = YearMonth.of(dayNow.getYear(), dayNow.getMonth());

        for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {

            LocalDate dates = yearMonth.atDay(day);

            if (!dates.getDayOfWeek().equals(DayOfWeek.SUNDAY) &&
                    !dates.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {

                var dayValid = new Day(dates.getDayOfMonth(), dates.getMonth().toString());
                dayValid.addHours();
                dayRepository.save(dayValid);
            }
        }
        var daysList = dayRepository.findAll();
        return ResponseEntity.ok(daysList);
    }
}
