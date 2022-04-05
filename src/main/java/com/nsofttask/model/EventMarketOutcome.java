package com.nsofttask.model;

public class EventMarketOutcome {

    private String id;
    private MarketOutcome outcome;
    private Status status;
    private Double odd;

    public EventMarketOutcome() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MarketOutcome getOutcome() {
        return outcome;
    }

    public void setOutcome(MarketOutcome outcome) {
        this.outcome = outcome;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getOdd() {
        return odd;
    }

    public void setOdd(Double odd) {
        this.odd = odd;
    }
}
