package com.learning.SpringJDBCLearning.Repo;

import com.learning.SpringJDBCLearning.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public void save(Student s) {
        System.out.println("Entering save @ StudentRepo");
        String sql = "Insert into Student (rollNo, name, marks) values (?,?,?)";
        int rows = jdbc.update(sql,s.getRollNO(),s.getName(),s.getMarks() );
        System.out.println("ROWS effected: "+rows);
        System.out.println("Exiting save @ StudentRepo");


    }

    public List<Student> findAll() {
        System.out.println("findAll @ StudentRepo");
        return new ArrayList<>();
    }

    //Getters and Setters

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
}
