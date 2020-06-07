package com.example.employee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.ResponseEmployeeDto;
import com.example.employee.dto.SwipeReportDto;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<ResponseEmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto employee) {
		ResponseEmployeeDto employee1 = employeeService.saveEmployee(employee);
		employee1.setMessage("employee created successfully");
		return new ResponseEntity<>(employee1, HttpStatus.OK);
	}

	@PutMapping("/employee")
	public ResponseEntity<String> updateEmployee(@Valid @RequestBody EmployeeDto employee) {
		employeeService.updateEmployee(employee);
		return new ResponseEntity<>("employee is Updated successfully", HttpStatus.OK);
	}

	@GetMapping("/employee")
	public ResponseEntity<EmployeeDto> getEmployee(@RequestParam Long id) {
		return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);

	}
	@GetMapping("/employeeId/{id}")

	 public ResponseEntity<Employee> getEmployeeSwapping(@PathVariable Long id) {
	 return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
	 }
	@DeleteMapping("/employee")
	public ResponseEntity<String> deleteEmployee(@RequestParam Long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>("employee with id "+id+" is  deleted successfully", HttpStatus.OK);

	}
	@GetMapping("/employee/{id}")
	public ResponseEntity<SwipeReportDto> getEmployeeSwipe(@PathVariable Long id) {
		SwipeReportDto swipeReportDto = employeeService.getEmployee1(id);
		return new ResponseEntity<>(swipeReportDto, HttpStatus.OK);

	}

}
