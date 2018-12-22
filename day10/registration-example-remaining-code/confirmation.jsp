<%@page import="com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression"%>
<%@page import="com.cdac.model.RegistrationDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Confirmation Page</h2>
<h3>You have submitted the following details with us. 
Please confirm if the same is correct. If you wish to do any changes,
<a href="register2.jsp">Click here</a> to go back.</h3>

<%
	RegistrationDetails registrationForm = (RegistrationDetails) session.getAttribute("formData");
%>

Name : <%= registrationForm.getName() %> <br/>
Email : <%= registrationForm.getEmail() %> <br/>
Username : <%= registrationForm.getUsername() %> <br/>
We know your password, hahahaha : <%= registrationForm.getPassword() %> <br/>

<br/><br/>
To save the data in the database, <a href="storeRegistrationDetails">Click here</a>
</body>
</html>




