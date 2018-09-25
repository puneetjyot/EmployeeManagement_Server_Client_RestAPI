package com.nagarro.HumanResourcePortal.service.impl;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.nagarro.HumanResourcePortal.constant.Constant;
import com.nagarro.HumanResourcePortal.dto.EmployeeEditWrapperDto;
import com.nagarro.HumanResourcePortal.dto.EmployeeWrapperDto;
import com.nagarro.HumanResourcePortal.service.UploadService;

public class UploadServiceImpl implements UploadService{

	
	@Override
	public void uploadList(MultipartFile file) {
		byte[] bytes = null;
		try {
			bytes = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<EmployeeEditWrapperDto> elist=new ArrayList<>();
          String completeData = new String(bytes);
          completeData.trim();
          String[] rows = completeData.split("\n");
          for(int i=1;i<rows.length;i++)
          {
          String[] columns = rows[i].split(",");
          EmployeeEditWrapperDto employee=new EmployeeEditWrapperDto();
          int id=Integer.parseInt(columns[0]);
          employee.setEmployeecode(id);
          employee.setEmployeename(columns[1]);
          employee.setLocation(columns[2]);
          employee.setEmail(columns[3]);
          employee.setDateofbirth(columns[4]);
          elist.add(employee);
          }
          Client client = ClientBuilder.newClient();
  		WebTarget target = client.target(Constant.BASE_URL);
  		Response response = target.path("addList").request(MediaType.APPLICATION_JSON)
  				.post(Entity.entity(elist, MediaType.APPLICATION_JSON));
	}
}
