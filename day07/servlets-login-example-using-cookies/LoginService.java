package com.cdac.servlet;

public class LoginService {

	public boolean isValid(LoginInfo login) {
		if(login.getUsername().equals("majrul") && login.getPassword().equals("123"))
			return true;
		return false;
	}

}
