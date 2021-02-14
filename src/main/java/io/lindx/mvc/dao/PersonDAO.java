package io.lindx.mvc.dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;

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

        Person person = null;

        try {
            PreparedStatement preStatement = 
                    connection.prepareStatement("SELECT * FROM person WHERE id=?");

                preStatement.setInt(1, id);    

            ResultSet resultSet = preStatement.executeQuery();

            resultSet.next();

            person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                person.setAge(resultSet.getInt("age"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

    public void save(Person person) {

        try {
            PreparedStatement preStatement = 
                connection.prepareStatement("INSERT INTO person VALUES(1,?,?,?)");

            preStatement.setString(1, person.getName());
            preStatement.setInt(2, person.getAge());
            preStatement.setString(3, person.getEmail());

            preStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Person updatePerson) {

        try {
            PreparedStatement preStatement = 
            connection.prepareStatement("UPDATE person SET name=?, age=?, email=? WHERE id=?");
            
            preStatement.setString(1, updatePerson.getName());
            preStatement.setInt(2, updatePerson.getAge());
            preStatement.setString(3, updatePerson.getEmail());
            preStatement.setInt(4, id);

            preStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {

        try {
            PreparedStatement preStatement = 
                connection.prepareStatement("DELETE FROM person WHERE id=?");
            
            preStatement.setInt(1, id);
            preStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*
 * findAny - любой элемент из заданного потока удовлетворяющий условию.
 * Найденное значение (возможно null) будет упаковано в объекте класса Optional.
 * 
 */