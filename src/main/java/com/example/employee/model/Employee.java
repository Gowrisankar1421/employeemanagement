package com.example.employee.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employeeId;
	
	@NotEmpty(message = "Employee name is required")
	private String employeeName;
	
	@NotEmpty(message = "project assignation is required")
	private String projectName;
	
	@NotEmpty(message = "Phone number is required")
    @Size(max=10)
	private String phone;
	
	@NotEmpty(message = "Email is required")
    @Email
	private String email;
	@OneToMany(mappedBy="employee",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Swipe> swipes;
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Swipe> getSwipes() {
		return swipes;
	}
	public void setSwipes(List<Swipe> swipes) {
		this.swipes = swipes;
	}
	
}
