package com.example.gymmanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate registrationDate;
    private LocalDate birthDate;
    private String membershipStatus;
    private LocalDate startDate;
    private LocalDate endDate;




}
