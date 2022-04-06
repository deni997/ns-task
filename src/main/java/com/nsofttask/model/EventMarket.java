package com.nsofttask.model;

import com.nsofttask.enumerations.Status;
import lombok.Data;

import java.util.List;

@Data
public class EventMarket {

    private String id;
    private String marketId;
    private Status status;
    private List<EventMarketOutcome> outcomes;

}
