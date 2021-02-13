package io.lindx.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
// @RequestMapping("/first")
public class FirstController {
    
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required =  false) String name,
                            @RequestParam(value = "surname", required =  false) String surname,
                            Model model) {  // Spring атоматически внедрит модель

        model.addAttribute("message",                          // ключ
                            "hello, " + name + " " + surname); // значение                                            

        return "first/hello";
    }

    @GetMapping("/bye")
    public String goodbye(){
        return "first/bye";
    }

    @GetMapping("/calc")
    public String calculator(@RequestParam("a")      int a, 
                             @RequestParam("b")      int b,
                             @RequestParam("action") String action, 
                             Model                   model) {

        double result;

        switch (action) {
            case "multiplication":
                result = a * b;             break;
            case "division":
                result = a / (double) b;    break;
            case "subtraction":
                result = a - b;             break;
            case "addition":
                result = a + b;             break;
            default:
                result = 0;                 break;
        }

        model.addAttribute("result", result);

        return "first/calculator";
    }
}
