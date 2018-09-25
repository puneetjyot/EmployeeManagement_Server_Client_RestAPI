package com.nagarro.HumanResourcePortal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.HumanResourcePortal.constant.Constant;
import com.nagarro.HumanResourcePortal.model.Manager;
import com.nagarro.HumanResourcePortal.service.UserService;

@Controller
public class RegisterController 
{


	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/register",method=RequestMethod.GET)
public ModelAndView registerGet() {
		return new ModelAndView("register",Constant.COMMAND,new Manager());

	}
	
	
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("register") Manager manager,HttpServletRequest request, HttpServletResponse response) {
	System.out.println("registering");
	if(userService.registerUser(manager)) {
		return new ModelAndView(Constant.LOGIN,Constant.COMMAND,new Manager());
	}
	else {
		return new ModelAndView("register",Constant.COMMAND,new Manager());

	}
		
		
	}
}
