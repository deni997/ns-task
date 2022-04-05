package com.nsofttask.model;

import com.nsofttask.enumerations.Status;

import java.time.LocalDateTime;
import java.util.List;

public class Event {

    private String id;
    private String name;
    private LocalDateTime startsAt;
    private Status status;
    private List<EventMarket> markets;

    public Event() {
    }

    public Event(String id, String name, LocalDateTime startsAt, Status status, List<EventMarket> markets) {
        this.id = id;
        this.name = name;
        this.startsAt = startsAt;
        this.status = status;
        this.markets = markets;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(LocalDateTime startsAt) {
        this.startsAt = startsAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<EventMarket> getMarkets() {
        return markets;
    }

    public void setMarkets(List<EventMarket> markets) {
        this.markets = markets;
    }
}
