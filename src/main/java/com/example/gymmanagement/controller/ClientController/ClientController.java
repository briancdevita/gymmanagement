package com.example.gymmanagement.controller.ClientController;


import com.example.gymmanagement.dto.ClientDTO;
import com.example.gymmanagement.service.clientServices.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientController {



    private final ClientService clientService;


    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }



    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
        System.out.println("clientDTO = " + clientDTO);
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
        System.out.println("Client DTO controller: " + clientDTO);
        ClientDTO updateClient = clientService.updateClient(id, clientDTO);
        return ResponseEntity.ok(updateClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }


}
