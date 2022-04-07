package com.nsofttask.model;

import com.nsofttask.enumerations.Status;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EventMarket {

    @NotNull
    private String id;
    @NotNull
    private String marketId;
    @NotNull
    private Status status;
    @NotNull
    private List<EventMarketOutcome> outcomes;

}
