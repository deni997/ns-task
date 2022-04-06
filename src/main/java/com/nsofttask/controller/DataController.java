package com.nsofttask.controller;

import com.nsofttask.model.Event;
import com.nsofttask.model.Market;
import com.nsofttask.service.DataService;
import com.nsofttask.service.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DataController {

    @Autowired
    Producer producer;

    private final DataService dataService;

    @PostMapping("/publish")
    public void sendMessage() {

    }

    @GetMapping("/events")
    public Event[] getEvents() {
        System.out.println(dataService.getEvents());
        return dataService.getEvents();
    }

    @GetMapping("/markets")
    public Market[] getMarkets() {
        System.out.println(dataService.getMarkets());
        return dataService.getMarkets();
    }

    @GetMapping("/event")
    public Event getEvent() {
        System.out.println(dataService.getEvent());
        return dataService.getEvent();
    }

    @GetMapping("/market")
    public Market getMarket() {
        System.out.println(dataService.getMarket());
        return dataService.getMarket();
    }


}
