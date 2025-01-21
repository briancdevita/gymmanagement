package com.example.gymmanagement.controller.TrainerController;


import com.example.gymmanagement.dto.TrainerDTO;
import com.example.gymmanagement.service.trainerService.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainers")


public class TrainerController {


    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }



    //Get all trainers
    @GetMapping
    public ResponseEntity<List<TrainerDTO>>  getAllTrainers() {
        List<TrainerDTO> trainers = trainerService.getAllTrainer();
        return ResponseEntity.ok(trainers);
    }


    //Create trainer
    @PostMapping()
    public ResponseEntity<TrainerDTO> createTrainer(TrainerDTO trainerDTO) {
        TrainerDTO savedTrainer = trainerService.createTrainer(trainerDTO);
        return ResponseEntity.ok(savedTrainer);
    }



    //Get one trainer

    @GetMapping("{id}")
    public ResponseEntity<TrainerDTO> getOneTrainer(@PathVariable Long id) {
        TrainerDTO trainer = trainerService.getTrainerById(id);
        return ResponseEntity.ok(trainer);
    }



    //Update trainer

    @PutMapping("{id}")
    public ResponseEntity<TrainerDTO> updateTrainer(@PathVariable Long id, TrainerDTO trainer) {
        TrainerDTO trainerUpdate = trainerService.updateTrainer(id, trainer);
        return ResponseEntity.ok(trainerUpdate);
    }



    //Delete trainer
    @DeleteMapping("{id}")
    public ResponseEntity<TrainerDTO> deleteTrainer(@PathVariable Long id) {

        trainerService.deleteTrainer(id);

        return ResponseEntity.noContent().build();
    }



}
