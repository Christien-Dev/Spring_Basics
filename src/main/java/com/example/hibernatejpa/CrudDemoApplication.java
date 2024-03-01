package com.example.hibernatejpa;


import com.example.hibernatejpa.dao.StudentDAO;
import com.example.hibernatejpa.domains.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


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

			readStudent(studentDAO);

			queryForStudents(studentDAO);

			queryForStudentsByLastName(studentDAO);

			updateStudent(studentDAO);

			updateAllStudents(studentDAO);

			deleteStudentById(studentDAO);

			deleteStudentsByFirstName(studentDAO);

			deleteAllStudents(studentDAO);

		};
	}



	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("\nCreating new student");
		Student student = new Student("Some", "One", "someone@gmail.com");
		System.out.println("New student created " + student);

		// save the student object
		System.out.println("Saving Student");
		studentDAO.save(student);

		// JPA can access the fields of Entity class, Embeddable class and Id class or any other class which is in the JPA scope, directly or through setters and getters(student.getId())
		System.out.println("Student saved into DB with id " + student.getId());

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("\nCreating multiple Students");
		Student student1 = new Student("Foo", "Barz", "foobarz@gmail.com");
		Student student2 = new Student("Foo", "Baz", "foobaz@gmail.com");
		Student student3 = new Student("Inte", "Jerz", "intejerz@gmail.com");
		Student student4 = new Student("Bonita", "AppleBum", "bonitaapplebum@gmail.com");

		//Saving Multiple Students
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		studentDAO.save(student4);
	}

	private void readStudent(StudentDAO studentDAO) {

		int studentId = 1;
		System.out.println("\nGetting student with Id of: " + studentId);
		Student student = studentDAO.findById(studentId);
		System.out.println("Found Student: " + student);

	}

	private void queryForStudents(StudentDAO studentDAO) {
		System.out.println("\nGetting list of all students: ");
		List<Student> studentList = studentDAO.findAllSorted();
		studentList.forEach(System.out::println);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		String lastName = "AppleBum";
		System.out.println("\nGetting Student(s) with lastname: " + lastName);
		List<Student> studentList = studentDAO.findByLastName(lastName);
		studentList.forEach(System.out::println);
	}

	private void updateStudent(StudentDAO studentDAO) {

		int studentId = 1;

		System.out.println("\nGetting Student with id: " + studentId);
		Student student = studentDAO.findById(studentId);

		student.setFirstname("any");

		System.out.println("Updating Student...");
		studentDAO.update(student);

		System.out.println("Student Updated: "+ student);


	}

	private void updateAllStudents(StudentDAO studentDAO) {

		String lastname = "TEST";

		System.out.println("\nUpdating all students lastName to : " + lastname);

		int rowsUpdated = studentDAO.updateAllStudents(lastname);

		System.out.println("Number of Students Updated: "+ rowsUpdated);
	}

	private void deleteStudentById(StudentDAO studentDAO) {
		int studentId = 2;

		System.out.println("\nDeleting student with ID: " + studentId);

		studentDAO.deleteStudents(studentId);

		System.out.println("Student Deleted");
	}

	private void deleteStudentsByFirstName(StudentDAO studentDAO) {
		String firstName = "Foo";

		System.out.println("\nDeleting student(s) with firstName: " + firstName);

		int rowsDeleted = studentDAO.deleteStudentsByFirstName(firstName);

		System.out.println("Deleted " + rowsDeleted + " Students");
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("\nDeleting all Students: ");
		int rowsDeleted = studentDAO.deleteAllStudents();
		System.out.println("Deleted " + rowsDeleted + " Students");
	}
}
