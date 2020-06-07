package com.example.employee.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table
public class Swipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long swipeId;
	
	 @Temporal(TemporalType.TIME) 
	private Date swipeIn;
	 @Temporal(TemporalType.TIME) 
	private Date swipeOut;
	private double totalWorkingHours;
	@ManyToOne
	@JsonIgnore
	private Employee employee;
	@ManyToOne
	private Facility facility;
	public long getSwipeId() {
		return swipeId;
	}
	public void setSwipeId(long swipeId) {
		this.swipeId = swipeId;
	}
	public Date getSwipeIn() {
		return swipeIn;
	}
	public void setSwipeIn(Date swipeIn) {
		this.swipeIn = swipeIn;
	}
	public Date getSwipeOut() {
		return swipeOut;
	}
	public void setSwipeOut(Date swipeOut) {
		this.swipeOut = swipeOut;
	}
	
	public double getTotalWorkingHours() {
		return totalWorkingHours;
	}
	public void setTotalWorkingHours(double totalWorkingHours) {
		this.totalWorkingHours = totalWorkingHours;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Facility getFacility() {
		return facility;
	}
	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	

}
