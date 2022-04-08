package com.ifmo.isdb.DB.Service;

import com.ifmo.isdb.DB.repos.AdministrationMembersRepo;
import com.ifmo.isdb.DB.repos.AdministrationMessagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Repository
public class AdministrationMembersService {
    @Autowired
    AdministrationMembersRepo administrationMembersRepo;
    public  Integer getMember(Integer id){
        return administrationMembersRepo.getMember(id);
    }

    public Integer AddMember(Integer id,Integer mem_id, Integer mem_mode){
        return administrationMembersRepo.addMember(id,mem_id,mem_mode);
    }
}
