package com.arun.Employee_crud.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "Employee")
@Data
public class Employee {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone")
    private String phone;

    public Employee() {
        super();

    }
}
