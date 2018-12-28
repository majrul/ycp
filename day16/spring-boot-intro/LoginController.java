package com.cdac.springbootdemo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@RequestMapping(
			path="/loginController", 
			method = RequestMethod.POST)
	public Status loginCheck(@RequestBody Login login) {//@RequestBody String data) {
		//System.out.println(data);
		if(login.getUsername().equals("majrul") && login.getPassword().equals("123")) {
			Status status = new Status();
			status.setMessage("Valid User");
			return status;
		}
		else {
			Status status = new Status();
			status.setMessage("Invalid Username/Password");
			return status;
		}
	}
}
