package com.example.gymmanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrainerDTO {

    private String email;
    private Long id;
    private String name;
    private String specialty;
    private String avatar;
}
