package com.example.employee.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table
public class Facility {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long facilityId;
	
	@NotEmpty(message = "Facility branch is required")
	private String facilityBranch;
	
	@NotEmpty(message = "Facility city is required")
	private String facilityCity;
	@OneToMany(mappedBy = "facility", cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<Swipe> swipes;
	public long getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(long facilityId) {
		this.facilityId = facilityId;
	}
	public String getFacilityBranch() {
		return facilityBranch;
	}
	public void setFacilityBranch(String facilityBranch) {
		this.facilityBranch = facilityBranch;
	}
	public String getFacilityCity() {
		return facilityCity;
	}
	public void setFacilityCity(String facilityCity) {
		this.facilityCity = facilityCity;
	}
	public List<Swipe> getSwipes() {
		return swipes;
	}
	public void setSwipes(List<Swipe> swipes) {
		this.swipes = swipes;
	}
	

}
