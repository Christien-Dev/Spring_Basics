package com.example.hibernatejpa;


import com.example.hibernatejpa.dao.StudentDAO;
import com.example.hibernatejpa.domains.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			System.out.println("Starting DB process");

			createStudent(studentDAO);

			createMultipleStudents(studentDAO);

		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student");
		Student student = new Student("some", "one", "someone@gmail.com");
		System.out.println("New student created " + student);

		// save the student object
		System.out.println("Saving Student");
		studentDAO.save(student);

		// JPA can access the fields of Entity class, Embeddable class and Id class or any other class which is in the JPA scope, directly or through setters and getters(student.getId())
		System.out.println("Student saved into DB with id " + student.getId());

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating new multiple Students");
		Student student1 = new Student("Foo", "Barz", "foobarz@gmail.com");
		Student student2 = new Student("Inte", "Jerz", "intejerz@gmail.com");
		Student student3 = new Student("Bonita", "AppleBum", "bonitaapplebum@gmail.com");

		//Saving Multiple Students
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

}
