package com.arun.Employee_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class EmployeeCrudApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(EmployeeCrudApplication.class, args);

		List<String> beans = List.of(context.getBeanDefinitionNames());
		System.out.println("Total beans: " + beans.size());
		for (String bean : beans) {
			System.out.println("bean:" + bean);
		}
	}

}
