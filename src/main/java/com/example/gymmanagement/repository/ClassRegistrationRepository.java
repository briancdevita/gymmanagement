package com.example.gymmanagement.repository;


import com.example.gymmanagement.model.ClassRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ClassRegistrationRepository extends JpaRepository<ClassRegistration, Long> {
}
