package com.tppaas.notificationagent.rabbit;

import com.tppaas.notificationagent.entities.Emergency;
import com.tppaas.notificationagent.entities.HeartRateVal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class Listener {
    private static final Logger log = LoggerFactory.getLogger(Listener.class);
    RestTemplate restTemplate = new RestTemplate();
    URI uri = new URI("http://host.docker.internal:8031" + "/notify/");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public Listener() throws URISyntaxException {
    }

    @RabbitListener(queues = "queue_heart_emergency")
    public void receive(HeartRateVal heartRateVal_emergency){
        log.info("Emergency received: "+ heartRateVal_emergency);
        Emergency emergency_heart = new Emergency("EM_"+heartRateVal_emergency.getId(),
                heartRateVal_emergency.getUser_id(),
                java.time.LocalDate.now().toString(),
                "HEART_EMERGENCY",
                "HEM_BPM_"+
                heartRateVal_emergency.getBPM()
                );
        Emergency response = restTemplate.postForObject(uri,
                emergency_heart,Emergency.class);
        log.info("Emergency sent to manager: "+ emergency_heart);
    }
}
