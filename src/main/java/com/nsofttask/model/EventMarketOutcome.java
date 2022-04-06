package com.nsofttask.model;

import com.nsofttask.enumerations.Status;
import lombok.Data;

@Data
public class EventMarketOutcome {

    private String id;
    private String outcomeId;
    private Status status;
    private Double odds;

}
