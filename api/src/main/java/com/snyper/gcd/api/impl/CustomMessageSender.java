package com.snyper.gcd.api.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snyper.gcd.api.rest.dto.InputRequestWithIdDTO;

@Service
public class CustomMessageSender {

    private final RabbitTemplate rabbitTemplate;
    
    @Autowired
    public CustomMessageSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
 
    public void sendMessage(InputRequestWithIdDTO message) {
        rabbitTemplate.convertAndSend("gcd-request", "snyper.gcd.request", message);
    }
}
