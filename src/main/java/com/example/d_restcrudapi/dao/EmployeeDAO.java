package com.example.d_restcrudapi.dao;

import com.example.d_restcrudapi.domains.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
