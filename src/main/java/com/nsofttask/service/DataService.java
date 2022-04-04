package com.nsofttask.service;


import com.nsofttask.util.FileReader;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    public void init() {
        String markets = this.loadMarkets();
        String events = this.loadEvents();
        if(markets != null) System.out.println(markets);
        if(events != null) System.out.println(events);
    }

    private String loadMarkets() {
        String markets = FileReader.getResourceFileAsString("markets.json");
        return markets;
    }

    private String loadEvents() {
        String events = FileReader.getResourceFileAsString("events.json");
        return events;
    }

}
