package com.nsofttask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nsofttask.enumerations.Status;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
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
