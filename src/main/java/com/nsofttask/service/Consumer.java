package com.nsofttask.service;

import com.google.gson.Gson;
import com.nsofttask.model.Event;
import com.nsofttask.model.Market;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @Autowired
    DataService dataService;

    @KafkaListener(topics = "event", groupId = "mygroup")
    public void consumeEventTopic(Event event) {
        dataService.updateEvents(event);
        System.out.println("Event updated.");
    }

    @KafkaListener(topics = {"market"}, groupId = "mygroup")
    public void consumeMarketTopic(Market market) {
        System.out.println("Consumed message:\n" + market);
    }

}
