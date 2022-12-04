package com.tppaas.powerworker.rabbit;


import com.tppaas.powerworker.entities.PowerVal;
import com.tppaas.powerworker.repository.PowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Worker {
    private static final Logger log = LoggerFactory.getLogger(Worker.class);

    @Autowired
    PowerService powerService;

    @RabbitListener(queues = "queue_oxy")
    public void receive(PowerVal powerVal){
        log.info("Received power value: " + powerVal.getVal());
        powerService.save(powerVal);
    }
}
