<%@page import="com.cdac.model.RegistrationDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<font color="red">
	<%
		List<String> errors = (List<String>) session.getAttribute("errors");
		if(errors != null) {
			for(String error : errors)
				out.println("<br/>"  + error);
		}
		RegistrationDetails registrationForm = (RegistrationDetails) session.getAttribute("formData");
		if(registrationForm == null)
			registrationForm = new RegistrationDetails();
	%>
</font>

<form method="post" action="processRegistration">
Name : <input name="name" value="<%= registrationForm.getName() %>" /> <br/> 
Email :<input name="email" value="<%= registrationForm.getEmail() %>" /> <br/>
Username : <input name="username" value="<%= registrationForm.getUsername() %>" /> <br/>
Password : <input name="password" /> <br/>
Mobile No :<input name="mobile" value="<%= registrationForm.getMobile() %>"/> <br/>
City :<input name="city" value="<%= registrationForm.getCity() %>"/> <br/>
Enter the code shown below : <input name="captcha" /> <br/>
<img src="captcha.jpg" /> <br/>
<input type="submit" value="Register" />
</form>
</body>
</html>