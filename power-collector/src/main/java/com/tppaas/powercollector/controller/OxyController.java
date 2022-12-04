package com.tppaas.powercollector.controller;

import com.tppaas.powercollector.entities.PowerVal;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class OxyController {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue1;

    @PostMapping("")
    public PowerVal registerOxy(@RequestBody PowerVal powerVal) {
        template.convertAndSend(queue1.getName(), powerVal);
        return powerVal;
    }
}
