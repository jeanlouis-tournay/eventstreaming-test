package com.cegeka.dplt.streaming.consumer.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private String lastMessageReceived;

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = {"#{'${app.kafka.consumer.topic}'.split(',')}"})
    public void receive(@Payload String message) {
        logger.info("message received: {}", message);
        lastMessageReceived=message;
    }


    public String getLastMessageReceived() {
        return lastMessageReceived;
    }

}
