package com.nsofttask.model;

import com.nsofttask.enumerations.Status;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class Event {

    @NotNull
    private String id;
    @NotNull
    private String name;
    @NotNull
    private String startsAt;
    @NotNull
    private Status status;
    @NotNull
    private List<EventMarket> markets;

}
