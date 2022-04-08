package com.ifmo.isdb.DB.Service;

import com.ifmo.isdb.DB.DAO.High_CouncilDao;
import com.ifmo.isdb.DB.pojo.High_Council;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Repository
public class High_CouncilService {
    @Autowired
    High_CouncilDao high_CouncilDao;
    public High_Council getHigh_CouncilById(Integer id){
        return high_CouncilDao.findAll().stream().filter(high_Councils->id.equals(high_Councils.getId())).findFirst().orElse(null);
    }
}
