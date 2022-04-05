package com.nsofttask.model;

import java.util.List;

public class Market {

    private String id;
    private String name;
    private Status status;
    private List<MarketOutcome> marketOutcomes;

    public Market() {
    }

    public Market(String id, String name, Status status, List<MarketOutcome> marketOutcomes) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.marketOutcomes = marketOutcomes;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<MarketOutcome> getOutcomes() {
        return marketOutcomes;
    }

    public void setOutcomes(List<MarketOutcome> marketOutcomes) {
        this.marketOutcomes = marketOutcomes;
    }
}
