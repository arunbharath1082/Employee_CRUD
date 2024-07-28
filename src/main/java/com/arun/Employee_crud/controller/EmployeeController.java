package com.arun.Employee_crud.controller;

import com.arun.Employee_crud.model.Employee;
import com.arun.Employee_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private  EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> findall() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> findOne(@PathVariable int id) {
        return employeeService.findOne(id);
    }

    @PostMapping("/employee")
    public String Create(@RequestBody Employee employee) {
        if (employee == null) {
            return "Employee Creation Failed!";
        }
        employeeService.save(employee);
        return "Employee Created Successfully!";
    }




    @GetMapping("/employee/{id}/delete")
    public String delete(@PathVariable int id) {
        employeeService.delete(id);
       return "Employee Deleted Successfully!";
    }

    @GetMapping("/employee/search")
    public List<Employee> search(@RequestParam("s") String s) {
        if (s.equals("")) {
            return employeeService.findAll();
        }

        return employeeService.search(s);

    }

    @PutMapping("/employee/{id}")
    public String update(@PathVariable int id, @RequestBody Employee employee) {
        Optional<Employee> emp = employeeService.findOne(id);
        if (emp.isPresent()) {
            Employee e = emp.get();
            e.setName(employee.getName());
            e.setPhone(employee.getPhone());
            employeeService.save(e);
            return "Employee Updated Successfully!";
        }
        return "Employee Not Found!";
    }
}
