package com.ifmo.isdb.DB.Service;

import com.ifmo.isdb.DB.pojo.Application;
import com.ifmo.isdb.DB.repos.ApplicationsRepo;
import com.ifmo.isdb.DB.repos.HighCouncilApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
@Repository
public class High_CouncilApplicationService {
    @Autowired
    ApplicationsRepo applicationsRepo;
    @Autowired
    HighCouncilApplicationRepo highCouncilApplicationRepo;
    public ArrayList<Application> getApplicationsForHigh_Council(){
        return applicationsRepo.getApplicationsForHigh_Council();
    }
    public void setHigh_CouncilStatusAndResult(int id, String status, String result){
        applicationsRepo.setStatusAndResult(id, status, result);
    }
    public void addHighCouncilApplication(int highIdd, int appId, String status){
        highCouncilApplicationRepo.addHighCouncilApplication(highIdd,appId,status);
    }

}
