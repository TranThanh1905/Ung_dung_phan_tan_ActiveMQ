package com.example.demo.service;

import com.example.demo.model.ChatMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    private final SimpMessagingTemplate messagingTemplate;

    public MessageListener(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @JmsListener(destination = "chat.queue")
    public void receiveMessage(ChatMessage message) {
        messagingTemplate.convertAndSend("/topic/messages", message);
    }

}
