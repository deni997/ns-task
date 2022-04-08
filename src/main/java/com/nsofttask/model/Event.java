package com.nsofttask.model;

import com.nsofttask.enumerations.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Event {

    private String id;
    private String name;
    private String startsAt;
    private Status status;
    private List<EventMarket> markets;

}
