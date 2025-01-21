package com.example.gymmanagement.service.classRegistrationService;


import com.example.gymmanagement.dto.ClassRegistrationDTO;
import com.example.gymmanagement.dto.ClientDTO;
import com.example.gymmanagement.model.ClassRegistration;
import com.example.gymmanagement.model.Client;
import com.example.gymmanagement.repository.ClassRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassRegistrationServiceImpl implements  ClassRegistrationService{



    private final ClassRegistrationRepository classRegistrationRepository;



    @Autowired
    public ClassRegistrationServiceImpl(ClassRegistrationRepository classRegistrationRepository) {
        this.classRegistrationRepository = classRegistrationRepository;
    }


    @Override
    public ClassRegistrationDTO createClassRegistration(ClassRegistrationDTO classRegistrationDTO) {
        ClassRegistration classRegistration = mapToEntity(classRegistrationDTO);
        ClassRegistration savedClassRegistration = classRegistrationRepository.save(classRegistration);
        return mapToDTO(savedClassRegistration);
    }




    @Override
    public ClassRegistrationDTO getClassRegistrationById(Long id) {
        ClassRegistration classRegistration = classRegistrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found id: " + id));

        return mapToDTO(classRegistration);
    }

    @Override
    public List<ClassRegistrationDTO> getAllClassRegistration() {
        List <ClassRegistration> classRegistrations = classRegistrationRepository.findAll();

        return classRegistrations.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ClassRegistrationDTO updateClassRegistration(Long id, ClassRegistration classRegistration) {
        ClassRegistration currentClassRegistration = classRegistrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found id: "+ id));

        currentClassRegistration.setWorkoutClass(classRegistration.getWorkoutClass());
        currentClassRegistration.setRegistrationDate(classRegistration.getRegistrationDate());


        ClassRegistration updateClassRegistration = classRegistrationRepository.save(currentClassRegistration);

        return mapToDTO(updateClassRegistration);
    }

    @Override
    public void deleteClassRegistration(Long id) {
        classRegistrationRepository.deleteById(id);
    }


    private ClassRegistration mapToEntity(ClassRegistrationDTO dto) {
        ClassRegistration classRegistration = new ClassRegistration();
        classRegistration.setRegistrationDate(dto.getRegistrationDate());
        classRegistration.setWorkoutClass(dto.getWorkoutClass());
        return classRegistration;
    }


    private ClassRegistrationDTO mapToDTO(ClassRegistration classRegistration) {
        ClassRegistrationDTO dto = new ClassRegistrationDTO();
        dto.setId(classRegistration.getId());
        dto.setWorkoutClass(classRegistration.getWorkoutClass());
        dto.setRegistrationDate(classRegistration.getRegistrationDate());
        return dto;
    }
}
