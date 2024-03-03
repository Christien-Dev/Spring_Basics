package com.example.d_restcrudapi.services;

import com.example.d_restcrudapi.dao.EmployeeDAO;
import com.example.d_restcrudapi.domains.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeService implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }
}
