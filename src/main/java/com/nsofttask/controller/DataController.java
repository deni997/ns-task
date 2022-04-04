package com.nsofttask.controller;

import com.nsofttask.service.DataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/events")
    public String getEvents() {
        return dataService.loadFile("events.json");
    }

    @GetMapping("/markets")
    public String getMarkets() {
        return dataService.loadFile("markets.json");
    }

    @GetMapping("/market")
    public String getMarket() {
        return dataService.loadFile("market.json");
    }

    @GetMapping("/event")
    public String getEvent() {
        return dataService.loadFile("event.json");
    }
}
