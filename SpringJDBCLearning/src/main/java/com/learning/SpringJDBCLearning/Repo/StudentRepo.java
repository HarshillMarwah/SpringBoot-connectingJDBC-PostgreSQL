package com.learning.SpringJDBCLearning.Repo;

import com.learning.SpringJDBCLearning.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        System.out.println("Entering findAll @ StudentRepo");
        String sql = "Select * from Student";

        //RowMapper no Lambda used. Overriding function
        /*RowMapper<Student> rowMapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setRollNO(rs.getInt("rollNo"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return s;
            }
        };*/
        //RowMapper using Lambda expression
        /*RowMapper<Student> rowMapper=(rs, rowNum) -> {
            Student s = new Student();
            s.setRollNO(rs.getInt("rollNo"));
            s.setName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));
            return s;
        };*/
        System.out.println("ExitingfindAll @ StudentRepo");
        //return jdbc.query(sql,rowMapper); //RowMapper with above Lambda
        return jdbc.query(sql,(rs, rowNum) -> {
            Student s = new Student();
            s.setRollNO(rs.getInt("rollNo"));
            s.setName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));
            return s;
        }); //RowMapper with Inline Lambda
//        return new ArrayList<>();
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
