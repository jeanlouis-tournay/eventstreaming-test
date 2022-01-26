package com.cegeka.dplt.streaming.consumer.service;


import com.cegeka.dplt.streaming.consumer.rest.repository.MessageRepository;
import com.cegeka.dplt.streaming.spec.PushedMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {


    @Autowired
    MessageRepository messageRepository;


    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = {"#{'${app.kafka.consumer.topic}'.split(',')}"})
    public void receive(@Payload PushedMessage message) {
        logger.info("message received: {}", message);
        messageRepository.setLastMessage(message);
    }
}
