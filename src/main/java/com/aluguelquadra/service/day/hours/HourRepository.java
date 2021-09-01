package com.aluguelquadra.service.day.hours;

import com.aluguelquadra.service.day.Day;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HourRepository extends JpaRepository<Hour, Long> {
}
