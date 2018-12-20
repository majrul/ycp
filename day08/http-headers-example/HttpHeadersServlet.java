package com.cdac.onlineexam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpHeadersServlet
 */
@WebServlet("/HttpHeadersServlet")
public class HttpHeadersServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userAgent = request.getHeader("user-agent");
		out.println("<h3>user-agent :: " + userAgent + "</h3>");
		
		String lang = request.getHeader("accept-language");
		out.println("<h3>lang pref :: " + lang + "</h3>");
		
		Date now = new Date();
		out.println("<h2>Date " + now + "</h2>");
		
		//response.setHeader("refresh","5");
		//response.setHeader("refresh","5;URL=http://www.google.co.in");
		
		
	}

}
