package com.tppaas.oxyworker.rabbit;

import com.tppaas.oxyworker.entities.OxyVal;
import com.tppaas.oxyworker.repository.OxyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Worker {
    private static final Logger log = LoggerFactory.getLogger(Worker.class);

    @Autowired
    OxyService oxyService;

    @RabbitListener(queues = "queue_oxy")
    public void receive(OxyVal oxyVal) throws InterruptedException{
        log.info("Received oxy value: " + oxyVal);
        oxyService.save(oxyVal);
    }
}
