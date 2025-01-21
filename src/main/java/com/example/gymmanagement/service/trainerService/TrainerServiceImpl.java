package com.example.gymmanagement.service.trainerService;


import com.example.gymmanagement.dto.TrainerDTO;
import com.example.gymmanagement.model.Trainer;
import com.example.gymmanagement.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TrainerServiceImpl implements TrainerService {

    private final TrainerRepository trainerRepository;


    @Autowired
    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }


    @Override
    public TrainerDTO createTrainer(TrainerDTO trainerDTO) {
        Trainer trainer = mapToEntity(trainerDTO);
        Trainer savedTrainer = trainerRepository.save(trainer);
        return mapToDTO(savedTrainer);
    }

    @Override
    public TrainerDTO getTrainerById(Long id) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found with id: " + id));
        return mapToDTO(trainer);
    }

    @Override
    public List<TrainerDTO> getAllTrainer() {
        List<Trainer> trainers = trainerRepository.findAll();
        return trainers.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public TrainerDTO updateTrainer(Long id, TrainerDTO trainerDTO) {

        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found with id: " + id));


        trainer.setName(trainerDTO.getName());
        trainer.setSpecialty(trainerDTO.getSpecialty());
        trainer.setEmail(trainerDTO.getEmail());

        Trainer updateTrainer = trainerRepository.save(trainer);

        return mapToDTO(updateTrainer);
    }

    @Override
    public void deleteTrainer(Long id) {trainerRepository.deleteById(id);}





    private Trainer mapToEntity(TrainerDTO dto) {
        Trainer trainer = new Trainer();
        trainer.setEmail(dto.getEmail());
        trainer.setName(dto.getName());
        trainer.setSpecialty(dto.getSpecialty());
        return trainer;
    }

    private TrainerDTO mapToDTO(Trainer trainer) {
        TrainerDTO dto = new TrainerDTO();
        dto.setId(trainer.getId());
        dto.setName(trainer.getName());
        dto.setEmail(trainer.getEmail());
        dto.setSpecialty(trainer.getEmail());
        return dto;
    }
}
