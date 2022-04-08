package com.ifmo.isdb.DB.repos;

import com.ifmo.isdb.DB.pojo.AdministrationMember;
import com.ifmo.isdb.DB.pojo.AdministrationMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface AdministrationMembersRepo extends JpaRepository<AdministrationMember,Integer> {
    @Query(value = "SELECT administration_id from administration_members where member_id = :id", nativeQuery = true)
    Integer getMember(Integer id);
    @Modifying
    @Query(value = "INSERT into administration_members (administration_id, member_id, member_mode) VALUES (:administration_id,:member_id,:member_mode)", nativeQuery = true)
    Integer addMember(Integer administration_id, Integer member_id, Integer member_mode);
}
