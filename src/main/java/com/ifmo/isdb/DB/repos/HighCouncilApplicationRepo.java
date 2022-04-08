package com.ifmo.isdb.DB.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface HighCouncilApplicationRepo extends JpaRepository<HighCouncilApplicationRepo, Integer> {
    @Modifying
    @Query(value = "INSERT into high_council_application (high_council_id, application_id, application_status) VALUES (:highapp_id, :application_id, :app_status)",nativeQuery=true)
    void addHighCouncilApplication(int highapp_id, int application_id, String app_status);
}
