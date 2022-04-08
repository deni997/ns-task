package com.nsofttask.controller;

import com.google.gson.Gson;
import com.nsofttask.model.Event;
import com.nsofttask.model.Market;
import com.nsofttask.service.DataService;
import com.nsofttask.service.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
@RequiredArgsConstructor
public class KafkaDemoController {

    @Autowired
    Producer producer;

    private final Gson gson = new Gson();
    private final DataService dataService;

    @PostMapping("/publish/event")
    public void sendEventMessage(@RequestBody Event event) {
        // Test file, for using uncomment and remove parameter
        // Event event = gson.fromJson(FileReader.getResourceFileAsString("event.json"), Event.class);

        System.out.println("Publishing event to topic");
        producer.publishEventToTopic("event", event);
    }

    @PostMapping("/publish/market")
    public void sendMarketMessage(@RequestBody Market market) {
        // Test file, for using uncomment and remove parameter
        // Market market = gson.fromJson(FileReader.getResourceFileAsString("market.json"), Market.class);

        producer.publishMarketToTopic("market", market);
    }

}
