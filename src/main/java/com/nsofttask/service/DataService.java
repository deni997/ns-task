package com.nsofttask.service;


import com.nsofttask.util.FileReader;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    private String markets;
    private String events;

    public void init() throws ParseException {
        System.out.println("=============== Initializing data ===============");
        this.markets = loadMarkets();
        System.out.println(FileReader.convertStringToJson(this.markets));
        this.events = loadEvents();
        System.out.println(FileReader.convertStringToJson(this.events));
        System.out.println("=============== Data initialized ===============");

    }

    public String getMarkets() {
        return markets;
    }

    public String getEvents() {
        return events;
    }

    public void setMarkets(String markets) {
        this.markets = markets;
    }

    public void setEvents(String events) {
        this.events = events;
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
