package com.nsofttask.model;

import com.nsofttask.enumerations.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventMarketOutcome {

    private String id;
    private String outcomeId;
    private Status status;
    private Double odds;

}
