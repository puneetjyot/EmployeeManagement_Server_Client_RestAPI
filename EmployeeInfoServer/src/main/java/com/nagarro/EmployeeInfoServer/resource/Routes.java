package com.nagarro.EmployeeInfoServer.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nagarro.EmployeeInfoServer.models.Employee;
import com.nagarro.EmployeeInfoServer.models.Manager;
import com.nagarro.EmployeeInfoServer.repository.EmployeeRepo;
import com.nagarro.EmployeeInfoServer.repository.UploadRepo;
import com.nagarro.EmployeeInfoServer.repository.UserRepo;
import com.nagarro.EmployeeInfoServer.repository.impl.EmployeeRepoImpl;
import com.nagarro.EmployeeInfoServer.repository.impl.UploadRepoImpl;
import com.nagarro.EmployeeInfoServer.repository.impl.UserRepoImpl;

@Path("employeeinfo")
public class Routes
{
	UserRepo userRepo;
	EmployeeRepo employeeRepo;
	UploadRepo uploadRepo;
	public Routes() {
		 userRepo=new UserRepoImpl();
		 employeeRepo=new EmployeeRepoImpl();
		 uploadRepo=new UploadRepoImpl();
	}
	
	
		@POST
			@Path("login")
			@Consumes(MediaType.APPLICATION_JSON)
			@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
			public String createActvity(Manager manager){
				System.out.println("Object Json");
				System.out.println(manager.getUsername());
				System.out.println(manager.getPassword());
				
				if(userRepo.validUser(manager)) {
//				System.out.println("valid user");
//					List<Employee>employees=employeeRepo.getEmployeeList();
//				System.out.println(employees.size());
				return "true";
				}
				
				return "false";
			}
		
		@GET
		@Path("allemployees")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public List<Employee> getEmployee(){
			System.out.println("getting Employees");
			List<Employee>employees=employeeRepo.getEmployeeList();
			System.out.println(employees.size());
			return employees;
		}
		
		@GET
		@Path("selectedemployee/{empid}")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public Employee getSelectedEmployee(@PathParam("empid") int empid){
			System.out.println("getting Employee");
			Employee employee=employeeRepo.getEmployee(empid);
			System.out.println(employee);
			return employee;
		}

		@POST
			@Path("register")
			@Consumes(MediaType.APPLICATION_JSON)
			@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
			public String registerUser(Manager manager){
				System.out.println("Object Json");
				System.out.println(manager.getUsername());
				System.out.println(manager.getPassword());
				
				if(userRepo.addUser(manager)) {
//				System.out.println("valid user");
//					List<Employee>employees=employeeRepo.getEmployeeList();
//				System.out.println(employees.size());
				return "true";
				}
				
				return "false";
			}
		
		@POST
		@Path("edit")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public String editUser(Employee employee){
			System.out.println("editing employee in server");
			if(employeeRepo.updateEmployee(employee)) {
				return "true";
			}
			return "false";
		}
		
		@POST
		@Path("addList")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public void addList(List<Employee> employee) {
			System.out.println("adding list of employees");
			uploadRepo.addlistEmployee(employee);
		}

}
