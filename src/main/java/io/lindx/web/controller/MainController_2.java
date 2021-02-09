package io.lindx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController_2 {
    @GetMapping("/main2")
    public String printMainInfo(){
        System.out.println("we are in main method 1");
        return "error";
    }
}
