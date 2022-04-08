package com.ifmo.isdb.DB.repos;

import com.ifmo.isdb.DB.pojo.AdministrationApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AdministrationApplicationRepo extends JpaRepository<AdministrationApplication,Integer> {
    @Modifying
    @Query(value = "INSERT into administration_applications (administration_id, application_id) VALUES (:administration_id, :application_id)",nativeQuery=true)
    void addAdministrationApplication(int administration_id, int application_id);

}
