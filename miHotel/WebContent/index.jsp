<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Hotel.modelo.vo.*,java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EPN HOTEL</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<br>
	<div style="background-color:#eeeeff">
	<%if(request.getAttribute("NombCat")!=null){%>	
		<br>
		<h3>POSTS EN LA CATEGORIA <%=request.getAttribute("NombCat")%>:</h3>
		<br>	
	<% } 
	else{
	%>	
			
	<% } %>
	</div>
	
		


</body>
</html>