package com.musicshop.rewemusicshop.exceptions;

public class ClientAlreadyExist extends RuntimeException {
    public ClientAlreadyExist() {
        super("Client already exist");
    }
}
