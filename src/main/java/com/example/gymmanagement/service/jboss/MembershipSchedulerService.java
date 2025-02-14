package com.example.gymmanagement.service.jboss;


import com.example.gymmanagement.model.Client;
import com.example.gymmanagement.repository.ClientRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

@Service
public class MembershipSchedulerService {

    private static final Logger logger = LoggerFactory.getLogger(MembershipSchedulerService.class);
    private final ClientRepository clientRepository;


    public MembershipSchedulerService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Configuramos la tarea para que se ejecute diariamente a las 00:00
    @Scheduled(cron = "0 0 0 * * ?")
    public void updateExpiredMemberships() {

        List<Client> clients = clientRepository.findAllByMembershipStatusAndMembership_EndDateBefore("ACTIVE", LocalDate.now());
        System.out.println(clients);
        for (Client client : clients) {
            client.setMembershipStatus("EXPIRED");
            logger.info("Updated membership status to EXPIRED for client id: " + client.getId());
            clientRepository.save(client);
        }
    }
}
