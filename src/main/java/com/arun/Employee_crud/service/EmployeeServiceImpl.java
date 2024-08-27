package com.arun.Employee_crud.service;

import com.arun.Employee_crud.exceptions.EmployeeAlreadyExists;
import com.arun.Employee_crud.exceptions.EmployeeNotFound;
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
    public Optional<List<Employee>> search(String q) {
        if (employeeRepository.findByNameContaining(q).isEmpty()) {
            throw new EmployeeNotFound("Employee with name " + q + " not found");
        }
        return Optional.ofNullable(employeeRepository.findByNameContaining(q));
    }
    @Override
    public Optional<Employee> findOne(int id) {
          return Optional.ofNullable(employeeRepository.findById(id).orElseThrow(
                  () -> new EmployeeNotFound("Employee with id " + id + " not found")
          ));

    }

    @Override
    public String save(Employee contact) {
         Employee email = employeeRepository.findByEmail(contact.getEmail());
            if (email != null) {
                throw new EmployeeAlreadyExists("Employee with email " + contact.getEmail() + " already exists");
            }
            employeeRepository.save(contact);
            return "Employee Created Successfully!";


    }

    @Override
    public String update(Employee contact) {
        employeeRepository.save(contact);
        return "Employee Updated Successfully!";
    }

    @Override
    public String delete(int id) {
        if (employeeRepository.findById(id).isEmpty()) {
            throw new EmployeeNotFound("Employee with id " + id + " not found");
        }
        employeeRepository.deleteById(id);
        return "Employee Deleted Successfully!";
    }
    @Override
    public boolean existsByEmail(String email) {
        return employeeRepository.findByEmail(email) == null;
    }
}
