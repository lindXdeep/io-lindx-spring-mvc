package io.lindx.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class FirstController {
    
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request){

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("hello: " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/bye")
    public String goodbye(){
        return "first/bye";
    }
}
