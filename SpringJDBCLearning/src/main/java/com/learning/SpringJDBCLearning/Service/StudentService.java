package com.learning.SpringJDBCLearning.Service;

import com.learning.SpringJDBCLearning.Model.Student;
import com.learning.SpringJDBCLearning.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public StudentRepo getRepo() {
        return repo;
    }
    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    private StudentRepo repo;
    public void addStudent(Student s) {
        System.out.println("Entering method addStudent of Service layer");
        repo.save(s);
        System.out.println("Exiting method addStudent of Service layer");
    }

    public List<Student> getStudents() {
        System.out.println("Entering method getStudents of Service layer");
        List<Student> result = repo.findAll();
        System.out.println("Exiting method getStudents of Service layer");
        return result;
    }
}
