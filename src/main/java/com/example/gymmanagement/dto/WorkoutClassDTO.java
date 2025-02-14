package com.example.gymmanagement.dto;

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
