package com.example.empMgSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.empMgSys.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
