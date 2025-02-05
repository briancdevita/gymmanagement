package com.example.gymmanagement.service.trainerService;


import com.example.gymmanagement.dto.TrainerDTO;
import com.example.gymmanagement.model.Trainer;

import java.util.List;

public interface TrainerService {

    TrainerDTO createTrainer (TrainerDTO trainerDTO);
    TrainerDTO getTrainerById(Long id);
    List<TrainerDTO> getAllTrainer();
    TrainerDTO updateTrainer(Long id, TrainerDTO trainerDTO);
    void deleteTrainer(Long id);

    Trainer mapTrainerToEntity(TrainerDTO trainer);

    TrainerDTO mapTrainerToDTO(Trainer trainer);
}
