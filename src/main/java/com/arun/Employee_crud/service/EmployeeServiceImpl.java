package com.arun.Employee_crud.service;

import com.arun.Employee_crud.model.Employee;
import com.arun.Employee_crud.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> search(String q) {
        return employeeRepository.findByNameContaining(q);
    }

    @Override
    public Optional<Employee> findOne(int id) {
          return employeeRepository.findById(id);

    }

    @Override
    public void save(Employee contact) {
        employeeRepository.save(contact);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
