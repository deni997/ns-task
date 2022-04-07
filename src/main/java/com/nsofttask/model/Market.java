package com.nsofttask.model;

import com.nsofttask.enumerations.Status;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Market {

    @NotNull
    private String id;
    @NotNull
    private String name;
    @NotNull
    private Status status;
    @NotNull
    private List<MarketOutcome> outcomes;

}
