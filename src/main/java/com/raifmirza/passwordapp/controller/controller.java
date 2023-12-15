package com.raifmirza.passwordapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/")
    public String a(){
        System.out.println("Hello");
        return "Hello World";
    }
}
