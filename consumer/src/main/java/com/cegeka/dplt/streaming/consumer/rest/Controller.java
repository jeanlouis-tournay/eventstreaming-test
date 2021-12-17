package com.cegeka.dplt.streaming.consumer.rest;


import com.cegeka.dplt.streaming.consumer.rest.repository.MessageRepository;
import com.cegeka.dplt.streaming.spec.PushedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {



    @Autowired
    private MessageRepository messageRepository;


    @GetMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
    public PushedMessage get() {
        PushedMessage lastMessage= messageRepository.getLastMessage();
        if(lastMessage==null) {
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
