package com.nagarro.EmployeeInfoServer.repository;

import java.util.List;

import com.nagarro.EmployeeInfoServer.dto.EmployeeListDto;
import com.nagarro.EmployeeInfoServer.models.Employee;

public interface EmployeeRepo
{
public List<Employee> getEmployeeList();

public Employee getEmployee(int code);

public boolean updateEmployee(Employee employee);
}
