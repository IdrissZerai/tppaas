package com.tppaas.powerworker.repository;

import com.tppaas.powerworker.entities.PowerVal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public  class PowerService {

    @Autowired
    PowerRepo powerRepo;

    public PowerVal save(PowerVal powerVal){
        return powerRepo.save(powerVal);
    }
}
