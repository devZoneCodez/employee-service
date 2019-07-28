package com.example.emp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emp.entity.Employee;
import com.example.emp.repo.EmployeeRepository;
import com.example.emp.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> retrieveEmployees() {
		log.trace("retrieveEmployees() - start");

		List<Employee> returnList = employeeRepository.findAll();
		log.trace("retrieveEmployees() - end");
		return returnList;
	}

	public Employee getEmployee(Long employeeId) {
		log.trace("getEmployee(Long) - start");

		Employee employee = null;
		Optional<Employee> optEmp = employeeRepository.findById(employeeId);
		
		if (optEmp.isPresent()) {
			employee = optEmp.get();
		}
		
		log.trace("getEmployee(Long) - end");
		return employee;
	}

	public void saveEmployee(Employee employee) {
		log.trace("saveEmployee(Employee) - start");

		employeeRepository.save(employee);

		log.trace("saveEmployee(Employee) - end");
	}

	public void deleteEmployee(Long employeeId) {
		log.trace("deleteEmployee(Long) - start");

		employeeRepository.deleteById(employeeId);

		log.trace("deleteEmployee(Long) - end");
	}

	public void updateEmployee(Employee employee) {
		log.trace("updateEmployee(Employee) - start");

		employeeRepository.save(employee);

		log.trace("updateEmployee(Employee) - end");
	}
}
