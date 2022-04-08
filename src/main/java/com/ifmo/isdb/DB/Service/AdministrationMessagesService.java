package com.ifmo.isdb.DB.Service;

import com.ifmo.isdb.DB.pojo.AdministrationMessage;
import com.ifmo.isdb.DB.repos.AdministrationMessagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;

@Service
@Transactional
@Repository
public class AdministrationMessagesService {
    @Autowired
    AdministrationMessagesRepo administrationMessagesRepo;
    public ArrayList<AdministrationMessage> getMessages(Integer id){
        return administrationMessagesRepo.getMessages(id);
    }
    public void addMessage(Integer id, String message){
        administrationMessagesRepo.addMessage(id, message, LocalDate.now());
    }
}
