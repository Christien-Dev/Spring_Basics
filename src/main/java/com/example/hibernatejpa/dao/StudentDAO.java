package com.example.hibernatejpa.dao;

import com.example.hibernatejpa.domains.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findAllSorted();

    List<Student> findByLastName(String lastName);


}
