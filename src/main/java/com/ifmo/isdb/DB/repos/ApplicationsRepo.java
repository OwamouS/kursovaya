package com.ifmo.isdb.DB.repos;

import com.ifmo.isdb.DB.pojo.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface ApplicationsRepo extends JpaRepository<Application,Integer> {

    @Query(value = "INSERT into application (text, status) VALUES (:text, :status) RETURNING id",nativeQuery=true)
    Integer addApplication(String text, String status);

    @Query(value = "SELECT id, text, status, result FROM application join passenger_applications  on passenger_applications.application_id = application.id where passenger_applications.passenger_id = :passengerId",nativeQuery=true)
    ArrayList<Application> getApplications(Integer passengerId);

    @Query(value = "SELECT application.id, text, status, result FROM application join passenger_applications ca on application.id = ca.application_id join passenger cc on ca.passenger_id = cc.id where cc.race = :race ",nativeQuery=true)
    ArrayList<Application> getApplicationsForAdministration(String race);

    @Modifying
    @Query(value = "UPDATE application set status =:status, result=:result WHERE id=:id",nativeQuery=true)
    void setStatusAndResult(int id, String status, String result);

    @Query(value = "SELECT application.id, text, status, result FROM application where status = 'Need High_Council approval'",nativeQuery=true)
    ArrayList<Application> getApplicationsForHigh_Council();
}
