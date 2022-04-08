package com.nsofttask.service;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nsofttask.enumerations.Status;
import com.nsofttask.model.*;
import com.nsofttask.util.FileReader;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public List<Event> getEvents(String selectedDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<Event> eventsDto = new ArrayList<>();

        for (Event event : this.events) {
            boolean eventMarketDoesNotExistInMarketList = false;

            // Check if event started
            if (LocalDateTime.parse(event.getStartsAt()).isBefore(LocalDateTime.now())) {
                event.setStatus(Status.INACTIVE);
            }

            // Check event status
            if(event.getStatus() == Status.INACTIVE) {
                continue;
            }

            // Mapping required events
            Event eventDto = new Event();

            eventDto.setId(event.getId());
            eventDto.setName(event.getName());
            eventDto.setStartsAt(event.getStartsAt());
            eventDto.setStatus(event.getStatus());

            List<EventMarket> eventMarketsDto = new ArrayList<>();

            // Mapping event markets and checking if they exist in markets list
            for (EventMarket eventMarket : event.getMarkets()) {
                eventMarketDoesNotExistInMarketList = this.eventMarketDoesNotExistInMarketList(eventMarket);

                if(eventMarketDoesNotExistInMarketList) {
                    System.out.println("Event: '" + event.getName() + "' contains market/outcome that doesn't exist in the market list");
                    break;
                }

                if(eventMarket.getStatus() == Status.INACTIVE) {
                    continue;
                }

                EventMarket eventMarketDto = new EventMarket();

                eventMarketDto.setId(eventMarket.getId());
                eventMarketDto.setMarketId(eventMarket.getMarketId());
                eventMarketDto.setStatus(eventMarket.getStatus());

                eventMarketsDto.add(eventMarketDto);

                List<EventMarketOutcome> eventMarketOutcomesDto = new ArrayList<>();

                //
                for (EventMarketOutcome eventMarketOutcome : eventMarket.getOutcomes()) {
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

            if (!eventMarketDoesNotExistInMarketList) {
                eventsDto.add(eventDto);
            }
        }

        if(selectedDate != null && selectedDate != "") {
            eventsDto = eventsDto.stream()
                    .filter(e -> {
                        LocalDate startsAt = LocalDate.parse(e.getStartsAt().split("T")[0], formatter);
                        LocalDate selected = LocalDate.parse(selectedDate, formatter);
                        return startsAt.isEqual(selected);
                    }).collect(Collectors.toList());
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

    private boolean eventMarketDoesNotExistInMarketList(EventMarket eventMarket) {
        Market market = this.markets.stream()
                .filter(m -> Objects.equals(eventMarket.getMarketId(), m.getId()))
                .findAny()
                .orElse(null);

        if(market == null) {
            return true;
        }

        boolean hasInvalidOutcomes = true;
        for (EventMarketOutcome emo : eventMarket.getOutcomes()) {
            hasInvalidOutcomes = true;

            for(MarketOutcome em : market.getOutcomes()) {
                if (Objects.equals(em.getId(), emo.getOutcomeId())) {
                    hasInvalidOutcomes = false;
                }
            }

            if (hasInvalidOutcomes) break;
        }
        return hasInvalidOutcomes;
    }

}
