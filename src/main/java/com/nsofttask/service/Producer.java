package com.nsofttask.service;

import com.nsofttask.util.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final String marketTopic = "market";
    private static final String marketData = FileReader.getResourceFileAsString("market.json");
    private static final String eventTopic = "event";
    private static final String eventData = FileReader.getResourceFileAsString("event.json");

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishToTopic(String topicName, String data) {
        System.out.println("Publishing to topic:\n" + topicName);
        this.kafkaTemplate.send(topicName, data);
    }
}
