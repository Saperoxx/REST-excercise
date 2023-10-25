package com.example.demo.client;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping(path = "/{username}")
    public Client getClient(@PathVariable String username) {
        return clientService.getClient(username);
    }
}

