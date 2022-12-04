package com.tppaas.oxyworker.repository;

import com.tppaas.oxyworker.entities.OxyVal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public  class OxyService {

    @Autowired
    OxyRepo oxyrepo;

    public OxyVal save(OxyVal oxyVal){
        return oxyrepo.save(oxyVal);
    }
}
