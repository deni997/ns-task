package com.nsofttask.model;

public class MarketOutcome {

    private String id;
    private String name;
    private Status status;

    public MarketOutcome() {
    }

    public MarketOutcome(String id, String name, Status status) {
        this.id = id;
        this.name = name;
        this.status = status;
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
}
