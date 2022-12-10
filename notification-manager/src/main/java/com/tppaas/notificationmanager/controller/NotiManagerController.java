package com.tppaas.notificationmanager.controller;

import com.tppaas.notificationmanager.entities.Coach;
import com.tppaas.notificationmanager.entities.Emergency;
import com.tppaas.notificationmanager.repo.CoachService;
import com.tppaas.notificationmanager.websocket.SocketController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class NotiManagerController {

    @Autowired
    private SocketController socketController;

    @Autowired
    private CoachService coachService;

    @PostMapping()
    public Coach activeCoach(@RequestBody Coach coach){
        if(coach.isAvailable())
            return coachService.save(coach);
        else return null;
    }

    @PostMapping("/notify")
    public Emergency notify(@RequestBody Emergency emergency){
        //Iterable<Coach> coaches = coachService.getAvailable();
        socketController.send(emergency);
        return emergency;
    }
}
