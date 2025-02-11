package com.example.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController   {
private final SimpMessagingTemplate template;
private final WebSocketSessionManager sessionManager;

    @Autowired
    public WebSocketController(SimpMessagingTemplate template, WebSocketSessionManager sessionManager) {
        this.template = template;

        this.sessionManager = sessionManager;
    }

        @MessageMapping("/message")
  public void HandleMessage(Message message){
        System.out.println("Received message from user "+message.getUser()+":"+message.getMessage());
        template.convertAndSend("/topic/messages",message);
            System.out.println("send message to /topic/messages:"+message.getUser()+":"+message.getMessage());


}

    @MessageMapping("/connect")
    public void ConnectUser(String User){
       sessionManager.AddUserName(User);
       sessionManager.broadcastusername();
        System.out.println(User+"connect");

    }

    @MessageMapping("/disconnect")
    public void disconnect(String User){
        sessionManager.AddUserName(User);
        sessionManager.broadcastusername();
        System.out.println(User+"disconnect");

    }



}
