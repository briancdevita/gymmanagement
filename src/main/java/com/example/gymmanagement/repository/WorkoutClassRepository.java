package com.example.gymmanagement.repository;


import com.example.gymmanagement.model.WorkoutClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutClassRepository  extends JpaRepository<WorkoutClass, Long> {

}
