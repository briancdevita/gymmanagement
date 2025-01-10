package com.example.gymmanagement.service;


import com.example.gymmanagement.dto.ClientDTO;

import java.util.List;

public interface ClientService {


    ClientDTO createClient (ClientDTO clientDTO);
    ClientDTO getClientById (Long id);
    List<ClientDTO> getAllClients ();
    ClientDTO updateClient (Long id, ClientDTO clientDTO);
    void deleteClient(Long id);
}
