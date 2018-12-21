<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String str = "Hello everyone";
	Date date = new Date();
%>

<h1><%= str %></h1>
<h2>Aaj ki taarikh : <%= date %></h2>

<center>
	<%
		for(int i=1; i<=7; i++) {
	%>
		<font size="<%= i %>">Hello World!</font><br/>
	<%
		}
	%>
</center>


<%--
<?php
	$str = "Hello everyone";
	echo "<h1>" . str . "</h1>";
?>
 --%>
 
</body>
</html>