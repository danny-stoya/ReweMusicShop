package com.musicshop.rewemusicshop.repos;

import com.musicshop.rewemusicshop.models.Studio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudioRepo extends JpaRepository<Studio, Long> {
    Optional<Studio> findByName(String name);
}
