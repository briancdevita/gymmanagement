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
    private String status;
    private String imageUrl;
    private long maxCapacity;
    private long duration;
    private long registeredParticipants;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id", nullable = false)
    private Trainer trainer;






}
