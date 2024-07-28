package com.arun.Employee_crud.service;

import com.arun.Employee_crud.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();

    List<Employee> search(String q);

    Optional<Employee> findOne(int id);

    void save(Employee contact);

    void delete(int id);
}
