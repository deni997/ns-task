package com.nsofttask.model;

public class EventMarket {

    private String id;
    private Market market;
    private Status status;

    public EventMarket() {
    }

    public EventMarket(String id, Market market, Status status) {
        this.id = id;
        this.market = market;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
