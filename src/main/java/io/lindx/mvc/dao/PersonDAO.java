package io.lindx.mvc.dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import io.lindx.mvc.models.Person;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {

        return jdbcTemplate.query(
                "SELECT * FROM person", 
                new BeanPropertyRowMapper<>(Person.class)
            );
    }

    public Person show(int id) {

        return jdbcTemplate.query(

                "SELECT * FROM person WHERE id=?", 
                new Object[]{id}, 
                new BeanPropertyRowMapper<>(Person.class)
                
            ).stream().findAny().orElse(null);
    }

    public void save(Person person) {

        jdbcTemplate.update("INSERT INTO person VALUES(1,?,?,?)", 
                                        person.getName(), 
                                        person.getAge(), 
                                        person.getEmail()
                                );
    }

    public void update(int id, Person updatePerson) {

        jdbcTemplate.update("UPDATE person SET name=?, age=?, email=? WHERE id=?",
                                    updatePerson.getName(), 
                                    updatePerson.getAge(), 
                                    updatePerson.getEmail(),
                                    id
                                );
    }

    public void delete(int id) {

        jdbcTemplate.update("DELETE FROM person WHERE id=?",
                id
        );
    }
}

/*
 * findAny - любой элемент из заданного потока удовлетворяющий условию.
 * Найденное значение (возможно null) будет упаковано в объекте класса Optional.
 * 
 */