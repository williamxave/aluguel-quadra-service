package com.aluguelquadra.service.day.repositories;

import com.aluguelquadra.service.day.Day;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {

    Page<Day> findByExternalId(UUID id, Pageable pageable);

}
