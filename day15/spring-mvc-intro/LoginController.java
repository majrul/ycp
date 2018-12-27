package com.cdac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(path="/loginProcess.cdac", method=RequestMethod.POST)
	public String loginCheck(
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		
		if(username.equals("majrul") && password.equals("123"))
			return "welcome.jsp";
		else
			return "login.jsp";
	}
}
