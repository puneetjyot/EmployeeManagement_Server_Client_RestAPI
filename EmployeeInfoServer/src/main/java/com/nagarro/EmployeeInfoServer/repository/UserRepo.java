package com.nagarro.EmployeeInfoServer.repository;

import com.nagarro.EmployeeInfoServer.models.Manager;

public interface UserRepo 
{

	public boolean validUser(Manager manager);

	public boolean addUser(Manager manager);

		
	

}
