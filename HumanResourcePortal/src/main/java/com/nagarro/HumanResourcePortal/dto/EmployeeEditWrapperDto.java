package com.nagarro.HumanResourcePortal.dto;

public class EmployeeEditWrapperDto {
	private int employeecode;
	private String employeename;
	private String location;
	private String email;
	private String dateofbirth;
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
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

}
