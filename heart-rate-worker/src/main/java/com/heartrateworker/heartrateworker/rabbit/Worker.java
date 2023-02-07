package com.heartrateworker.heartrateworker.rabbit;

import com.heartrateworker.heartrateworker.entities.HeartRateVal;
import com.heartrateworker.heartrateworker.repository.HeartDynamoRepo;
import com.heartrateworker.heartrateworker.repository.HeartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Worker {
    private static final Logger log = LoggerFactory.getLogger(Worker.class);

    @Autowired
    private HeartService heartService;

    @Autowired
    private HeartDynamoRepo heartDynamoRepo;

    @RabbitListener(queues = "queue_heart")
    public void receive(HeartRateVal heartRateVal){
        log.info("Received heartrate value: " + heartRateVal);
        heartService.save(heartRateVal);
        heartDynamoRepo.save(heartRateVal);
        log.info("Registred: " +heartRateVal );
    }

    @RabbitListener(queues = "queue_heart_emergency")
    public void receive2(HeartRateVal heartRateVal){
        log.info("Received emergency heartrate value: " + heartRateVal);
        heartService.save(heartRateVal);
        heartDynamoRepo.save(heartRateVal);
        log.info("Registred: " +heartRateVal );
    }
}
