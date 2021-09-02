package com.aluguelquadra.service.day.controllers;

import com.aluguelquadra.service.day.repositories.HourRepository;
import com.aluguelquadra.service.day.hours.HourResponse;
import com.aluguelquadra.service.day.repositories.DayRepository;
import com.aluguelquadra.service.day.repositories.OwnerRepository;
import com.aluguelquadra.service.day.renthour.RentHour;
import com.aluguelquadra.service.day.repositories.RentHourRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.UUID;

@RestController
@RequestMapping("api/day")
public class DayController {

    private OwnerRepository ownerRepository;
    private DayRepository dayRepository;
    private HourRepository hourRepository;
    private RentHourRepository rentHourRepository;

    public DayController(OwnerRepository ownerRepository,
                         DayRepository dayRepository,
                         HourRepository hourRepository,
                         RentHourRepository rentHourRepository) {
        this.ownerRepository = ownerRepository;
        this.dayRepository = dayRepository;
        this.hourRepository = hourRepository;
        this.rentHourRepository = rentHourRepository;
    }

    @Transactional
    @PatchMapping("/{idOwner}/alugar/{idDay}/{idHour}")
    public ResponseEntity<?> rentHour(@PathVariable UUID idOwner, @PathVariable Long idDay, @PathVariable Long idHour) {
        var possibleOwner = ownerRepository.findByExternalId(idOwner)
                .orElseThrow(() -> new IllegalArgumentException("User does not exist"));

        var day = dayRepository.findById(idDay)
                .orElseThrow(() -> new IllegalArgumentException("Day does not exist"));

        var hour = day.getHours().stream().filter(h -> h.getId().equals(idHour)).findFirst().get();

        if (hour.getRentVerified()) {
            throw new IllegalStateException("Horario ja alugado");
        }
        hour.isRented();

        var rentHour = new RentHour(day.getDay().toString(), hour.getPossibleHour().toString(), possibleOwner.getExternalId());

        possibleOwner.addRentHours(rentHour);

        rentHourRepository.save(rentHour);
        hourRepository.save(hour);

        return ResponseEntity.ok().body(new HourResponse(hour));
    }
}
