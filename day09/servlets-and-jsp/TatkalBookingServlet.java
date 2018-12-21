package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TatkalBookingServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		ServletConfig config = getServletConfig();
		
		int from = Integer.parseInt(config.getInitParameter("from"));
		int to = Integer.parseInt(config.getInitParameter("to"));
		
		Calendar cal = Calendar.getInstance();
		int hh = cal.get(Calendar.HOUR_OF_DAY);
		
		if(hh >= from && hh <= to)
			out.println("<h1>Welcome, you are on time</h1>");
		else
			out.println("<h1>Sorry, this service is currently unavailable</h1>");
	}

}
