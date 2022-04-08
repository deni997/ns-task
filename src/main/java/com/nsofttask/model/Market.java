package com.nsofttask.model;

import com.google.gson.annotations.SerializedName;
import com.nsofttask.enumerations.Status;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Market {

    private String id;
    private String name;
    private Status status;
    private List<MarketOutcome> outcomes;

}
