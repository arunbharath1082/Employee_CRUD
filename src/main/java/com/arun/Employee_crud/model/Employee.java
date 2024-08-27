package com.arun.Employee_crud.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "Employee")
@Data
public class Employee {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    public Employee() {
        super();

    }
}
