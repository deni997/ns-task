package com.nsofttask.controller;

import com.google.gson.Gson;
import com.nsofttask.model.Event;
import com.nsofttask.model.Market;
import com.nsofttask.service.DataService;
import com.nsofttask.service.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/demo")
@RequiredArgsConstructor
@Validated
public class KafkaDemoController {

    @Autowired
    Producer producer;

    private final Gson gson = new Gson();
    private final DataService dataService;

    @PostMapping("/publish/event")
    public ResponseEntity<Event> sendEventMessage(@Valid @RequestBody Event event) {
        // Test file, for using uncomment and remove parameter
        // Event event = gson.fromJson(FileReader.getResourceFileAsString("event.json"), Event.class);

        System.out.println("Publishing event to topic");
        producer.publishEventToTopic("event", event);
        return ResponseEntity.status(HttpStatus.CREATED).body(event);
    }

    @PostMapping("/publish/market")
    public ResponseEntity<Market> sendMarketMessage(@Valid @RequestBody Market market) {
        // Test file, for using uncomment and remove parameter
        // Market market = gson.fromJson(FileReader.getResourceFileAsString("market.json"), Market.class);

        producer.publishMarketToTopic("market", market);
        return ResponseEntity.status(HttpStatus.CREATED).body(market);
    }

}
