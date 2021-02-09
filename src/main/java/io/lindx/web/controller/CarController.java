package io.lindx.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

    @GetMapping("/getCars")
    public String getCar() {
        return "BMW Mersedes";
    }

    @GetMapping(value = { "/getCarbyId/{id}", "/getCarbyId" })
    public String getCarByid(@PathVariable(value = "id", required = false) String id) {

        System.out.println("PathVariable id:" + id);

        if ("1".equals(id)) {
            return "BMW";
        } else if ("2".equals(id)) {
            return "Mersedes";
        }
        return "we dont have car";
    }

    @GetMapping(value = { "/getCarbyIdTwo"})
    public String getCarByidTwo(@RequestParam(value = "id", required = false) String id) {

        System.out.println("@ReqestParam id:" + id);

        if ("1".equals(id)) {
            return "BMW TWO";
        } else if ("2".equals(id)) {
            return "Mersedes TWo";
        }
        return "we dont have car TWO";
    }

    @PostMapping("/add")
    public void addNewCar(@RequestParam("mark") String mark, @RequestParam("speed") String speed){
        System.out.println("we add new car" + "mark" + mark + "\nspeed: " + speed);
    }
}
