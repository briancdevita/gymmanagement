package com.example.gymmanagement.service.classRegistrationService;


import com.example.gymmanagement.dto.ClassRegistrationDTO;
import com.example.gymmanagement.model.ClassRegistration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassRegistrationService {

    ClassRegistrationDTO createClassRegistration(ClassRegistrationDTO classRegistrationDTO);
    ClassRegistrationDTO getClassRegistrationById(Long id);
    List<ClassRegistrationDTO> getAllClassRegistration();
    ClassRegistrationDTO updateClassRegistration(Long id, ClassRegistration classRegistration);
    void deleteClassRegistration(Long id);



}
