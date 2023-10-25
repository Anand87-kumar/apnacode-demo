package com.anand.employeeservice.controller;


import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RestController;

import com.anand.employeeservice.response.EmployeeResponse;
import com.anand.employeeservice.service.EmployeeService; 

@RestController
public class EmployeeController { 

	@Autowired
	private EmployeeService employeeService; 

	@GetMapping("/employees/{id}") 
	private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id) { 
		EmployeeResponse employee = employeeService.getEmployeeById(id); 
		return ResponseEntity.status(HttpStatus.OK).body(employee); 
	} 

}
