package com.musicshop.rewemusicshop.web;

import com.musicshop.rewemusicshop.models.Client;
import com.musicshop.rewemusicshop.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/login/{name}")
    public ResponseEntity<String> login(@PathVariable String name) {
        clientService.login(name);
        return ResponseEntity.ok("Welcome");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        clientService.logout();
        return ResponseEntity.ok("Welcome");
    }

    @GetMapping("/{name}")
    public ResponseEntity<Client> findByName(@PathVariable String name) {
        return ResponseEntity.ok(clientService.findByName(name));
    }
}
