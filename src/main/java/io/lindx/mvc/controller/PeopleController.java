package io.lindx.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.lindx.mvc.dao.PersonDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO persons_dao;

    @Autowired
    public PeopleController(PersonDAO persons) {
        this.persons_dao = persons;  
    }

    @GetMapping()
    public String index(Model model){ 
        model.addAttribute("people", persons_dao.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show( @PathVariable("id") int id,
                        Model model){

        model.addAttribute("person", persons_dao.show(id));                 
        return "people/show";
    }   
}
