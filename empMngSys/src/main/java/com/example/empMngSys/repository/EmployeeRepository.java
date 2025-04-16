package com.example.empMngSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.empMngSys.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
