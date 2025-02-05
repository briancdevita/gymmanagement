package com.example.gymmanagement.service.trainerService;


import com.example.gymmanagement.dto.TrainerDTO;
import com.example.gymmanagement.model.Trainer;
import com.example.gymmanagement.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
        System.out.println(trainerDTO);
        Trainer trainer = mapTrainerToEntity(trainerDTO);
        Trainer savedTrainer = trainerRepository.save(trainer);
        return mapTrainerToDTO(savedTrainer);
    }

    @Override
    public TrainerDTO getTrainerById(Long id) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found with id: " + id));
        return mapTrainerToDTO(trainer);
    }

    @Override
    public List<TrainerDTO> getAllTrainer() {
        List<Trainer> trainers = trainerRepository.findAll();
        return trainers.stream().map(this::mapTrainerToDTO).collect(Collectors.toList());
    }

    @Override
    public TrainerDTO updateTrainer(Long id, @RequestBody TrainerDTO trainerDTO) {
        System.out.println(trainerDTO);
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found with id: " + id));


        trainer.setName(trainerDTO.getName());
        trainer.setSpecialty(trainerDTO.getSpecialty());
        trainer.setEmail(trainerDTO.getEmail());
        trainer.setAvatar(trainerDTO.getAvatar());




        Trainer updateTrainer = trainerRepository.save(trainer);

        return mapTrainerToDTO(updateTrainer);
    }

    @Override
    public void deleteTrainer(Long id) {trainerRepository.deleteById(id);}







    public Trainer mapTrainerToEntity(TrainerDTO dto) {
        Trainer trainer = new Trainer();
        trainer.setId(dto.getId());
        trainer.setName(dto.getName());
        trainer.setEmail(dto.getEmail());
        trainer.setSpecialty(dto.getSpecialty());
        trainer.setAvatar(dto.getAvatar());
        return trainer;
    }


    public TrainerDTO mapTrainerToDTO(Trainer trainer) {
        TrainerDTO dto = new TrainerDTO();
        dto.setId(trainer.getId());
        dto.setName(trainer.getName());
        dto.setEmail(trainer.getEmail());
        dto.setSpecialty(trainer.getSpecialty());
        dto.setAvatar(trainer.getAvatar());
        return dto;
    }

}
