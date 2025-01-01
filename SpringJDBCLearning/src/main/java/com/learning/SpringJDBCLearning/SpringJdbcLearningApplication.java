package com.learning.SpringJDBCLearning;

import com.learning.SpringJDBCLearning.Model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcLearningApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJdbcLearningApplication.class, args);

		Student s = context.getBean(Student.class);
		s.setMarks(60);
		s.setName("Harry");
		s.setRollNO(101);

		addStudent(s);
	}

}
