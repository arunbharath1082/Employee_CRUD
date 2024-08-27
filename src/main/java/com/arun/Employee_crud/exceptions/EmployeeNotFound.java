package com.arun.Employee_crud.exceptions;

public class EmployeeNotFound extends RuntimeException{

    private String message;
    public EmployeeNotFound(String message) {
        super(message);
        this.message = message;
    }
    public EmployeeNotFound() {

    }
}
