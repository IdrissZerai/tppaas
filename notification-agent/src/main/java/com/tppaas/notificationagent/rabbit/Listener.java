package com.tppaas.notificationagent.rabbit;

import com.tppaas.notificationagent.entities.HeartRateVal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Listener {
    private static final Logger log = LoggerFactory.getLogger(Listener.class);

    @RabbitListener
    public void receive(HeartRateVal heartRateVal_emergency){
        log.info("Emergency received: "+ heartRateVal_emergency);

    }
}
