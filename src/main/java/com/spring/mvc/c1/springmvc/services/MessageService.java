package com.spring.mvc.c1.springmvc.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private List<String> messages;

    @PostConstruct
    public void postConstruct() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return this.messages;
    }

}
