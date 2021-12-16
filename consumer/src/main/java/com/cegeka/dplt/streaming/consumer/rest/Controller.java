package com.cegeka.dplt.streaming.consumer.rest;


import com.cegeka.dplt.streaming.consumer.service.KafkaConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private KafkaConsumerService kafkaConsumerService;


    @GetMapping(value = "/message", produces = MediaType.TEXT_PLAIN_VALUE)
    public String get() {

        String lastMessage=kafkaConsumerService.getLastMessageReceived();
        if(lastMessage.isEmpty()) {
            throw new NotFoundException("message not found");
        }
        return lastMessage;
    }




    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class NotFoundException extends RuntimeException{
        public NotFoundException(String message) {
            super(message);
        }
    }


}
