package com.example.gymmanagement.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@ToString(exclude = "client")
@Table(name = "memberships")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;


    private String membershipType;
    private LocalDate startDate;
    private LocalDate endDate;

    


}
