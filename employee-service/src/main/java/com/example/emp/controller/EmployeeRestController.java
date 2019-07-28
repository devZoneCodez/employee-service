package com.example.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp.entity.Employee;
import com.example.emp.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/api/employees")
	public List<Employee> getEmployees() {
		log.trace("getEmployees() - start");

		List<Employee> returnList = employeeService.retrieveEmployees();
		
		log.trace("getEmployees() - end");
		return returnList;
	}

	@GetMapping("/api/employees/{employeeId}")
	public Employee getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		log.trace("getEmployee(Long) - start");

		Employee returnEmployee = employeeService.getEmployee(employeeId);
		
		log.trace("getEmployee(Long) - end");
		return returnEmployee;
	}

	@PostMapping("/api/employees")
	public void saveEmployee(Employee employee) {
		log.trace("saveEmployee(Employee) - start");

		employeeService.saveEmployee(employee);
		log.info("saveEmployee(Employee) - {}", "Employee Saved Successfully");

		log.trace("saveEmployee(Employee) - end");
	}

	@DeleteMapping("/api/employees/{employeeId}")
	public void deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		log.trace("deleteEmployee(Long) - start");

		employeeService.deleteEmployee(employeeId);
		log.info("deleteEmployee(Long) - {}", "Employee Deleted Successfully");

		log.trace("deleteEmployee(Long) - end");
	}

	@PutMapping("/api/employees/{employeeId}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable(name = "employeeId") Long employeeId) {
		log.trace("updateEmployee(Employee, Long) - start");

		Employee emp = employeeService.getEmployee(employeeId);
		if (emp != null) {
			employeeService.updateEmployee(employee);
		}

		log.trace("updateEmployee(Employee, Long) - end");
	}

}
