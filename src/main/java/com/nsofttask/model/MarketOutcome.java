package com.nsofttask.model;

import com.google.gson.annotations.SerializedName;
import com.nsofttask.enumerations.Status;
import lombok.Data;

@Data
public class MarketOutcome {

    private String id;
    private String name;
    private Status status;

}
