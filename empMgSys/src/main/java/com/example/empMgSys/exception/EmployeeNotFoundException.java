package com.example.empMgSys.exception;

public class EmployeeNotFoundException extends RuntimeException{
	public EmployeeNotFoundException(Long id) {
		super("could not find the employee with Id "+id);
	}
}
