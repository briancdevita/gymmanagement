package com.example.gymmanagement.service.WorkoutClassService;


import com.example.gymmanagement.dto.TrainerDTO;
import com.example.gymmanagement.dto.WorkoutClassDTO;
import com.example.gymmanagement.model.Trainer;
import com.example.gymmanagement.model.WorkoutClass;
import com.example.gymmanagement.repository.TrainerRepository;
import com.example.gymmanagement.repository.WorkoutClassRepository;
import com.example.gymmanagement.service.trainerService.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutClassServiceImpl implements  WorkoutClassService {

    private final WorkoutClassRepository workoutClassRepository;
    private final TrainerService trainerService;
    private final TrainerRepository trainerRepository;


    @Autowired
    public WorkoutClassServiceImpl(WorkoutClassRepository workoutClassRepository, TrainerService trainerService, TrainerRepository trainerRepository) {
        this.workoutClassRepository = workoutClassRepository;
        this.trainerService = trainerService;
        this.trainerRepository = trainerRepository;
    }



    @Override
    public WorkoutClassDTO createWorkout(WorkoutClassDTO workoutClassDTO) {
        WorkoutClass workoutClass = mapToEntity(workoutClassDTO);
        WorkoutClass savedWorkoutClass = workoutClassRepository.save(workoutClass);
        return mapToDTO(savedWorkoutClass);
    }

    @Override
    public WorkoutClassDTO getWorkoutById(Long id) {
        WorkoutClass workoutClass = workoutClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client no t found with id " + id));
        return mapToDTO(workoutClass);
    }

    @Override
    public List<WorkoutClassDTO> getAllWorkout() {
        List<WorkoutClass> workoutsClass = workoutClassRepository.findAll();

        return workoutsClass.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public WorkoutClassDTO updateWorkout(Long id, WorkoutClassDTO workoutClassDTO) {

        WorkoutClass workoutClass = workoutClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout class not found with id: " + id));

        workoutClass.setDateTime(workoutClassDTO.getDateTime());
        workoutClass.setClassName(workoutClassDTO.getClassName());
        workoutClass.setDescription(workoutClassDTO.getDescription());
        workoutClass.setStatus(workoutClassDTO.getStatus());
        workoutClass.setImageUrl(workoutClassDTO.getImageUrl());
        workoutClass.setMaxCapacity(workoutClassDTO.getMaxCapacity());
        workoutClass.setRegisteredParticipants(workoutClassDTO.getRegisteredParticipants());
        workoutClass.setDuration(workoutClassDTO.getDuration());

        if (workoutClassDTO.getTrainerId() != null) {
            Trainer trainer = trainerRepository.findById(workoutClassDTO.getTrainerId())
                    .orElseThrow(() -> new RuntimeException("Trainer not found with id: " + workoutClassDTO.getTrainerId()));
            workoutClass.setTrainer(trainer);
        } else {
            workoutClass.setTrainer(null);
        }

        WorkoutClass updatedWorkoutClass = workoutClassRepository.save(workoutClass);
        return mapToDTO(updatedWorkoutClass);
    }


    @Override
    public void deleteWorkout(Long id) {

        workoutClassRepository.deleteById(id);

    }



    private WorkoutClass mapToEntity(WorkoutClassDTO dto) {
        WorkoutClass workoutClass = new WorkoutClass();
        workoutClass.setClassName(dto.getClassName());
        workoutClass.setDescription(dto.getDescription());
        workoutClass.setDateTime(dto.getDateTime());
        workoutClass.setStatus(dto.getStatus());
        workoutClass.setImageUrl(dto.getImageUrl());
        workoutClass.setMaxCapacity(dto.getMaxCapacity());
        workoutClass.setRegisteredParticipants(dto.getRegisteredParticipants());
        workoutClass.setDuration(dto.getDuration());


        if (dto.getTrainerId() != null) {

            Trainer trainer = trainerRepository.findById(dto.getTrainerId())
                    .orElseThrow(() -> new RuntimeException("Trainer not found with id: " + dto.getTrainerId()));
            workoutClass.setTrainer(trainer);
        }

        return workoutClass;
    }


    // ✅ Mapeo de WorkoutClass a WorkoutClassDTO
    private WorkoutClassDTO mapToDTO(WorkoutClass workoutClass) {

        WorkoutClassDTO dto = new WorkoutClassDTO();
        dto.setId(workoutClass.getId());
        dto.setClassName(workoutClass.getClassName());
        dto.setDescription(workoutClass.getDescription());
        dto.setDateTime(workoutClass.getDateTime());
        dto.setDuration(workoutClass.getDuration());
        dto.setImageUrl(workoutClass.getImageUrl());
        dto.setMaxCapacity(workoutClass.getMaxCapacity());
        dto.setRegisteredParticipants(workoutClass.getRegisteredParticipants());
        dto.setStatus(workoutClass.getStatus());

        // Extraer el ID del entrenador, si existe
        if (workoutClass.getTrainer() != null) {
            dto.setTrainerId(workoutClass.getTrainer().getId());
        }

        return dto;
    }





}
