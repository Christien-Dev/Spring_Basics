package com.example.c_simplerestapi.controllers;

import com.example.c_simplerestapi.domain.Student;
import com.example.c_simplerestapi.errorhandling.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void PostBuildInitializer(){
        students =  new ArrayList<>();
        students.add(new Student("Foo","Barz"));
        students.add(new Student("Foo","Baz"));
        students.add(new Student("Inte","Jerz"));
    }

    @GetMapping("/students")
    @Description("Get list of all Students")
    public List<Student> sayHello(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    @Description("Get Student based on student ID")
    public Student sayHello(@PathVariable("studentId") int studentId){

        if(studentId >= students.size() || studentId < 0){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return students.get(studentId);
    }
}
