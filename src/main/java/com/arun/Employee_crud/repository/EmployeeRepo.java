package com.arun.Employee_crud.repository;

import com.arun.Employee_crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    List<Employee> findByNameContaining(String q);

    Employee findByEmail(String email);
}
