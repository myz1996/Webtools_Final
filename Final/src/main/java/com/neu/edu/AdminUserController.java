package com.neu.edu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/adminuser.htm")
public class AdminUserController {

	public AdminUserController() {
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void formView(HttpServletRequest request,HttpServletResponse response) {
		
		
	}

	@RequestMapping(method = RequestMethod.POST)
	public void successView(HttpServletRequest request,HttpServletResponse response) {
		
	}
}
