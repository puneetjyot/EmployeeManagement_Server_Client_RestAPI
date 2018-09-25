package com.nagarro.HumanResourcePortal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
public class LoginController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/",method = RequestMethod.GET)  
    public ModelAndView login(){   
	 return new ModelAndView(Constant.LOGIN,Constant.COMMAND,new Manager());  
    }  
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		 ModelAndView mav = new ModelAndView("login");
		    mav.addObject(Constant.LOGIN, new Manager());
		    return mav;
	  }


	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public ModelAndView PostLogin(@ModelAttribute("login") Manager manager,HttpServletRequest request, HttpServletResponse response) {
		if(manager.getUsername()=="NULL"||manager.getPassword()=="Null") {
			 ModelAndView mav = new ModelAndView("login");
			    mav.addObject(Constant.LOGIN, new Manager());
			    return mav;
		}
		
		
		if(userService.validateUser(manager)) {
		HttpSession session=request.getSession(true);
		session.setAttribute("username",manager.getUsername());
		ModelAndView mav=new ModelAndView();
		mav.addObject("username",manager.getUsername().toUpperCase());
		return new ModelAndView("redirect:/employeelistings");
		}
		
		else {
			 ModelAndView mav = new ModelAndView("login");
			    mav.addObject("login", new Manager());
			    System.out.println("wrong credentials");
			    HttpSession session=request.getSession(false);
				session.setAttribute("test", Constant.WROMG_CREDENTIALS_MESSAGE);

			    return mav;
		}
		
		
	}
}
