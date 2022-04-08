package com.ifmo.isdb.DB.repos;

import com.ifmo.isdb.DB.pojo.Application;
import com.ifmo.isdb.DB.pojo.PassengerApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface PassengerApplicationRepo extends JpaRepository<PassengerApplication,Long> {
    @Modifying
    @Query(value = "INSERT into passenger_applications (passenger_id, application_id) VALUES (:passenger_id, :application_id)",nativeQuery=true)
    void addPassengerApplication(int passenger_id, int application_id);
}
