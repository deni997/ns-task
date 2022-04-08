package com.nsofttask.model;

import com.nsofttask.enumerations.Status;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EventMarket {

    private String id;
    private String marketId;
    private Status status;
    private List<EventMarketOutcome> outcomes;

}
