package com.example.employee.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.example.employee.model.Swipe;

public class SwipeReportDto {
	private Long employeeId;
	private String employeeName;
	private String phone;
	private String email;
	private String projectName;
	private long WrokingHoursPerDay;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.MERGE)
	private List<Swipe> swipes;


	public long getWrokingHoursPerDay() {
		return WrokingHoursPerDay;
	}

	public void setWrokingHoursPerDay(long wrokingHoursPerDay) {
		WrokingHoursPerDay = wrokingHoursPerDay;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public List<Swipe> getSwipes() {
		return swipes;
	}

	public void setSwipes(List<Swipe> swipes) {
		this.swipes = swipes;
	}



}
