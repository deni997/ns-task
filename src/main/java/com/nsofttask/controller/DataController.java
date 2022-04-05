package com.nsofttask.controller;

import com.nsofttask.service.DataService;
import com.nsofttask.service.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DataController {

    @Autowired
    Producer producer;

    private final DataService dataService;

    @PostMapping("/publish")
    public void sendMessage() {
        producer.publishToTopic("event", dataService.getEvents());
    }

    @GetMapping("/events")
    public String getEvents() {
        System.out.println(dataService.getEvents());
        return dataService.getEvents();
    }

    @GetMapping("/markets")
    public String getMarkets() {
        System.out.println(dataService.getMarkets());
        return dataService.getMarkets();
    }

}
