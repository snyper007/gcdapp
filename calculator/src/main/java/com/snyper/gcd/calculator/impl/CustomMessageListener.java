package com.snyper.gcd.calculator.impl;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomMessageListener {

    private final ObjectMapper objectMapper = new ObjectMapper();


    public void receive(byte[] message) {
        try {
            InputRequestWithIdDTO input = objectMapper.readValue(message, InputRequestWithIdDTO.class);
            System.out.println("RECEIVED => " + input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
