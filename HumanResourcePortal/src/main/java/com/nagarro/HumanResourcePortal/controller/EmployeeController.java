package com.nagarro.HumanResourcePortal.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.HumanResourcePortal.constant.Constant;
import com.nagarro.HumanResourcePortal.dto.EmployeeEditWrapperDto;
import com.nagarro.HumanResourcePortal.dto.EmployeeWrapperDto;
import com.nagarro.HumanResourcePortal.model.Employee;
import com.nagarro.HumanResourcePortal.service.EmployeeService;
import com.nagarro.HumanResourcePortal.service.UploadService;
import com.nagarro.HumanResourcePortal.service.impl.EmployeeServiceImpl;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	@Autowired
	UploadService uploadService;

	@RequestMapping(value = "/employeelistings", method = RequestMethod.GET)
	public ModelAndView showEmployees(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		List<EmployeeWrapperDto> employees = employeeService.getEmployeeList();
		model.addAttribute("employeeresult", employees);
		return new ModelAndView("employeelistings", Constant.COMMAND, new EmployeeWrapperDto());

	}

	@RequestMapping(value = "/employeedetails", method = RequestMethod.POST)
	public ModelAndView editEmployeedetails(@ModelAttribute("SpringWeb") Employee employee, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		int code = 0;

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {

			for (Cookie cookie : cookies) {

				if (cookie.getName().equals("empid")) {

					code = Integer.parseInt(cookie.getValue());

				}
			}

		}

		EmployeeWrapperDto selectedemployee = employeeService.getEmployee(code);

		String email = selectedemployee.getEmail();

		String name = selectedemployee.getEmployeename();
		String location = selectedemployee.getLocation();
		LocalDate dob = selectedemployee.getDateofbirth();
		model.addAttribute("empcode", code);
		model.addAttribute("name", name);
		model.addAttribute("location", location);
		model.addAttribute("email", email);
		model.addAttribute("dob", dob);

		System.out.println(code);
		return new ModelAndView("employeedetails", Constant.COMMAND, new EmployeeWrapperDto());

	}

	@RequestMapping(value = "/employeeedit", method = RequestMethod.POST)
	public ModelAndView editEmployee(@ModelAttribute("SpringWeb") EmployeeEditWrapperDto employee,
			HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		
		employeeService.editEmployee(employee);
		List<EmployeeWrapperDto> employees = employeeService.getEmployeeList();
		model.addAttribute("employeeresult", employees);

		return new ModelAndView("employeelistings", Constant.COMMAND, new EmployeeEditWrapperDto());
	}
	
	@RequestMapping(value = "/uploadEmployee", method = RequestMethod.POST)
	public ModelAndView uploadEmployee(HttpServletRequest request, HttpServletResponse response,ModelMap model,@RequestParam("file") MultipartFile file) {

		if(!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				System.out.println("Succesfull");
				System.out.println(file.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println("Uploading document");
		
		}uploadService.uploadList(file);
		List<EmployeeWrapperDto> employees = employeeService.getEmployeeList();
		model.addAttribute("employeeresult", employees);
		return new ModelAndView("employeelistings",Constant.COMMAND,new EmployeeWrapperDto());
	}
	@RequestMapping(value = "/downloadEmployee", method = RequestMethod.POST)
	public ModelAndView downloadList(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		
		employeeService.downloadList();
		
		List<EmployeeWrapperDto> employees = employeeService.getEmployeeList();
		model.addAttribute("employeeresult", employees);
		return new ModelAndView("employeelistings",Constant.COMMAND,new EmployeeWrapperDto());
	}

}
