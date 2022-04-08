package com.ifmo.isdb.DB.repos;

import com.ifmo.isdb.DB.pojo.Application;
import com.ifmo.isdb.DB.pojo.AdministrationMessage;
import com.ifmo.isdb.DB.pojo.AdministrationMessageKey;
import com.ifmo.isdb.DB.pojo.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.ArrayList;

public interface AdministrationMessagesRepo  extends JpaRepository<AdministrationMessage, AdministrationMessageKey> {
    @Query(value = "SELECT * from administration_messages where administration_recipient_id =:id", nativeQuery = true)
    ArrayList<AdministrationMessage> getMessages(Integer id);

    @Modifying
    @Query(value = "Insert into administration_messages values (:id, :message, :time)", nativeQuery = true)
    void addMessage(Integer id, String message, LocalDate time);
}
