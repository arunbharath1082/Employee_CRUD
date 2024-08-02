package com.arun.Employee_crud.controller;

import com.arun.Employee_crud.model.Employee;
import com.arun.Employee_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private  EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee> >findall() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Optional<Employee> >findOne(@PathVariable int id) {

        if (employeeService.findOne(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeService.findOne(id));
    }

    @PostMapping("/employee")
    public ResponseEntity<String> Create(@RequestBody Employee employee) {
        if ( employee.getEmail().isEmpty() || employee.getName().isEmpty()
                || employee.getPhone().isEmpty())
        {
                return ResponseEntity.badRequest().body("Name, Phone and Email are required!");
        } else if (employeeService.existsByEmail(employee.getEmail())) {
                return ResponseEntity.badRequest().body("Email already exists!");
        }
        employeeService.save(employee);
                return ResponseEntity.ok("Employee Created Successfully!");
    }




    @GetMapping("/employee/{id}/delete")
    public ResponseEntity<String> delete(@PathVariable int id) {

        if (employeeService.findOne(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        employeeService.delete(id);
       return ResponseEntity.ok("Employee Deleted Successfully!");
    }

    @GetMapping("/employee/search")
    public ResponseEntity<List<Employee>> search(@RequestParam("s") String s) {
        if (s.isEmpty()) {
              return ResponseEntity.badRequest().build();
        }
        else if (employeeService.search(s).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeService.search(s));

    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Employee employee) {
        Optional<Employee> emp = employeeService.findOne(id);
        if (emp.isPresent()) {
            Employee e = emp.get();
            e.setName(employee.getName());
            e.setPhone(employee.getPhone());
            employeeService.save(e);
            return ResponseEntity.ok("Employee Updated Successfully!");
        }
        return ResponseEntity.notFound().build();
    }
}
