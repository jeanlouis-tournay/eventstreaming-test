package com.cegeka.dplt.streaming.producer.rest;

import com.cegeka.dplt.streaming.producer.service.KafkaProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    KafkaProducerService kafkaProducerService;


    private static final Logger logger = LoggerFactory.getLogger(Controller.class);


    @PostMapping(value = "/message",produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void put(@RequestBody String message) {
        if(message.isEmpty()) {
            throw new BadRequestException("message not provided");
        }
        try {
            logger.info("received message "+message);
            kafkaProducerService.send(message);
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public class BadRequestException extends RuntimeException {
        public BadRequestException(String message) {
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public class InternalServerErrorException extends RuntimeException {
        public InternalServerErrorException(String message) {
            super(message);
        }
    }



}
