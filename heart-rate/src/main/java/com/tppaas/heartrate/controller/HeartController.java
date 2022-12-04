package com.tppaas.heartrate.controller;

import com.tppaas.heartrate.entities.HeartRateVal;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HeartController {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue1;

    @PostMapping("")
    public HeartRateVal registerOxy(@RequestBody HeartRateVal heartRateVal) {
        template.convertAndSend(queue1.getName(), heartRateVal);
        return heartRateVal;
    }
}
