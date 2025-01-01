package com.learning.SpringJDBCLearning;

import com.learning.SpringJDBCLearning.Model.Student;
import com.learning.SpringJDBCLearning.Service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcLearningApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJdbcLearningApplication.class, args);

		Student s = context.getBean(Student.class);
		s.setRollNO(104);
		s.setName("Harry");
		s.setMarks(60);



		StudentService service = context.getBean(StudentService.class);
//		service.addStudent(s);
		//Fetching all student
		List<Student> students=service.getStudents();
		System.out.println(students);
	}

}
