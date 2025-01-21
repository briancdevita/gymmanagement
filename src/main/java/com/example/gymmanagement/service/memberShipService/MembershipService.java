package com.example.gymmanagement.service.memberShipService;




import com.example.gymmanagement.dto.MembershipDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface MembershipService  {


    MembershipDTO  createMembership (MembershipDTO membershipDTO);
    MembershipDTO getMembershipById(Long id);
    List<MembershipDTO> getAllMembership();
    MembershipDTO updateMembership(Long id, MembershipDTO membershipDTO);
    void deleteMembership(Long id);

}
