<%@page import="com.cdac.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products Listing</title>
</head>
<body>
<table align="center" border="1">
<tr><th>ID</th><th>Name</th><th>Price</th><th>Quantity</th></tr>
<%
	List<Product> products = (List<Product>) session.getAttribute("products");
	for(Product product : products) {
%>
	<tr>
		<td><%= product.getId() %></td>
		<td><%= product.getName() %></td>
		<td><%= product.getPrice() %></td>
		<td><%= product.getQuantity() %></td>
	</tr>
<%				
	}
%>
<tr>
	<th colspan="4">
		<a href="productListingController?action=prev">&lt;&lt;</a>
		<a href="productListingController?action=next">&gt;&gt;</a>
	</th>
</tr>
</table>
</body>
</html>