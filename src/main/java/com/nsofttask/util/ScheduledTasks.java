package com.nsofttask.util;

import com.nsofttask.enumerations.Status;
import com.nsofttask.model.Event;
import com.nsofttask.service.DataService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component @RequiredArgsConstructor
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private final DataService dataService;

    @Scheduled(fixedRate = 30000)
    public void removeStartedEvents() {
        for(Event event : dataService.getEvents(null)) {
            if (LocalDateTime.parse(event.getStartsAt()).isBefore(LocalDateTime.now())){
                event.setStatus(Status.INACTIVE);
            }
        }
    }
}
