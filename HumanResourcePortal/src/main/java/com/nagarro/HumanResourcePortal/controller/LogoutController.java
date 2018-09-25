package com.nagarro.HumanResourcePortal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.HumanResourcePortal.constant.Constant;
import com.nagarro.HumanResourcePortal.model.Manager;

@Controller
public class LogoutController
{
	@RequestMapping(value = "/logout",method=RequestMethod.POST)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session=request.getSession();
		session.invalidate();
		return new ModelAndView(Constant.LOGIN,"command",new Manager());
	}
}
