package com.example.empMgSys.controller;

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

import com.example.empMgSys.exception.EmployeeNotFoundException;
import com.example.empMgSys.model.Employee;
import com.example.empMgSys.repository.EmployeeRepository;

@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee newEmployee) {
		return employeeRepository.save(newEmployee);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public Employee viewEmployeebyId(@PathVariable Long id){
		return employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException(id) );
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@RequestBody Employee editEmployee, @PathVariable Long id) {
		return employeeRepository.findById(id)
				.map(employee -> {
					employee.setFirstName(editEmployee.getFirstName());
					employee.setLastName(editEmployee.getLastName());
					employee.setEmailId(editEmployee.getEmailId());
					return employeeRepository.save(employee);
				})
				.orElseThrow(() -> new EmployeeNotFoundException(id));
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		if(!employeeRepository.existsById(id)) {
			throw new EmployeeNotFoundException(id);
		}
		employeeRepository.deleteById(id);
		return "Employee with id "+id+" is deleted successfully";
	}
}
