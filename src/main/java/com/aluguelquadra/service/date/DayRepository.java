package com.aluguelquadra.service.date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {

   boolean existsByMonth(String month);

    Optional<Day> findByDayAndMonth(Integer day, String month);
}
