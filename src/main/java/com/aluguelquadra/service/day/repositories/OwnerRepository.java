package com.aluguelquadra.service.day.repositories;

import com.aluguelquadra.service.owner.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Optional<Owner> findByEmail(String email);

    Optional<Owner> findByExternalId(UUID idOwner);
}
