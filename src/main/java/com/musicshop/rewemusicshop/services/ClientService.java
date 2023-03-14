package com.musicshop.rewemusicshop.services;

import com.musicshop.rewemusicshop.exceptions.ModelNotFoundException;
import com.musicshop.rewemusicshop.models.Client;
import com.musicshop.rewemusicshop.repos.ClientRepo;
import com.musicshop.rewemusicshop.user.CurrentUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private final CurrentUser currentUser;
    private final ClientRepo clientRepo;

    public void login(String name) {
        currentUser.login(findByName(name));
    }

    public List<Client> findAll() {
        return clientRepo.findAll();
    }

    public Client findByName(String name) {
        return clientRepo.findByName(name).orElseThrow(() -> new ModelNotFoundException("Client"));
    }

    public void logout() {
        currentUser.logout();
    }
}
