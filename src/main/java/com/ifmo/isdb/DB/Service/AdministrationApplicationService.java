package com.ifmo.isdb.DB.Service;

import com.ifmo.isdb.DB.pojo.Application;
import com.ifmo.isdb.DB.repos.ApplicationsRepo;
import com.ifmo.isdb.DB.repos.AdministrationApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
@Repository
public class AdministrationApplicationService {
    @Autowired
    ApplicationsRepo applicationsRepo;
    @Autowired
    AdministrationApplicationRepo administrationApplicationRepo;
    public ArrayList<Application> getApplicationsForAdministration(String race){
        return  applicationsRepo.getApplicationsForAdministration(race);
    }
    public void setStatusAndResult(int id, String status, String result){
        applicationsRepo.setStatusAndResult(id, status, result);
    }
    public void addAdministrationApplication(int administration_id, int application_id ){
        administrationApplicationRepo.addAdministrationApplication(administration_id, application_id);
    }
    public boolean existsAdministrationApplicationById(Integer id){
        return administrationApplicationRepo.findAll().stream().anyMatch(admins->id.equals(admins.getApplication_id()));
    }
}
