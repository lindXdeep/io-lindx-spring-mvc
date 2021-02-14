package io.lindx.mvc.dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import org.springframework.stereotype.Component;

import io.lindx.mvc.models.Person;

@Component
public class PersonDAO {

    private static String url = "jdbc:mysql://localhost:3306/db_persons";
    private static String user = "lindx";
    private static String pass = "MySql12345!";
    private static String param = "?autoReconnect=true&useSSL=false";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url + param, user, pass);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Person> index() {

        List<Person> people = new ArrayList<>();

        try {

            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM person";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return people;
    }

    public Person show(int id) {
        // return people.stream().filter( p -> p.getId() == id).findAny().orElse(null);
        return null;
    }

    public void save(Person person) {
        // person.setId(++PEOPLE_COUNT);
        // people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person updatePers = show(id);
        updatePers.setName(updatePerson.getName());
        updatePers.setAge(updatePerson.getAge());
        updatePers.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        // people.removeIf(p -> p.getId() == id);
    }
}

/*
 * findAny - любой элемент из заданного потока удовлетворяющий условию.
 * Найденное значение (возможно null) будет упаковано в объекте класса Optional.
 * 
 */