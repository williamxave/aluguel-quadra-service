package com.aluguelquadra.service.day.repositories;

import com.aluguelquadra.service.day.Day;
import com.aluguelquadra.service.day.hours.Hour;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HourRepository extends JpaRepository<Hour, Long> {
}
