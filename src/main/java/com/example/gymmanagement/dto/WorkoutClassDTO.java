package com.example.gymmanagement.dto;


import com.example.gymmanagement.model.Status;
import com.example.gymmanagement.model.Trainer;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;




@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkoutClassDTO {

    private Long id;
    private String className;
    private String description;
    private LocalDateTime dateTime;
    private String status;
    private String imageUrl;
    private long maxCapacity;
    private long duration;
    private long registeredParticipants;
    private Long trainerId;





}
