package com.spring.mvc.c1.springmvc.controller;

import com.spring.mvc.c1.springmvc.pojo.Message;
import com.spring.mvc.c1.springmvc.services.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class GreetingController {
    private MessageService messageService;

    public GreetingController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World")
                                   String name, @ModelAttribute("newMessage") Message newMessage, Model model) {
//        List<String> greetings = new LinkedList<>();
//        greetings.add("Hello");
//        greetings.add("Hey there!");
//        greetings.add("Hi!");
//        greetings.add("Goodbye");

        model.addAttribute("name", name);
        model.addAttribute("greetings", this.messageService.getMessages());
        return "greet";
    }

    @PostMapping("/greeting")
//ModelAttribute annotation below is as good as using the matching object name used by thymeleaf in the template ie: newMessage
    public String greeting(@ModelAttribute("newMessage") Message messageForm, Model model) {
        this.messageService.addMessage(messageForm.getName());
        model.addAttribute("greetings", this.messageService.getMessages());
        messageForm.setName("");
        return "greet";
    }

}
