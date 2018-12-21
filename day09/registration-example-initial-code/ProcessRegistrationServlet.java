package com.cdac.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.model.RegistrationDetails;
import com.cdac.validator.RegistrationDetailsValidator;

/**
 * Servlet implementation class ProcessRegistrationServlet
 */
@WebServlet("/processRegistration")
public class ProcessRegistrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step 1. Collecting the form data
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		String city = request.getParameter("city");
		String captcha = request.getParameter("captcha");
		
		//Step 2. Collect the form data in some object
		RegistrationDetails registrationForm = new RegistrationDetails();
		registrationForm.setName(name);
		registrationForm.setEmail(email);
		registrationForm.setUsername(username);
		registrationForm.setPassword(password);
		registrationForm.setCity(city);
		registrationForm.setMobile(mobile);
		
		//Step 3. Store this data in the session
		HttpSession session = request.getSession();
		session.setAttribute("formData", registrationForm);
		
		//Step 4. Validation
		RegistrationDetailsValidator validator = new RegistrationDetailsValidator();
		List<String> errors = validator.validate(registrationForm);
		
		if(!errors.isEmpty()) {
			session.setAttribute("errors", errors);
			response.sendRedirect("register.jsp");
			//response.sendRedirect("register2.jsp");
		}
		else {
			response.sendRedirect("confirmation.jsp");
		}
	}

}
