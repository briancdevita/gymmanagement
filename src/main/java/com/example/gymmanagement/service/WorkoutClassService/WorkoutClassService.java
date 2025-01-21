package com.example.gymmanagement.service.WorkoutClassService;



import com.example.gymmanagement.dto.WorkoutClassDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface WorkoutClassService {

    WorkoutClassDTO createWorkout (WorkoutClassDTO workoutClassDTO);
    WorkoutClassDTO getWorkoutById(Long id);
    List<WorkoutClassDTO> getAllWorkout();
    WorkoutClassDTO updateWorkout(Long id, WorkoutClassDTO workoutClassDTO);
    void deleteWorkout(Long id);

}
