package io.lindx.web.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController_4 {

    private AtomicLong counter = new AtomicLong();



    @GetMapping("/thread")
    public String increment() {
        System.out.println(Thread.currentThread().getName());

        for (long i = 0; i < 1_000_000_000l; i++) {
            counter.incrementAndGet();
        }
        System.out.println(counter);
        return String.valueOf(counter);
    }
}
