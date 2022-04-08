package com.nsofttask.controller;

import com.nsofttask.model.Event;
import com.nsofttask.model.Market;
import com.nsofttask.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DataController {

    private final DataService dataService;

    @GetMapping("/events/selectedDate={date}")
    public List<Event> getEvents(@PathVariable("date") String date) {
        return dataService.getEvents(date);
    }

    @GetMapping("/markets")
    public List<Market> getMarkets() {
        return dataService.getMarkets();
    }

}
