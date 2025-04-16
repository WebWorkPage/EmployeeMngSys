package com.example.empMngSys.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.empMngSys.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class EmployeeNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(EmployeeNotFoundException.class) //if any exception occurred in EmloyeeNotFoundException class,it sends request to this handler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	
	public Map<String,String> exceptionHandler(EmployeeNotFoundException exception){
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", exception.getMessage()); //storing the exception occurred in Map
		return errorMap;
	}
}
