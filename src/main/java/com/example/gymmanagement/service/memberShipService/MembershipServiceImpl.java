package com.example.gymmanagement.service.memberShipService;


import com.example.gymmanagement.dto.MembershipDTO;
import com.example.gymmanagement.dto.TrainerDTO;
import com.example.gymmanagement.model.Membership;
import com.example.gymmanagement.model.Trainer;
import com.example.gymmanagement.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MembershipServiceImpl implements  MembershipService {




    private final MembershipRepository membershipRepository;


    @Autowired
    public MembershipServiceImpl(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }


    @Override
    public MembershipDTO createMembership(MembershipDTO membershipDTO) {
        System.out.println(membershipDTO);
        Membership membership = mapToEntity(membershipDTO);

        Membership savedMembership = membershipRepository.save(membership);

        return mapToDTO(savedMembership);
    }

    @Override
    public MembershipDTO getMembershipById(Long id) {
        Membership membership = membershipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membership not found with id: " + id));

        return mapToDTO(membership);
    }

    @Override
    public List<MembershipDTO> getAllMembership() {
        List<Membership> memberships  = membershipRepository.findAll();
        return memberships.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public MembershipDTO updateMembership(Long id, MembershipDTO membershipDTO) {
        Membership membership = membershipRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Membership not found with id: " + id));

        membership.setClient(membershipDTO.getClient());
        membership.setMembershipType(membershipDTO.getMembershipType());
        membership.setEndDate(membershipDTO.getEndDate());
        membership.setStartDate(membershipDTO.getStartDate());

        Membership updateMembership  = membershipRepository.save(membership);

        return mapToDTO(updateMembership);
    }

    @Override
    public void deleteMembership(Long id) {
        membershipRepository.deleteById(id);
    }







    private Membership mapToEntity(MembershipDTO dto) {
        Membership membership = new Membership();
        membership.setMembershipType(dto.getMembershipType());
        membership.setClient(dto.getClient());
        membership.setStartDate(dto.getStartDate());
        membership.setEndDate(dto.getEndDate());
        return membership;
    }

    private MembershipDTO mapToDTO(Membership membership) {
        MembershipDTO dto = new MembershipDTO();
        dto.setId(membership.getId());
        dto.setClient(membership.getClient());
        dto.setStartDate(membership.getStartDate());
        dto.setEndDate(membership.getEndDate());
        dto.setMembershipType(membership.getMembershipType());
        return dto;
    }
}
