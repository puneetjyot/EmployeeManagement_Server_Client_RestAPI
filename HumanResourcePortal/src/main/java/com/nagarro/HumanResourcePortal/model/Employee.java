package com.nagarro.HumanResourcePortal.model;

import java.time.LocalDate;

public class Employee {

	private int employeecode;
	private String employeename;
	private String location;

	public int getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(int employeecode) {
		this.employeecode = employeecode;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	private String email;
	private LocalDate dateofbirth;

}
