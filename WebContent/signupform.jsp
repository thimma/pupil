<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Form</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="Header.jsp"%> 
<div id="centered">
<div id="left">
</div>
<div id="index">
</div>

<div id="middle">

<div id="midtop">
</div>

<div id="login">

<div id="loginleft">
</div>

<div id="loginmid">
<form method="post" action="createaccount.do">
<br>
User group:
<select name="USER_GROUP_CD">
<option value="student">student</option>
<option value="faculty">faculty</option>
</select>
<br>
<br>
First Name:
<br>
<input type="text" name="FIRST_NAME">
<br>
Last Name:
<br>
<input type="text" name="LAST_NAME">
<br>
A Number:
<br>
<input type="text" name="ANUMBER">
<br>
E-mail:
<br>
<input type="text" name="EMAIL_ID">
<br>
Password:
<br>
<input type="password" name="PASSWORD">
<br>        
<input type="submit" value="Create Account" align="middle">
<br>
</form>
</div>

<div id="loginright">
</div>

</div>

<div id="midbot">
</div>

</div>

<!-- <div id="right">
</div>-->

</div>
<%@ include file="Footer.jsp"%>
</body>


</html>