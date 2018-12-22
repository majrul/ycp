package com.cdac.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.dao.ProductDao;
import com.cdac.model.Product;

/**
 * Servlet implementation class ProductListingControllerServlet
 */
@WebServlet("/productListingController")
public class ProductListingControllerServlet extends HttpServlet {

	int rows = 10;
	int position = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action != null) {
			if(action.equals("next"))
				position += rows;
			else if(action.equals("prev"))
				position -= rows;
		}
		else
			position = 0;
		
		ProductDao dao = new ProductDao();
		List<Product> products = dao.fetchDummyProducts(position, rows);
		
		HttpSession session = request.getSession();
		session.setAttribute("products", products);
		
		response.sendRedirect("viewProducts.jsp");
	}

}
