package com.example.employee.service;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.ResponseEmployeeDto;
import com.example.employee.exception.EmployeeIdNotFoundException;
import com.example.employee.exception.NoEmployeeDataFoundException;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeServiceTest {
	@InjectMocks
	EmployeeService employeeService;
	@Mock
	EmployeeRepository employeeRepository;
	@Test
	public void testSaveEmployee() {
		ResponseEmployeeDto employeeDto = new ResponseEmployeeDto();
		EmployeeDto employee= new EmployeeDto();
		employee.setEmail("gs@gmail.com");
		employee.setEmployeeId(20L);
		employee.setEmployeeName("gsp");
		employee.setPhone("9876543210");
		employee.setProjectName("db");
		Employee response = new Employee();
		BeanUtils.copyProperties(employee, response);
		Employee employee1=new Employee();
		Mockito.when(employeeRepository.save(response)).thenReturn(employee1);
		if (employee1.toString().isEmpty()) {
			throw new NoEmployeeDataFoundException();
		} else {
			BeanUtils.copyProperties(employee1, employeeDto);
			Assert.assertNotNull(employeeDto);
		}
	}
	@SuppressWarnings("unused")
	@Test(expected=NoEmployeeDataFoundException.class)
	public void testSaveEmployeeForException() {
		ResponseEmployeeDto employeeDto = new ResponseEmployeeDto();
		Employee response = null;
		Employee employee1=new Employee();
		if (response==null) {
			throw new NoEmployeeDataFoundException();
		} else {
			Mockito.when(employeeRepository.save(response)).thenReturn(employee1);

			BeanUtils.copyProperties(employee1, employeeDto);
		}
		Assert.assertNotNull(employeeDto);
	}
	@Test
	public void testUpdateEmployee() {
		Employee response = new Employee();
		EmployeeDto employeeDto= new EmployeeDto();
		employeeDto.setEmail("gs@gmail.com");
		employeeDto.setEmployeeId(20L);
		employeeDto.setEmployeeName("gsp");
		employeeDto.setPhone("9876543210");
		employeeDto.setProjectName("db");
		BeanUtils.copyProperties(employeeDto, response);
		Employee employee1=new Employee();
		if (employee1.toString().isEmpty()) {
			throw new NoEmployeeDataFoundException();
		} else {
			Mockito.when(employeeRepository.save(response)).thenReturn(employee1);
			BeanUtils.copyProperties(employee1, employeeDto);
		}
		Assert.assertNotNull(employeeDto);
	}
	@SuppressWarnings("unused")
	@Test(expected=NoEmployeeDataFoundException.class)
	public void testUpdateEmployeeForException() {
		EmployeeDto employeeDto= new EmployeeDto();
		Employee response = null;
		Employee employee1=new Employee();
		if (response==null) {
			throw new NoEmployeeDataFoundException();
		} else {
			Mockito.when(employeeRepository.save(response)).thenReturn(employee1);
			BeanUtils.copyProperties(employee1, employeeDto);
		}
		
		Mockito.when(employeeService.updateEmployee(employeeDto)).thenReturn(employeeDto);
		Assert.assertNotNull(employeeDto);
	}
	
	@Test
	public void testGetEmployee() {
		EmployeeDto employeeDto=new EmployeeDto();
		Employee employee = new Employee();
		employee.setEmail("gs@gmail.com");
		employee.setEmployeeId(10L);
		employee.setEmployeeName("gsp");
		employee.setPhone("9876543210");
		employee.setProjectName("db");
		Optional<Employee> employee1 = Optional.of(new Employee());
		Mockito.when(employeeRepository.findById(10L)).thenReturn(employee1);
		if(employee1.isPresent())
		BeanUtils.copyProperties(employee, employeeDto);
		Assert.assertNotNull(employeeDto);
	}
	@Test(expected=EmployeeIdNotFoundException.class)
	public void testGetEmployeeForException() {
		EmployeeDto employeeDto=new EmployeeDto();
		Employee employee = new Employee();
		employee.setEmail("gs@gmail.com");
		employee.setEmployeeId(10L);
		employee.setEmployeeName("gsp");
		employee.setPhone("9876543210");
		employee.setProjectName("db");
		employeeRepository.save(employee);
		Employee employee1 = employeeRepository.findById(10L).orElseThrow(()->new EmployeeIdNotFoundException());
		BeanUtils.copyProperties(employee1, employeeDto);
		Assert.assertNotNull(employeeDto);
	}
	@Test
	public void testGetEmployeeById() {
		Employee employee = new Employee();
		employee.setEmail("gs@gmail.com");
		employee.setEmployeeId(10L);
		employee.setEmployeeName("gsp");
		employee.setPhone("9876543210");
		employee.setProjectName("db");
		employeeRepository.save(employee);
		Optional<Employee> employee1 = Optional.of(new Employee());
		Mockito.when(employeeRepository.findById(10L)).thenReturn(employee1);
		if(employee1.isPresent())
			Assert.assertNotNull(employee1);
	}
	@Test(expected=EmployeeIdNotFoundException.class)
	public void testGetEmployeeByIdException() {
		Employee employee = new Employee();
		employee.setEmail("gs@gmail.com");
		employee.setEmployeeId(10L);
		employee.setEmployeeName("gsp");
		employee.setPhone("9876543210");
		employee.setProjectName("db");
		employeeRepository.save(employee);
		Employee employee1 = employeeRepository.findById(20L).orElseThrow(()->new EmployeeIdNotFoundException());
		Mockito.when(employeeRepository.findById(20L)).thenThrow(new EmployeeIdNotFoundException());
			Assert.assertNotNull(employee1);
	}
	@Test
	public void testDeleteEmployee() {
		Employee employee = new Employee();
		employee.setEmail("gs@gmail.com");
		employee.setEmployeeId(10L);
		employee.setEmployeeName("gsp");
		employee.setPhone("9876543210");
		employee.setProjectName("db");
		employeeRepository.save(employee);
		Optional<Employee> employee1 = Optional.of(new Employee());
		Mockito.when(employeeRepository.findById(10L)).thenReturn(employee1);
		if(employee1.isPresent())
			Assert.assertNotNull(employee1);
		employeeRepository.deleteById(employee.getEmployeeId());
	}
	@Test(expected=EmployeeIdNotFoundException.class)
	public void testDeleteEmployeeForException() {
		Employee employee = new Employee();
		employee.setEmail("gs@gmail.com");
		employee.setEmployeeId(10L);
		employee.setEmployeeName("gsp");
		employee.setPhone("9876543210");
		employee.setProjectName("db");
		employeeRepository.save(employee);
		Employee employee1 = employeeRepository.findById(20L).orElseThrow(()->new EmployeeIdNotFoundException());
		Mockito.when(employeeRepository.findById(20L)).thenThrow(new EmployeeIdNotFoundException());
			Assert.assertNotNull(employee1);
			employeeRepository.deleteById(employee.getEmployeeId());
	}


}
