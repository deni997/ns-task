package com.nsofttask.service;

import com.nsofttask.util.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    public static final String marketTopic = "market";
    public static final String marketData = FileReader.getResourceFileAsString("market.json");

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishToTopic() {
        System.out.println("Publishing to topic:\n" + marketTopic);
        this.kafkaTemplate.send(marketTopic, marketData);
    }
}
