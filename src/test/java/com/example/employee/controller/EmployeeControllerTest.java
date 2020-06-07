package com.example.employee.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.ResponseEmployeeDto;
import com.example.employee.dto.SwipeReportDto;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeControllerTest {
	@InjectMocks
	EmployeeController employeeController;
	@Mock
	EmployeeService employeeService;
	@Test
	public void testSaveEmployee() {
		EmployeeDto employee = new EmployeeDto();
		employee.setEmail("gs@gmail.com");
		employee.setEmployeeId(20L);
		employee.setEmployeeName("gsp");
		employee.setPhone("9876543210");
		employee.setProjectName("db");
		ResponseEmployeeDto responseDto = new ResponseEmployeeDto();
		responseDto.setEmail(employee.getEmail());
		responseDto.setEmployeeId(employee.getEmployeeId());
		responseDto.setEmployeeName(employee.getEmployeeName());
		responseDto.setPhone(employee.getPhone());
		responseDto.setProjectName(employee.getProjectName());
		Mockito.when(employeeService.saveEmployee(Mockito.any())).thenReturn(responseDto);
		Assert.assertNotNull(responseDto);
		ResponseEntity<ResponseEmployeeDto> response=employeeController.saveEmployee(employee);
		Assert.assertNotNull(response);
		
	}
	@Test
	public void testUpdateEmployee() {
		Employee employee = new Employee();
		employee.setEmail("gs@gmail.com");
		employee.setEmployeeId(20L);
		employee.setEmployeeName("gsp");
		employee.setPhone("9876543210");
		employee.setProjectName("db");
		EmployeeDto responseDto = new EmployeeDto();
		responseDto.setEmail(employee.getEmail());
		responseDto.setEmployeeId(employee.getEmployeeId());
		responseDto.setEmployeeName(employee.getEmployeeName());
		responseDto.setPhone(employee.getPhone());
		responseDto.setProjectName(employee.getProjectName());
		Mockito.when(employeeService.updateEmployee(Mockito.any())).thenReturn(responseDto);
		Assert.assertNotNull(responseDto);
		ResponseEntity<String> response=employeeController.updateEmployee(responseDto);
		Assert.assertNotNull(response);
	}
	@Test
	public void testGetEmployee() {
		EmployeeDto employee = new EmployeeDto();
		employee.setEmail("gs@gmail.com");
		employee.setEmployeeId(10L);
		employee.setEmployeeName("gsp");
		employee.setPhone("9876543210");
		employee.setProjectName("db");
		Employee employee1 = new Employee();
		employee1.setEmail("gs@gmail.com");
		employee1.setEmployeeId(10L);
		employee1.setEmployeeName("gsp");
		employee1.setPhone("9876543210");
		employee1.setProjectName("db");
		Mockito.when(employeeService.getEmployee(10L)).thenReturn(employee);
		Assert.assertEquals(employee1.getEmployeeId(), employee.getEmployeeId());
		ResponseEntity<EmployeeDto> response=employeeController.getEmployee(10L);
		Assert.assertNotNull(response);
	}
	@Test
	public void testGetEmployeeSwapping() {
		Employee employee = new Employee();
		employee.setEmail("gs@gmail.com");
		employee.setEmployeeId(10L);
		employee.setEmployeeName("gsp");
		employee.setPhone("9876543210");
		employee.setProjectName("db");
		Employee employee1 = new Employee();
		employee1.setEmail("gs@gmail.com");
		employee1.setEmployeeId(10L);
		employee1.setEmployeeName("gsp");
		employee1.setPhone("9876543210");
		employee1.setProjectName("db");
		Mockito.when(employeeService.getEmployeeById(10L)).thenReturn(employee);
		Assert.assertEquals(employee.getEmployeeId(), employee.getEmployeeId());
		ResponseEntity<Employee> response=employeeController.getEmployeeSwapping(10L);
		Assert.assertNotNull(response);
	}
	@Test
	public void testDeleteEmployee() {
		Employee employee = new Employee();
		employee.setEmail("gs@gmail.com");
		employee.setEmployeeId(10L);
		employee.setEmployeeName("gsp");
		employee.setPhone("9876543210");
		employee.setProjectName("db");
		Employee employee1 = new Employee();
		employee1.setEmail("gs@gmail.com");
		employee1.setEmployeeId(10L);
		employee1.setEmployeeName("gsp");
		employee1.setPhone("9876543210");
		employee1.setProjectName("db");
		employeeService.deleteEmployee(10L);
		Assert.assertNotNull(employee1);
		ResponseEntity<String> response=employeeController.deleteEmployee(10L);
		Assert.assertNotNull(response);
	}
	@Test
	public void testGetEmployeeSwipe() {
		SwipeReportDto swipeReportDto = new SwipeReportDto();
		swipeReportDto.setEmail("gs@gmail.com");
		swipeReportDto.setEmployeeId(10L);
		swipeReportDto.setEmployeeName("gsp");
		swipeReportDto.setPhone("9876543210");
		swipeReportDto.setProjectName("db");
		swipeReportDto.setWrokingHoursPerDay(7);
		Mockito.when(employeeService.getEmployee1(10L)).thenReturn(swipeReportDto);
		Assert.assertNotNull(swipeReportDto);
		ResponseEntity<SwipeReportDto> response = employeeController.getEmployeeSwipe(10L);
		Assert.assertNotNull(response);
	}
}
