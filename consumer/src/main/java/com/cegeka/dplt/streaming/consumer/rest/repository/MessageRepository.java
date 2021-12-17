package com.cegeka.dplt.streaming.consumer.rest.repository;

import lombok.Data;
import org.springframework.stereotype.Component;
import com.cegeka.dplt.streaming.spec.PushedMessage;

@Component
public class MessageRepository
{

    private PushedMessage lastMessage;


    public PushedMessage getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(PushedMessage lastMessage) {
        this.lastMessage = lastMessage;
    }
}
