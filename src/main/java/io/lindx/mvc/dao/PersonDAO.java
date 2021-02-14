package io.lindx.mvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import io.lindx.mvc.models.Person;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Lue"));
        people.add(new Person(++PEOPLE_COUNT, "John"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id) {
        return people.stream().filter( p -> p.getId() == id).findAny().orElse(null);
    }
}

/*
 * findAny - любой элемент из заданного потока удовлетворяющий условию.  
 * Найденное значение (возможно null) будет упаковано в объекте класса Optional.
 * 
 */