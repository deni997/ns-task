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

    private static Gson gson;

    private String markets;
    private String events;
    private Market market;
    private MarketOutcome outcome;
    private Event event;

    public void init() throws JsonProcessingException {
        System.out.println("=============== Initializing data ===============");
        this.markets = loadMarkets();
        System.out.println(this.markets);
        this.events = loadEvents();
        System.out.println(this.events);
        market = Converter.marketToJson(this.markets);
        List<MarketOutcome> outcomes = market.getOutcomes(); // vraca niz objekata, koje treba premapirat u json objekte
         // ista stvar i sa event
        System.out.println("Market id: " + market.getId() + "\nMarket name: " + market.getName()
                + "\nMarket outcomes: " + outcomes + "\nMarket status:" + market.getStatus());
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
        String markets = FileReader.getResourceFileAsString("market.json");
        return markets;
    }

    private String loadEvents() {
        String events = FileReader.getResourceFileAsString("event.json");
        return events;
    }

}
