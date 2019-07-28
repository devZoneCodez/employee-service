package com.example.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.example.emp.entity.Employee;
import com.example.emp.service.EmployeeService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EntityScan(basePackages = { "com.example.emp.entity" })
@ComponentScan(basePackages = { "com.example.emp.controller", "com.example.emp.repo", "com.example.emp.service" })
public class EmployeeServiceApplication implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		employeeService.saveEmployee(new Employee(1L, "Sateesh Kumar D", 10000, "Dev"));
		employeeService.saveEmployee(new Employee(2L, "John Doe", 10000, "Dev"));
		employeeService.saveEmployee(new Employee(3L, "John Smith", 10000, "Dev"));
		
	}

}
