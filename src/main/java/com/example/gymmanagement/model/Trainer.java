package com.example.gymmanagement.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Table(name = "trainers")
@Entity
public class Trainer {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String specialty;


    @Column(unique = true)
    private String email;



}
