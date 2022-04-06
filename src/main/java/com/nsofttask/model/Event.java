package com.nsofttask.model;

import com.nsofttask.enumerations.Status;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Event {

    private String id;
    private String name;
    private String startsAt;
    private Status status;
    private List<EventMarket> markets;

}
