package com.aluguelquadra.service.date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/date")
public class ShowDateOffController {

    private DaysOff daysOff;

    public ShowDateOffController(DaysOff daysOff) {
        this.daysOff = daysOff;
    }

    @GetMapping
    public ResponseEntity<List<Day>> showDayOff(){
        var day = daysOff.showDaysOffs();
        return ResponseEntity.ok(day);
    }

}
