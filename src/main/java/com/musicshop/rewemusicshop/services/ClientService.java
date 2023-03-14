package com.musicshop.rewemusicshop.services;

import com.musicshop.rewemusicshop.exceptions.ClientAlreadyExist;
import com.musicshop.rewemusicshop.exceptions.MinimumAgeRequirementException;
import com.musicshop.rewemusicshop.exceptions.ModelNotFoundException;
import com.musicshop.rewemusicshop.models.Client;
import com.musicshop.rewemusicshop.models.dtos.ClientRegisterDto;
import com.musicshop.rewemusicshop.repos.ClientRepo;
import com.musicshop.rewemusicshop.user.CurrentUser;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static java.time.LocalDate.now;

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

    public Client register(ClientRegisterDto newClient) {
        if (now().getYear() - newClient.dob().getYear() < 18) {
            throw new MinimumAgeRequirementException();
        }

        val exist = clientRepo.existsByNameAndDob(newClient.name(), newClient.dob());

        if (exist) {
            throw new ClientAlreadyExist();
        }

        return clientRepo.save(toEntity(newClient));
    }

    public void logout() {
        currentUser.logout();
    }

    private Client toEntity(ClientRegisterDto dto) {
        return new Client(dto.name(), dto.dob());
    }
}
