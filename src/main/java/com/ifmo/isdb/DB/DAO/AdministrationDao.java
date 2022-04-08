package com.ifmo.isdb.DB.DAO;

import com.ifmo.isdb.DB.pojo.Administration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrationDao extends JpaRepository<Administration,Integer> {
}
