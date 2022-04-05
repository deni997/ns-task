package com.nsofttask.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "market", groupId = "mygroup")
    public void consumeFromTopic(String message) {
        System.out.println("Consumed message:\n" + message);
    }
}
