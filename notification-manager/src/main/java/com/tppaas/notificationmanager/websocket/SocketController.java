package com.tppaas.notificationmanager.websocket;

import com.tppaas.notificationmanager.entities.Emergency;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class SocketController {


    @MessageMapping("/emergency")
    @SendTo("/topic/emergency")
    public Emergency send(Emergency emergency){
        return emergency;
    }
}
