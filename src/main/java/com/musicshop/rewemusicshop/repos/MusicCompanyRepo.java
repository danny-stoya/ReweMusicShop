package com.musicshop.rewemusicshop.repos;

import com.musicshop.rewemusicshop.models.MusicCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MusicCompanyRepo extends JpaRepository<MusicCompany, Long> {
    Optional<MusicCompany> findByName(String name);
}
