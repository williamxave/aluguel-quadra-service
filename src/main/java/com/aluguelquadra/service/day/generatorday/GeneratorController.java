package com.aluguelquadra.service.day.generatorday;

import com.aluguelquadra.service.day.DayRepository;
import com.aluguelquadra.service.day.DayResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    public void genereted(){
        daysGenerator.generated();
    }

    @GetMapping("/day")
    public ResponseEntity<Page<DayResponse>> pushDay(@RequestParam(required = false) UUID id, @PageableDefault Pageable pageable){
        if(id == null){
           var pageResResponse = dayRepository.findAll(pageable).map(day -> new DayResponse(day));
            return ResponseEntity.ok().body(pageResResponse);
        }
        var pageDay = dayRepository.findByExternalId(id,pageable);

        if(pageDay.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        var pageDayResponseSolo = pageDay.map(day -> new DayResponse(day));

        return ResponseEntity.ok().body(pageDayResponseSolo);
    }
}