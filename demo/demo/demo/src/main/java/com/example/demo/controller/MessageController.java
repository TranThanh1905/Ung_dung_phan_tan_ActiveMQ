package com.example.demo.controller;

import com.example.demo.model.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Controller
public class MessageController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessage send(ChatMessage message) {
        message.setTimestamp(DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneId.systemDefault()).format(Instant.now()));
        jmsTemplate.convertAndSend("chat.queue", message);
        return message;
    }
}
