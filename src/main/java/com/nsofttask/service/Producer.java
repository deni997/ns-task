package com.nsofttask.service;

import com.nsofttask.model.Event;
import com.nsofttask.model.Market;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, Event> eventKafkaTemplate;
    @Autowired
    private KafkaTemplate<String, Market> marketKafkaTemplate;

    public void publishEventToTopic(String topicName, Event eventData) {
        LOGGER.info("Sending Event Json Serializer : {}", eventData);
        System.out.println("Publishing to topic:\n" + topicName);
        eventKafkaTemplate.send(topicName, eventData);
    }

    public void publishMarketToTopic(String topicName, Market marketData) {
        LOGGER.info("Sending Event Json Serializer : {}", marketData);
        System.out.println("Publishing to topic:\n" + topicName);
        marketKafkaTemplate.send(topicName, marketData);
    }
}
