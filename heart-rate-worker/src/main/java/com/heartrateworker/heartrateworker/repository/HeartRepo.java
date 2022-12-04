package com.heartrateworker.heartrateworker.repository;

import com.heartrateworker.heartrateworker.entities.HeartRateVal;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface HeartRepo extends MongoRepository<HeartRateVal,String> {
}
