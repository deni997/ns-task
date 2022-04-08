package com.nsofttask.controller;

import com.nsofttask.model.Event;
import com.nsofttask.model.Market;
import com.nsofttask.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DataController {

    private final DataService dataService;

    @GetMapping("/events")
    public List<Event> getEvents(@RequestParam(required = false) String date) {
        return dataService.getEvents(date);
    }

    @GetMapping("/markets")
    public List<Market> getMarkets() {
        return dataService.getMarkets();
    }

}
