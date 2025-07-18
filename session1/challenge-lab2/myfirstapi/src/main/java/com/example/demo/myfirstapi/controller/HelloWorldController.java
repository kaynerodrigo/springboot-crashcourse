package com.example.demo.myfirstapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // Import this!
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloWorldController {

    @Value("${app.greeting.message}")
    private String customGreeting;

    @GetMapping("/hello")
    public String sayHello() {
        return customGreeting;
    }

    @GetMapping("/greet/{name}")
    public String greetUser(@PathVariable String name) {
        return "Greetings ," + name + "!";
    }

    @GetMapping("/greeting")
    public String greetWithParam(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }


}