package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello.exe") //URI/URL --> try anything you like
public class HelloServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); //MIME
		//response.setContentType("text/html;charset=UTF-8"); //MIME	
		
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.write("<h1>Hello World</h1>");
		//out.write("<h1>नमस्ते दुनिया</h1>");
		out.write("<h2>Date " + new Date()+ "</h2>");
		out.write("</body></html>");		
	}

	
}
