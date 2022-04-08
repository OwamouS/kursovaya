package com.ifmo.isdb.DB.Service;

import com.ifmo.isdb.DB.DAO.PassengerDao;
import com.ifmo.isdb.DB.DAO.AdministrationDao;
import com.ifmo.isdb.DB.pojo.Passenger;
import com.ifmo.isdb.DB.pojo.Administration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Repository
public class AdministrationService {

    @Autowired
    PassengerDao passengerDao;
    @Autowired
    AdministrationDao administrationDao;

    public List<Administration> getAllEmbassies(){
        return this.administrationDao.findAll();
    }
    public Administration addAdministration(Administration administration){
        return  administrationDao.save(administration);
    }

    public Administration getAdministrationByRace(String race){
        return administrationDao.findAll().stream().filter(administrations->race.equals(administrations.getRace())).findFirst().orElse(null);
    }

}
