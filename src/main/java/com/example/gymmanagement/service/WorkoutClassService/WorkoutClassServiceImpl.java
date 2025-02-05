package com.example.gymmanagement.service.WorkoutClassService;


import com.example.gymmanagement.dto.TrainerDTO;
import com.example.gymmanagement.dto.WorkoutClassDTO;
import com.example.gymmanagement.model.Trainer;
import com.example.gymmanagement.model.WorkoutClass;
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


    @Autowired
    public WorkoutClassServiceImpl(WorkoutClassRepository workoutClassRepository, TrainerService trainerService) {
        this.workoutClassRepository = workoutClassRepository;
        this.trainerService = trainerService;
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
                .orElseThrow(()-> new RuntimeException("Client no t found with id" + id));

        workoutClass.setDateTime(workoutClassDTO.getDateTime());
        workoutClass.setClassName(workoutClassDTO.getClassName());
        workoutClass.setDescription(workoutClassDTO.getDescription());
        workoutClass.setTrainer(trainerService.mapTrainerToEntity(workoutClassDTO.getTrainer())); 


        WorkoutClass updateWorkoutClass = workoutClassRepository.save(workoutClass);

        return mapToDTO(updateWorkoutClass);
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


        if (dto.getTrainer() != null) {
            workoutClass.setTrainer(trainerService.mapTrainerToEntity(dto.getTrainer()));
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

        // ✅ Mapear correctamente el entrenador solo si existe
        if (workoutClass.getTrainer() != null) {
            dto.setTrainer(trainerService.mapTrainerToDTO(workoutClass.getTrainer()));
        }

        return dto;
    }




}
