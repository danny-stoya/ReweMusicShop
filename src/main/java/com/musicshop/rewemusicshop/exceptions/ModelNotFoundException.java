package com.musicshop.rewemusicshop.exceptions;

public class ModelNotFoundException extends RuntimeException {
    public ModelNotFoundException(String model) {
        super(model + " not found");
    }
}
