package com.nsofttask.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.nsofttask.model.Event;
import com.nsofttask.model.Market;
import com.nsofttask.model.MarketOutcome;
import com.nsofttask.util.Converter;
import com.nsofttask.util.FileReader;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    private static Gson gson = new Gson();

    private Event[] events;
    private Market[] markets;
    private Event event;
    private Market market;

    public void init() {
        System.out.println("====================== Initializing data ======================");
        this.events = gson.fromJson(loadEventsJsonFromFile(), Event[].class);
        this.markets = gson.fromJson(loadMarketsJsonFromFile(), Market[].class);
        this.event = gson.fromJson(loadEventJsonFromFile(), Event.class);
        this.market = gson.fromJson(loadMarketJsonFromFile(), Market.class);
        System.out.println("Events initialized");
        for(Event event : events) {
            System.out.println(gson.toJson(event));
        }
        System.out.println("Markets initialized");
        for(Market market : markets) {
            System.out.println(gson.toJson(market));
        }

        System.out.println("Single Event initialized");
        System.out.println(gson.toJson(event));
        System.out.println("Single Market initialized");
        System.out.println(gson.toJson(market));

        System.out.println("===============================================================");
    }

    private String loadMarketsJsonFromFile() {
        return FileReader.getResourceFileAsString("markets.json");
    }

    private String loadEventsJsonFromFile() {
        return FileReader.getResourceFileAsString("events.json");
    }

    private String loadMarketJsonFromFile() {
        return FileReader.getResourceFileAsString("market.json");
    }

    private String loadEventJsonFromFile() {
        return FileReader.getResourceFileAsString("event.json");
    }

    public Event[] getEvents() {
        return events;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }

    public Market[] getMarkets() {
        return markets;
    }

    public void setMarkets(Market[] markets) {
        this.markets = markets;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }
}
