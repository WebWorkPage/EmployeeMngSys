package com.example.empMngSys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empMngSys.exception.EmployeeNotFoundException;
import com.example.empMngSys.model.Employee;
import com.example.empMngSys.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public Employee saveEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }
	
	public Employee getEmployeeById(Long id) {
		 return employeeRepository.findById(id)
					.orElseThrow(() -> new EmployeeNotFoundException(id) );
	}
	 
	 public Employee updateEmployee(Long id, Employee updatedEmployee) {
		 return employeeRepository.findById(id)
					.map(employee -> {
						employee.setFirstname(updatedEmployee.getFirstname());
						employee.setLastname(updatedEmployee.getLastname());
						employee.setEmail(updatedEmployee.getEmail());
						return employeeRepository.save(employee);
					})
					.orElseThrow(() -> new EmployeeNotFoundException(id));
	  }
	 
	 public void deleteEmployee(Long id) {
		 
		 if(!employeeRepository.existsById(id)) {
				throw new EmployeeNotFoundException(id);
		 }
		 employeeRepository.deleteById(id);
//			return "Employee with id "+id+" is deleted successfully";
	 }

}
