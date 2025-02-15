package com.example.gymmanagement.repository;

import com.example.gymmanagement.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface ClientRepository  extends JpaRepository <Client, Long> {
    Optional<Client> findByEmail(String email);

    List<Client> findAllByMembershipStatusAndMembership_EndDateBefore(String membershipStatus, LocalDate date);

}
