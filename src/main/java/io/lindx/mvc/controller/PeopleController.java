package io.lindx.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.lindx.mvc.dao.PersonDAO;
import io.lindx.mvc.models.Person;

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

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        return "people/new";
    }
    
    @PostMapping()
    public String create( @ModelAttribute("person") @Valid Person person,
                            BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "people/new";                        

        persons_dao.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String adit( Model model,
                        @PathVariable("id") int id){        // Извлекаем значение из id которое передано в GetMapping
        model.addAttribute("person", persons_dao.show(id)); // кладем знаение возвращаемое из persons_dao.show в модел и сеттим ключ person (будет дотупно по этму ключу)
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update( @ModelAttribute("person") @Valid Person person, BindingResult bindingResult, 
                          @PathVariable("id")       int id){

        if (bindingResult.hasErrors())
            return "people/edit";                       

        persons_dao.update(id, person); // есливозникла ошибка в bindingResult тот этот обьект не будет возращаен
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        persons_dao.delete(id);
        return "redirect:/people";
    }
}
