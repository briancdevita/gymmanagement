package com.example.gymmanagement.controller.ClassRegistrationController;


import com.example.gymmanagement.dto.ClassRegistrationDTO;
import com.example.gymmanagement.model.ClassRegistration;
import com.example.gymmanagement.service.classRegistrationService.ClassRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classregistration")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class ClassRegistrationController {





    private final ClassRegistrationService classRegistrationService;


    @Autowired
    public ClassRegistrationController(ClassRegistrationService classRegistrationService) {
        this.classRegistrationService = classRegistrationService;
    }



    @GetMapping()
    public ResponseEntity<List<ClassRegistrationDTO>>  getAllClassRegistration(){
        List<ClassRegistrationDTO> classRegistrationDTO = classRegistrationService.getAllClassRegistration();
        return ResponseEntity.ok(classRegistrationDTO);
    }


    @PostMapping()
    public ResponseEntity<ClassRegistrationDTO> createClassRegistration(ClassRegistrationDTO classRegistrationDTO){
        ClassRegistrationDTO savedClassRegistration = classRegistrationService.createClassRegistration(classRegistrationDTO);
        return ResponseEntity.ok(savedClassRegistration);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClassRegistrationDTO> getOneClassRegistration(Long id){
        ClassRegistrationDTO classRegistration = classRegistrationService.getClassRegistrationById(id);
        return ResponseEntity.ok(classRegistration);
    }


    @PutMapping("{id}")
    public ResponseEntity<ClassRegistrationDTO> updateClassRegistration(Long id, ClassRegistration classRegistration){
        ClassRegistrationDTO classRegistrationUpdate = classRegistrationService.updateClassRegistration(id, classRegistration);
        return ResponseEntity.ok(classRegistrationUpdate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ClassRegistrationDTO> deleteClassRegistration(Long id){
         classRegistrationService.deleteClassRegistration(id);
        return ResponseEntity.ok().build();
    }



}
