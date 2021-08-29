package com.aluguelquadra.service.day.generatorday;

import com.aluguelquadra.service.day.Day;
import com.aluguelquadra.service.day.DayRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/generetor")
public class GeneratorController{

    private DaysGenerator daysGenerator;
    private DayRepository dayRepository;

    public GeneratorController(DaysGenerator daysGenerator, DayRepository dayRepository) {
        this.daysGenerator = daysGenerator;
        this.dayRepository = dayRepository;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public void generted(){
        daysGenerator.generated();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/day")
    public List<Day> pushDay(){
        return dayRepository.findAll();
    }

}