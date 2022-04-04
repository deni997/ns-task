package com.nsofttask.service;


import com.nsofttask.util.FileReader;
import org.springframework.stereotype.Service;

@Service
public class DataService {


    public void init() {
        String markets = this.loadFile("markets.json");
        String events = this.loadFile("events.json");
        String market = this.loadFile("market.json");
        String event = this.loadFile("event.json");
        if(markets != null) System.out.println(markets);
        if(events != null) System.out.println(events);
        if(market != null) System.out.println(market);
        if(event != null) System.out.println(event);
    }

    public String loadFile(String fileName) {
        String file = FileReader.getResourceFileAsString(fileName);
        return file;
    }

}
