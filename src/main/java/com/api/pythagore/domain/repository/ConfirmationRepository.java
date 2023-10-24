package com.api.pythagore.domain.repository;

import com.api.pythagore.domain.entity.confirmation.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation, Long> {
    Optional<Confirmation> findByUuid(String uuid);
}
