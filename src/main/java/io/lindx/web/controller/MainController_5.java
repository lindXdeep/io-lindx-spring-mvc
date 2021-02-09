package io.lindx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController_5 {

    @GetMapping("/jsp")
    public String getJsp() {

        return "main"; // расширение не пишем так как мы его уже определили
                       // viewResolver.setSuffix(".jsp");
    }
}
