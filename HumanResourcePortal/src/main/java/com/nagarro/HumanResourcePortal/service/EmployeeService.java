package com.nagarro.HumanResourcePortal.service;

import java.util.List;

import com.nagarro.HumanResourcePortal.dto.EmployeeEditWrapperDto;
import com.nagarro.HumanResourcePortal.dto.EmployeeWrapperDto;

public interface EmployeeService {

	List<EmployeeWrapperDto> getEmployeeList();

	EmployeeWrapperDto getEmployee(int code);

	void editEmployee(EmployeeEditWrapperDto employee);

	void downloadList();

}
