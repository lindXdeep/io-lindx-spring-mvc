package io.lindx.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class helloController {
    
    @GetMapping("/hello")
    public String helloworld(){
        return "hello_view";
    }
}
