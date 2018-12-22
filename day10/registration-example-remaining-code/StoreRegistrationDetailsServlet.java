package com.cdac.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.dao.RegistrationDetailsDao;
import com.cdac.model.RegistrationDetails;

/**
 * Servlet implementation class StoreRegistrationDetailsServlet
 */
@WebServlet("/storeRegistrationDetails")
public class StoreRegistrationDetailsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RegistrationDetails registrationForm = (RegistrationDetails) session.getAttribute("formData");
		
		RegistrationDetailsDao dao = new RegistrationDetailsDao();
		dao.insert(registrationForm);
		
		response.sendRedirect("thankyou.jsp");
	}

}
