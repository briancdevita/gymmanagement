package com.example.gymmanagement.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(name = "workout_classes")
public class WorkoutClass {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String className;
    private String description;
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;






}
