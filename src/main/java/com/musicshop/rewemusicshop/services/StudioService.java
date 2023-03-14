package com.musicshop.rewemusicshop.services;

import com.musicshop.rewemusicshop.exceptions.InvalidRentPeriodException;
import com.musicshop.rewemusicshop.exceptions.ModelNotFoundException;
import com.musicshop.rewemusicshop.models.Rentable;
import com.musicshop.rewemusicshop.models.Studio;
import com.musicshop.rewemusicshop.repos.StudioRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudioService implements Rentable {
    private final StudioRepo studioRepo;

    private Studio findById(Long id) {
        return studioRepo.findById(id).orElseThrow(() -> new ModelNotFoundException("Studio"));
    }

    private Studio book(Long id, int hours) {
        Studio studio = findById(id);
        if (studio.getDailyHourLimit() < hours) {
            throw new InvalidRentPeriodException("Rent period too large.");
        }
        studio.setDailyHourLimit(studio.getDailyHourLimit() - hours);


    }

    @Override
    public boolean canRent() {
        return false;
    }
}
