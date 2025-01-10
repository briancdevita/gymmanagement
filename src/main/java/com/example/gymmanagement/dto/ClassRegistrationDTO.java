package com.example.gymmanagement.dto;


import com.example.gymmanagement.model.WorkoutClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClassRegistrationDTO {


    private Long id;
    private WorkoutClass workoutClass;
    private LocalDateTime registrationDate;
}
