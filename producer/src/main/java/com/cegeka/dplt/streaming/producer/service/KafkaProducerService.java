package com.cegeka.dplt.streaming.producer.service;

import com.cegeka.dplt.streaming.spec.PushedMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    @Autowired
    private KafkaTemplate<String, PushedMessage> kafkaTemplate;

    @Value("${app.kafka.producer.topic}")
    private String topic;


    public void send(PushedMessage message) {
        logger.info("message sent: {}", message);
        kafkaTemplate.send(topic, message);
    }

}
