<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page Faculty</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="Header.jsp"%>
<div id="centered">

<div id="left">
</div>
<div id="index">
<a href="<c:url value="createjob.do"/>">Create Job</a>
<%-- <a href="https://localhost/jobservices/php/createnewjob.php">Create a Job</a> --%>
<br>
<a href="<c:url value="viewjobs.do"/>">View Jobs</a>
<%-- <a href="https://localhost/jobservices/php/viewJobs.php">View Jobs</a>--%>
</div>

<div id="middle">
<br>
Good to see you : ${sessionScope["emailId"]}
</div>

<%-- <div id="right">
</div>--%>

</div>
<%@ include file="Footer.jsp" %>

</body>
</html>