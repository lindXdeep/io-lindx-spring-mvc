package io.lindx.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController_1 {
    @GetMapping("/main1")
    public String printMainInfo(){
        System.out.println("we are in main method 1");
        return "Hello from RestController";
    }
}
