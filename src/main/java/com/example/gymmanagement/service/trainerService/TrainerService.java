package com.example.gymmanagement.service.trainerService;


import com.example.gymmanagement.dto.TrainerDTO;

import java.util.List;

public interface TrainerService {

    TrainerDTO createTrainer (TrainerDTO trainerDTO);
    TrainerDTO getTrainerById(Long id);
    List<TrainerDTO> getAllTrainer();
    TrainerDTO updateTrainer(Long id, TrainerDTO trainerDTO);
    void deleteTrainer(Long id);
}
