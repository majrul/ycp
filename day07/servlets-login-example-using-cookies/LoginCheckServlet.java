package com.cdac.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/loginCheck")
public class LoginCheckServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//user data store in the memory as an object
		LoginInfo login = new LoginInfo();
		login.setUsername(username);
		login.setPassword(password);
		
		LoginService loginService = new LoginService();
		boolean isValid = loginService.isValid(login);
		if(isValid) {
			String rememberMe = request.getParameter("rememberMe");
			if(rememberMe != null && rememberMe.equals("yes")) {
				Cookie c1 = new Cookie("username", username);
				c1.setMaxAge(60 * 60 * 24 * 7); //7 days
				Cookie c2 = new Cookie("password", password);
				c2.setMaxAge(60 * 60 * 24 * 7); //7 days
				response.addCookie(c1);
				response.addCookie(c2);
			}
			response.sendRedirect("welcome.html");
		}
		else
			response.sendRedirect("login.html");
	}

}
