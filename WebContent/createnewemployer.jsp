<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new employer</title>
<link href="css/profile.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="Header.jsp"%>
<div id="centered">

<div id="left">
</div>
<div id="index">
<%-- <a href="profile.do">Profile</a>--%>
<a href="<c:url value="homepagefaculty.jsp" />">Home</a>
<br>
<a href="<c:url value="viewjobs.do"/>">View Jobs</a>
</div>

<div id="middle">
<form name="createnewemployer" method="post" action="createnewemployer.do" id="createnewemployer">
<table>
	<tr>
		<td>		
		Employer Code*:
		</td>
		
		<td >
		<input type="text" name="employer_id" size="10"><br>
		</td>
	</tr>
	
	<tr>
		<td>		
		Employer Name*:
		</td>
		
		<td >
		<input type="text" name="employer_name" size="30"><br>
		</td>
	</tr>
</table>
<br>
<br>

<div align="left">
<input type="submit" value="Create"> 
</div>
</form>
</div>
</div>
</body>
</html>