package com.nsofttask.model;

import com.google.gson.annotations.SerializedName;
import com.nsofttask.enumerations.Status;
import com.sun.istack.internal.NotNull;
import lombok.Data;

@Data
public class MarketOutcome {

    @NotNull
    private String id;
    @NotNull
    private String name;
    @NotNull
    private Status status;

}
