package com.ifmo.isdb.DB.Service;

import com.ifmo.isdb.DB.pojo.Application;
import com.ifmo.isdb.DB.repos.ApplicationsRepo;
import com.ifmo.isdb.DB.repos.PassengerApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
@Repository
public class PassengerApplicationService {
    @Autowired
    PassengerApplicationRepo passengerApplicationRepo;
    @Autowired
    ApplicationsRepo applicationsRepo;
    public void addPassengerApplication(int passenger_id, int application_id ){
        passengerApplicationRepo.addPassengerApplication(passenger_id, application_id);
    }
    public ArrayList<Application> getApplications(Integer passengerId){
        return  applicationsRepo.getApplications(passengerId);
    }
}
