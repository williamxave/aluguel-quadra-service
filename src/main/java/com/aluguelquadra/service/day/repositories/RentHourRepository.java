package com.aluguelquadra.service.day.repositories;

import com.aluguelquadra.service.day.renthour.RentHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentHourRepository extends JpaRepository<RentHour, Long> {
}
