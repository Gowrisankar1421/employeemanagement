package com.example.employee.exception;

@SuppressWarnings("serial")
public class NoEmployeeDataFoundException extends RuntimeException{
	public NoEmployeeDataFoundException() {
		super("NoEmployeeFoundException");
	}

}
