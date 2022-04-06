package com.nsofttask.model;

import com.nsofttask.enumerations.Status;
import lombok.Data;

import java.util.List;

@Data
public class Market {

    private String id;
    private String name;
    private Status status;
    private List<MarketOutcome> outcomes;

}
