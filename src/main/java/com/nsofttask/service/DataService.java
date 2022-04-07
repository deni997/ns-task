package com.nsofttask.service;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nsofttask.enumerations.Status;
import com.nsofttask.model.Event;
import com.nsofttask.model.Market;
import com.nsofttask.util.FileReader;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {

    private static Gson gson = new Gson();

    private List<Event> events;
    private List<Market> markets;

    public void init() {
        System.out.println("====================== Initializing data ======================");
        Type eventListType = new TypeToken<ArrayList<Event>>() {}.getType();
        Type marketListType = new TypeToken<ArrayList<Market>>() {}.getType();
        this.events = gson.fromJson(loadEventsJsonFromFile(), eventListType);
        this.markets = gson.fromJson(loadMarketsJsonFromFile(), marketListType);
        System.out.println("Events initialized");
        for(Event event : events) {
            System.out.println(gson.toJson(event));
        }
        System.out.println("Markets initialized");
        for(Market market : markets) {
            System.out.println(gson.toJson(market));
        }
        System.out.println("===============================================================");
    }

    private String loadMarketsJsonFromFile() {
        return FileReader.getResourceFileAsString("markets.json");
    }

    private String loadEventsJsonFromFile() {
        return FileReader.getResourceFileAsString("events.json");
    }

    public List<Event> getEvents() {

        // Datum

        List<Event> eventsDto = new ArrayList<>();
        this.events.forEach(e -> {
            if (e.getStatus() == Status.ACTIVE) {
                eventsDto.add(e);
            }
        });

        return eventsDto;
    }

    public List<Market> getMarkets() {

        List<Market> marketsDto = new ArrayList<>();
        this.markets.forEach(m -> {
            if (m.getStatus() == Status.ACTIVE) {
                marketsDto.add(m);
            }
        });

        return marketsDto;
    }

    public void updateEvents(Event event) {

        System.out.println("Update events: " + event.getName());

        Event existingEvent = this.events.stream()
                .filter(e -> event.getId().equals(e.getId()))
                .findAny()
                .orElse(null);

        if (existingEvent != null) {
            int index = this.events.indexOf(existingEvent);
            this.events.set(index, event);

            return;
        }

        this.events.add(event);
    }

    public void updateMarkets(Market market) {

        System.out.println("Update markets: " + market.getName());

        Market existingMarket = this.markets.stream()
                .filter(m -> market.getId().equals(m.getId()))
                .findAny()
                .orElse(null);

        if (existingMarket != null) {
            int index = this.markets.indexOf(existingMarket);
            this.markets.set(index, market);

            return;
        }

        this.markets.add(market);
    }

}
