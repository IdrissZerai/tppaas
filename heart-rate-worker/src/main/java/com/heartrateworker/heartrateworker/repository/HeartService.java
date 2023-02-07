package com.heartrateworker.heartrateworker.repository;

import com.heartrateworker.heartrateworker.entities.HeartRateVal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public  class HeartService {

    @Autowired
    HeartRepo heartRepo;

    public HeartRateVal save(HeartRateVal heartRateVal){
        return heartRepo.save(heartRateVal);
    }
}
