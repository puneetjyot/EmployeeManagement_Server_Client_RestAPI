package com.nagarro.EmployeeInfoServer.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@Column(name = "emp_id", unique = true, nullable = false)
	private int employeecode;
	@Column(name = "emp_name", unique = true, nullable = false)
	private String employeename;
	@Column(name = "emp_location", unique = true, nullable = false)
	private String location;
	@Column(name = "emp_email", unique = true, nullable = false)
	private String email;
	@Column(name = "emp_dob", unique = true, nullable = false)
	private LocalDate dateofbirth;

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

	


}
