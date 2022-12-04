package com.tppaas.oxyworker.repository;

import com.tppaas.oxyworker.entities.OxyVal;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface OxyRepo extends MongoRepository<OxyVal,String> {
}
