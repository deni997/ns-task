package com.nsofttask.model;

import com.nsofttask.enumerations.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
public class Event {

    @NotNull(message = "Id cannot be null")
    private String id;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull
    private String startsAt;
    @NotNull
    private Status status;
    @NotNull
    private List<EventMarket> markets;

}
