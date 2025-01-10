package com.example.gymmanagement.controller;


import com.example.gymmanagement.dto.ClientDTO;
import com.example.gymmanagement.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {



    private final ClientService clientService;


    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }



    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
        ClientDTO createClient = clientService.createClient(clientDTO);
        return ResponseEntity.ok(createClient);

    }


    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        ClientDTO clientDTO = clientService.getClientById(id);
        return ResponseEntity.ok(clientDTO);
    }


    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients () {
        List<ClientDTO> clientList =  clientService.getAllClients();
        return ResponseEntity.ok(clientList);
     }



    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        ClientDTO updateClient = clientService.updateClient(id, clientDTO);
        return ResponseEntity.ok(updateClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }


}
