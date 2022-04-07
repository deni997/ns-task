package com.nsofttask.model;

import com.nsofttask.enumerations.Status;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventMarketOutcome {

    @NotNull
    private String id;
    @NotNull
    private String outcomeId;
    @NotNull
    private Status status;
    @NotNull
    private Double odds;

}
