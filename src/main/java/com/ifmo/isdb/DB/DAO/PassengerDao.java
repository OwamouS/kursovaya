package com.ifmo.isdb.DB.DAO;

import com.ifmo.isdb.DB.pojo.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDao extends JpaRepository<Passenger,Integer> {
}
