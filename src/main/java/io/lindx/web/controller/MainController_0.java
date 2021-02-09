package io.lindx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController_0 {
    
    @GetMapping("/main0")
    public void printMainInfo(){
        System.out.println("we are in main method 0");
    }
}
