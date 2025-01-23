package com.example.gymmanagement.security;


import com.example.gymmanagement.model.Client;
import com.example.gymmanagement.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class ClientDetailsService implements UserDetailsService {

    private final ClientRepository  clientRepository;


    @Autowired
    public ClientDetailsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return client;
    }
}
