package com.nsofttask.service;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nsofttask.enumerations.Status;
import com.nsofttask.model.*;
import com.nsofttask.util.FileReader;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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

        for (Event event : this.events) {
            if (event.getStatus() == Status.INACTIVE) {
                continue;
            }

            Event eventDto = new Event();

            eventDto.setId(event.getId());
            eventDto.setName(event.getName());
            eventDto.setStatus(event.getStatus());
            eventDto.setStartsAt(event.getStartsAt());

            List<EventMarket> eventMarketsDto = new ArrayList<>();

            for (EventMarket eventMarket : event.getMarkets()) {
                if(eventMarket.getStatus() == Status.INACTIVE) {
                    continue;
                }

                EventMarket eventMarketDto = new EventMarket();

                eventMarketDto.setId(eventMarket.getId());
                eventMarketDto.setMarketId(eventMarket.getMarketId());
                eventMarketDto.setStatus(eventMarket.getStatus());

                eventMarketsDto.add(eventMarketDto);

                List<EventMarketOutcome> eventMarketOutcomesDto = new ArrayList<>();

                for (EventMarketOutcome eventMarketOutcome : eventMarket.getOutcomes()){
                    if(eventMarketOutcome.getStatus() == Status.INACTIVE){
                        continue;
                    }

                    EventMarketOutcome eventMarketOutcomeDto = new EventMarketOutcome();

                    eventMarketOutcomeDto.setId(eventMarketOutcome.getId());
                    eventMarketOutcomeDto.setOutcomeId(eventMarketOutcome.getOutcomeId());
                    eventMarketOutcomeDto.setStatus(eventMarketOutcome.getStatus());
                    eventMarketOutcomeDto.setOdds(eventMarketOutcome.getOdds());

                    eventMarketOutcomesDto.add(eventMarketOutcomeDto);

                    eventMarketDto.setOutcomes(eventMarketOutcomesDto);
                }
                eventDto.setMarkets(eventMarketsDto);
            }
            eventsDto.add(eventDto);
        }
        return eventsDto;
    }

    public List<Market> getMarkets() {

        List<Market> marketsDto = new ArrayList<>();

        for (Market market : this.markets) {
            if(market.getStatus() == Status.INACTIVE) {
                continue;
            }

            Market marketDto = new Market();

            marketDto.setId(market.getId());
            marketDto.setName(market.getName());
            marketDto.setStatus(market.getStatus());

            List<MarketOutcome> outcomesDto = new ArrayList<>();

            for(MarketOutcome outcome : market.getOutcomes()) {
                if (outcome.getStatus() == Status.INACTIVE) {
                    continue;
                }

                MarketOutcome outcomeDto = new MarketOutcome();

                outcomeDto.setId(outcome.getId());
                outcomeDto.setName(outcome.getName());
                outcomeDto.setStatus(outcome.getStatus());

                outcomesDto.add(outcomeDto);

                marketDto.setOutcomes(outcomesDto);
            }
            marketsDto.add(marketDto);
        }
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
