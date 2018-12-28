package com.cdac.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(path="/loginProcess.cdac", method=RequestMethod.POST)
	public String loginCheck(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			Map<String,Object> model) {
			//HttpSession session,
			//HttpServletRequest request) {
		
		if(username.equals("majrul") && password.equals("123")) {
			model.put("username", username);
			return "welcome.jsp";
		}
		else {
			model.put("message", "Invalid Username/Password");
			return "login.jsp";
		}
			
	}
}
