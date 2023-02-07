package com.heartrateworker.heartrateworker.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.heartrateworker.heartrateworker.entities.HeartRateVal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HeartDynamoRepo {


    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public HeartRateVal save(HeartRateVal heartRateVal){
        dynamoDBMapper.save(heartRateVal);
        return heartRateVal;
    }
}
