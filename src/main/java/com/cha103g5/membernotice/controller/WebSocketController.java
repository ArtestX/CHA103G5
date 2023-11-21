package com.cha103g5.membernotice.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

import com.cha103g5.membernotice.model.WebSocketMessage;

@Controller
@EnableWebSocketMessageBroker
public class WebSocketController {
    
	@MessageMapping("/sendToAll")
    @SendTo("/topic/messages")
    public WebSocketMessage sendToAll(WebSocketMessage message) {
        System.out.println("Received message: " + message.getMessage());
        return new WebSocketMessage(message.getMessage());
    }
    
    @GetMapping("/memberNotice/backendMemberNotice")
    public String ShowBackendMemberNotice(){
        return "memberNotice/backendMemberNotice";
    }

    @GetMapping("/memberNotice/frontMemberNotice")
    public String ShowFrontMemberNotice(){
        return "memberNotice/frontMemberNotice";
    }
}

