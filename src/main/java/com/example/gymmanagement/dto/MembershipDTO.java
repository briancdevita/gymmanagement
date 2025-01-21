package com.example.gymmanagement.dto;


import com.example.gymmanagement.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class MembershipDTO {

    private Long id;
    private Client client;
    private String membershipType;
    private LocalDate startDate;
    private LocalDate endDate;

}
