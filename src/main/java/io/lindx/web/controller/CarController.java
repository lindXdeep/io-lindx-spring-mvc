package io.lindx.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    
    @GetMapping("/hello")
    public String getHello(){
        return "hello";
    }
}
