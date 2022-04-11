package com.nsofttask.model;

import com.nsofttask.enumerations.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

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
