package com.ifmo.isdb.DB.DAO;

import com.ifmo.isdb.DB.pojo.High_Council;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface High_CouncilDao extends JpaRepository<High_Council, Integer> {
}
