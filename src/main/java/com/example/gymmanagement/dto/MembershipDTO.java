package com.example.gymmanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class MembershipDTO {

    private Long id;
    private String membershipType;
    private LocalDate startDate;
    private LocalDate endDate;

}
