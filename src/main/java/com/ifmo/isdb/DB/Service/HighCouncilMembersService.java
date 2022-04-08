package com.ifmo.isdb.DB.Service;

import com.ifmo.isdb.DB.repos.HighCouncilApplicationRepo;
import com.ifmo.isdb.DB.repos.HighCouncilMembersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Repository
public class HighCouncilMembersService {
    @Autowired
    HighCouncilMembersRepo highCouncilMembersRepo;
    public Integer getMember(Integer id){
        return highCouncilMembersRepo.getMember(id);
    }

    public Integer AddMember(Integer id,Integer mem_id, Integer mem_mode){
        return highCouncilMembersRepo.addMember(id,mem_id,mem_mode);
    }
}
