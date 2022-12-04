package com.heartrateworker.heartrateworker.rabbit;

import com.heartrateworker.heartrateworker.entities.HeartRateVal;
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

    @RabbitListener(queues = "queue_oxy")
    public void receive(HeartRateVal heartRateVal){
        log.info("Received oxy value: " + heartRateVal);
        heartService.save(heartRateVal);
    }
}
