package com.example.gymmanagement.repository;

import com.example.gymmanagement.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
