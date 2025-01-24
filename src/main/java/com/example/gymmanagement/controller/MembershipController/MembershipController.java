package com.example.gymmanagement.controller.MembershipController;


import com.example.gymmanagement.dto.MembershipDTO;
import com.example.gymmanagement.service.memberShipService.MembershipService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memberships/")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})

public class MembershipController {



    private final MembershipService membershipService;


    @Autowired
    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }



    //Get all Memberships
    @GetMapping
    public ResponseEntity<List<MembershipDTO>> getAllMemberships() {
        List <MembershipDTO> membershipsDTO = membershipService.getAllMembership();
        return ResponseEntity.ok(membershipsDTO);
     }


     //Create Membership
    @PostMapping
    public ResponseEntity<MembershipDTO> createMembership ( MembershipDTO membershipDTO) {
        MembershipDTO membershipDTO1 = membershipService.createMembership(membershipDTO);
        return ResponseEntity.ok(membershipDTO1);
    }


    @GetMapping("{id}")
    public ResponseEntity<MembershipDTO> getOneMembership (Long id) {
        MembershipDTO membership = membershipService.getMembershipById(id);
        return ResponseEntity.ok(membership);
    }

    @PutMapping("{id}")
    public  ResponseEntity<MembershipDTO> updateMembership(Long id, MembershipDTO membershipDTO) {
        MembershipDTO updateMembership = membershipService.updateMembership(id, membershipDTO);
        return ResponseEntity.ok(updateMembership);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<MembershipDTO> deleteMembership(Long id) {

        membershipService.deleteMembership(id);

      return   ResponseEntity.noContent().build();

    }
    

}
