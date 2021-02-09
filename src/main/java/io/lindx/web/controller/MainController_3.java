package io.lindx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController_3 {

    @GetMapping("/main3")
    public @ResponseBody String printMainInfo(){
        System.out.println("we are in main method 1");
        return "Hello from @ResponseBody";
    }
}
