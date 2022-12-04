package com.tppaas.powerworker.repository;

import com.tppaas.powerworker.entities.PowerVal;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PowerRepo extends MongoRepository<PowerVal,String> {
}
