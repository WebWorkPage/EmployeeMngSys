package com.example.empMngSys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.empMngSys.model.Employee;
import com.example.empMngSys.service.EmployeeService;

@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeController {
	    @Autowired
	    private EmployeeService employeeService;
	    
	    @GetMapping("/employees")
	    public List<Employee> getAllEmployee() {
	        return employeeService.getAllEmployees();
	    }
	    
	    @PostMapping("/employee")
	    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
	        Employee emp = employeeService.saveEmployee(employee);
	        return new ResponseEntity<>(emp, HttpStatus.CREATED);
	    }

	    @GetMapping("/employee/{id}")
	    public Employee viewEmployeebyId(@PathVariable Long id) {
	        return employeeService.getEmployeeById(id);
	    }

	    @PutMapping("/employee/{id}")
	    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updateEmployee) {
	        return employeeService.updateEmployee(id, updateEmployee);
	    }

	    @DeleteMapping("/employee/{id}")
	    public String deleteEmployee(@PathVariable Long id) {
	        employeeService.deleteEmployee(id);
	        return "Employee with id "+id+" is deleted successfully";
	    }

}
