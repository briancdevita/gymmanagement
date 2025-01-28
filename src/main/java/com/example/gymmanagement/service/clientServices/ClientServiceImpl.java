package com.example.gymmanagement.service.clientServices;


import com.example.gymmanagement.dto.ClientDTO;
import com.example.gymmanagement.exception.ErrorCode;
import com.example.gymmanagement.exception.GymManagementExeption;
import com.example.gymmanagement.model.Client;
import com.example.gymmanagement.model.Membership;
import com.example.gymmanagement.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;


    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = mapToEntity(clientDTO);
        client.setRegistrationDate(LocalDate.now());
        Client savedClient = clientRepository.save(client);
        return mapToDTO(savedClient);
    }

    @Override
    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() ->  new GymManagementExeption(
                        ErrorCode.RESOURCE_NOT_FOUND,
                        "Client not found with id " + id
                ));
        return mapToDTO(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new GymManagementExeption(
                        ErrorCode.RESOURCE_NOT_FOUND,
                        "Client not found with id " + id
                ));


        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setEmail(clientDTO.getEmail());
        client.setBirthDate(clientDTO.getBirthDate());
        client.setMembershipStatus(clientDTO.getMembershipStatus());
        Client updateClieent = clientRepository.save(client);
        return mapToDTO(updateClieent);

    }

    @Override
    public void deleteClient(Long id) {clientRepository.deleteById(id);}


    /// Map

    private Client mapToEntity(ClientDTO dto) {
        Client client = new Client();
        client.setFirstName(dto.getFirstName());
        client.setLastName(dto.getLastName());
        client.setEmail(dto.getEmail());
        client.setBirthDate(dto.getBirthDate());
        client.setMembershipStatus(dto.getMembershipStatus());

        // Si hay fechas de membresía en el DTO, inicializamos Membership
        if (dto.getStartDate() != null && dto.getEndDate() != null) {
            Membership membership = new Membership();
            membership.setStartDate(dto.getStartDate());
            membership.setEndDate(dto.getEndDate());
            membership.setClient(client); // Relación inversa
            client.setMembership(membership); // Relación directa
        }

        return client;
    }

    private ClientDTO mapToDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setEmail(client.getEmail());
        dto.setRegistrationDate(client.getRegistrationDate());
        dto.setBirthDate(client.getBirthDate());

        // Si Membership no es null, asignamos las fechas al DTO
        if (client.getMembership() != null) {
            dto.setStartDate(client.getMembership().getStartDate());
            dto.setEndDate(client.getMembership().getEndDate());
        } else {
            dto.setStartDate(null);
            dto.setEndDate(null);
        }

        dto.setMembershipStatus(client.getMembershipStatus());
        return dto;
    }


}
