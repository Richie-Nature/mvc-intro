package com.spring.mvc.c1.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World")
                                   String name, Model model) {
        List<String> greetings = new LinkedList<>();
        greetings.add("Hello");
        greetings.add("Hey there!");
        greetings.add("Hi!");
        greetings.add("Goodbye");

        model.addAttribute("name", name);
        model.addAttribute("greetings", greetings);
        return "greet";
    }

}
