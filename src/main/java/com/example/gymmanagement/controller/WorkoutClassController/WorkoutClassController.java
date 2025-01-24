package com.example.gymmanagement.controller.WorkoutClassController;


import com.example.gymmanagement.dto.WorkoutClassDTO;
import com.example.gymmanagement.model.WorkoutClass;
import com.example.gymmanagement.service.WorkoutClassService.WorkoutClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workoutclass")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})

public class WorkoutClassController {



    private final WorkoutClassService workoutClassService;


    @Autowired
    public WorkoutClassController(WorkoutClassService workoutClassService) {
        this.workoutClassService = workoutClassService;
    }



    @GetMapping()
    public ResponseEntity<List<WorkoutClassDTO>> getAllWorkoutClass() {
        List<WorkoutClassDTO> workoutClasses = workoutClassService.getAllWorkout();
        return ResponseEntity.ok(workoutClasses);
    }


    @PostMapping()
    public ResponseEntity<WorkoutClassDTO> createWorkoutClass(WorkoutClassDTO workoutClassDTO) {
        WorkoutClassDTO savedWorkoutClass = workoutClassService.createWorkout(workoutClassDTO);
        return ResponseEntity.ok(savedWorkoutClass);
    }


    @GetMapping("{id}")
    public ResponseEntity<WorkoutClassDTO> getOneWorkoutClass(Long id) {
        WorkoutClassDTO workoutClass = workoutClassService.getWorkoutById(id);
        return ResponseEntity.ok(workoutClass);
    }


    @PutMapping("{id}")
    public ResponseEntity<WorkoutClassDTO> updateWorkoutClass(Long id, WorkoutClassDTO workoutClass) {
        WorkoutClassDTO workoutClassUpdate = workoutClassService.updateWorkout(id, workoutClass);
        return ResponseEntity.ok(workoutClassUpdate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<WorkoutClassDTO> deleteWorkoutClass(Long id) {
         workoutClassService.deleteWorkout(id);
        return ResponseEntity.ok().build();
    }

}
