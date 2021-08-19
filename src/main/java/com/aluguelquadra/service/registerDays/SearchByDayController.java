package com.aluguelquadra.service.registerDays;

import com.aluguelquadra.service.date.DayDtoResponse;
import com.aluguelquadra.service.date.DayRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/search")
public class SearchByDayController {

    private DayRepository dayRepository;

    public SearchByDayController(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    @GetMapping
    public ResponseEntity<DayDtoResponse> searchDay (@RequestParam("day") Integer day, @RequestParam("month") String month){

        var possibleDay =  dayRepository.findByDayAndMonth(day, month)
                .orElseThrow(() -> new IllegalArgumentException("Dia ou mês inválido"));

        var response = new DayDtoResponse(possibleDay);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> rentime (@RequestParam("day") Integer day, @RequestParam("month") String month, @RequestBody String hour){

        var possibleDay =  dayRepository.findByDayAndMonth(day, month)
                .orElseThrow(() -> new IllegalArgumentException("Dia ou mês inválido"));
        possibleDay.rentime(hour);
        dayRepository.save(possibleDay);
        return ResponseEntity.ok(possibleDay.getHoursDays());
    }
}
