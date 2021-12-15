package com.cegeka.dplt.streaming.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;




@Component
public class KafkaProducerServiceImpl implements KafkaProducerService{

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerServiceImpl.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    //@Value("${spring.kafka.ssl.trust-store-location}")
    private String topic;

    @Override
    public void send(String message) {
        logger.info("message sent: {}", message);
        kafkaTemplate.send(topic, message);
    }

}
