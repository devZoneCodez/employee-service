package com.example.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.emp.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
 
}