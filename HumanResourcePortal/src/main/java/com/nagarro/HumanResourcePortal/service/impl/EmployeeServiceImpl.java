package com.nagarro.HumanResourcePortal.service.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.nagarro.HumanResourcePortal.constant.Constant;
import com.nagarro.HumanResourcePortal.dto.EmployeeEditWrapperDto;
import com.nagarro.HumanResourcePortal.dto.EmployeeWrapperDto;
import com.nagarro.HumanResourcePortal.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public List<EmployeeWrapperDto> getEmployeeList() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(Constant.BASE_URL);
		List<EmployeeWrapperDto> employees = (List<EmployeeWrapperDto>) target.path("allemployees")
				.request(MediaType.APPLICATION_JSON).get(new GenericType<ArrayList<EmployeeWrapperDto>>() {
				});

		return employees;
	}

	@Override
	public EmployeeWrapperDto getEmployee(int code) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(Constant.BASE_URL);
		EmployeeWrapperDto employee = target.path("selectedemployee/" + code).request(MediaType.APPLICATION_JSON)
				.get(EmployeeWrapperDto.class);
		return employee;
	}

	@Override
	public void editEmployee(EmployeeEditWrapperDto employee) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(Constant.BASE_URL);
		Response response = target.path("edit").request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(employee, MediaType.APPLICATION_JSON));

		String isEdited = response.readEntity(String.class);
		if(isEdited.equals("true")) {
			System.out.println("Edited");
		}
		else {
			System.out.println("Not Edited");
		}
	}

	@Override
	public void downloadList() {
		
		List<EmployeeWrapperDto> employees=getEmployeeList();
		try (
	            BufferedWriter writer = Files.newBufferedWriter(Paths.get("Employeedata.csv"));

	            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
	                    .withHeader("EmployeeID", "EmployeeName", "Location", "Email","DOB"));
	        ){
			for(EmployeeWrapperDto employee:employees) {
				 csvPrinter.printRecord(employee.getEmployeecode(),employee.getEmployeename(),employee.getLocation(),employee.getEmail(),employee.getDateofbirth());
			}
			 csvPrinter.flush(); 
		} 
		
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	
}
