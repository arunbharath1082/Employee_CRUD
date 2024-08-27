package com.arun.Employee_crud.service;

import com.arun.Employee_crud.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();

    Optional<List<Employee>> search(String q);

    Optional<Employee> findOne(int id);

    String save(Employee contact);

    String update(Employee contact);

    String delete(int id);

    boolean existsByEmail(String email);
}
