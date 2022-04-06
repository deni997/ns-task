package com.nsofttask.service;

import com.google.gson.Gson;
import com.nsofttask.model.Event;
import com.nsofttask.model.Market;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = {"market", "event"}, groupId = "mygroup")
    public void consumeFromTopic(Market market) {
        System.out.println("Consumed message:\n" + market);
    }
}
