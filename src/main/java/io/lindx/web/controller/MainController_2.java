package io.lindx.web.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MainController_2 {
    @GetMapping("/main1")
    public String printMainInfo(){
        System.out.println("we are in main method 1");
        return "Hello from RestController";
    }
}
