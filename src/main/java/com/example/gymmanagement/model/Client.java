package com.example.gymmanagement.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
public class Client {


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;


    private String firstName;
    private String lastName;


    @Column(unique = true)
    private String email;

    private LocalDate registrationDate;
    private LocalDate birthDate;

    private String statusMembership;
}
