package com.example.gymmanagement.service.clientServices;


import com.example.gymmanagement.dto.ClientDTO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientService {


    ClientDTO createClient (ClientDTO clientDTO);
    ClientDTO getClientById (Long id);
    @Query("SELECT c FROM Client c LEFT JOIN FETCH c.membership")
    List<ClientDTO> getAllClients ();
    ClientDTO updateClient (Long id, ClientDTO clientDTO);
    void deleteClient(Long id);
}
