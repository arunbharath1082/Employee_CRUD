package com.arun.Employee_crud.exceptions;

public class EmployeeAlreadyExists extends RuntimeException {

    private String message;
    public EmployeeAlreadyExists(String message) {
        super(message);
        this.message = message;
    }
    public EmployeeAlreadyExists() {

    }
}
