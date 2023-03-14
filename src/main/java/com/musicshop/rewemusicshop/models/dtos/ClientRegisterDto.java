package com.musicshop.rewemusicshop.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ClientRegisterDto(
        @NotNull @NotEmpty String name,
        @NotNull @PastOrPresent LocalDate dob) {
}
