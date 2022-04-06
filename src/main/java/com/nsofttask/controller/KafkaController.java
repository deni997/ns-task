package com.nsofttask.controller;

import com.nsofttask.model.Event;
import com.nsofttask.model.Market;
import com.nsofttask.service.DataService;
import com.nsofttask.service.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class KafkaController {

    @Autowired
    Producer producer;

    private final DataService dataService;

    @PostMapping("/publish/event")
    public void sendEventMessage() {
        Event eventData = dataService.getEvent();
        producer.publishEventToTopic("event", eventData);
    }

    @PostMapping("/publish/market")
    public void sendMarketMessage() {
        Market marketData = dataService.getMarket();
        producer.publishMarketToTopic("market", marketData);
    }
}
