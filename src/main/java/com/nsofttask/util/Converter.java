package com.nsofttask.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.nsofttask.model.Event;
import com.nsofttask.model.Market;
import com.nsofttask.model.MarketOutcome;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    private static ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());


    public static Market marketToJson(String market) throws JsonProcessingException {
        Market marketJson;
        marketJson = objectMapper.readValue(market, Market.class);
        return marketJson;
    }

    public static Event eventToJson(String event) throws JsonProcessingException {
        Event eventJson;
        eventJson = objectMapper.readValue(event, Event.class);
        return eventJson;
    }

    public static List<Market> marketsToJson(String markets) throws JsonProcessingException {
        List<Market> marketsList = new ArrayList<>();
        marketsList.add(objectMapper.readValue(markets, Market.class));
        return marketsList;
    }

    public static List<Event> eventsToJson(String events) throws JsonProcessingException {
        List<Event> eventsList = new ArrayList<>();
        eventsList.add(objectMapper.readValue(events, Event.class));
        return eventsList;
    }

}
