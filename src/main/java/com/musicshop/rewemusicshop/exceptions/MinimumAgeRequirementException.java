package com.musicshop.rewemusicshop.exceptions;

public class MinimumAgeRequirementException extends RuntimeException {
    public MinimumAgeRequirementException() {
        super("You need to be at least 18 years old to register");
    }
}
