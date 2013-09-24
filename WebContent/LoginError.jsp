<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Error Page</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="Header.jsp"%> 

<div id="centered">

<div id="left">
</div>
<div id="index">
<a href="Loginpage.jsp">Login/Sign-Up</a>
<br>
</div>

<div id="middle">
<br>
${requestScope["errorMessage"]}
</div>

<!-- <div id="right">
</div>-->

</div>
<%@ include file="Footer.jsp" %>
</body>
</html>