package com.example.employee.exception;

@SuppressWarnings("serial")
public class EmployeeIdNotFoundException extends RuntimeException{
	public EmployeeIdNotFoundException() {
		super("EmployeeIdNotFoundException");
	}

}
