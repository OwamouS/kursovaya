package com.ifmo.isdb.DB.Service;

import com.ifmo.isdb.DB.DAO.PassengerDao;
import com.ifmo.isdb.DB.pojo.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Repository
public class PassengerService {

    @Autowired
    PassengerDao passengerDao;

    public List<Passenger> getAllPassengers(){
        return this.passengerDao.findAll();
    }
    public Passenger addPassenger(Passenger passenger){
        BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
        passenger.setPassword(bcryptEncoder.encode(passenger.getPassword()));
        return  passengerDao.save(passenger);
    }
    public Passenger getPassenger(String login){
        return passengerDao.findAll().stream().filter(passengers->login.equals(passengers.getLogin())).findFirst().orElse(null);
    }
    public boolean isPassenger(String login){
        return passengerDao.findAll().stream().anyMatch(passengers -> login.equals(passengers.getLogin()));
    }
}
