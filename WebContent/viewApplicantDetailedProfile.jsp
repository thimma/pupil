<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Applicant's Detailed Profile</title>
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
<table border='1'>
<tr>
<td>
First Name:
</td>

<td>
${requestScope.studentAccountDetails.firstName}
</td>
</tr>

<tr>
<td>
Last Name:
</td>
<td>
${requestScope.studentAccountDetails.lastName}
</td>
</tr>

<tr>
<td>
E-mail
</td>
<td>
${requestScope.studentAccountDetails.emailId}
</td>
</tr>

<tr>
<td>
Mobile Number:
</td>
<td>
${requestScope.studentContactDetails.mobileNumber}
</td>
</tr>

<tr>
<td>
Phone Number:
</td>

<td>
${requestScope.studentContactDetails.phoneNumber}
</td>
</tr>

<tr>
<td>
Cover Letter:
</td>
<td>
${requestScope["coverLetter"]}
</td>
</tr>

<tr>
<td colspan="2">
<a href="<c:url value="getappresume.do" />?acctid=${requestScope.studentAccountDetails.accountId}&job_uid=${requestScope.job_uid}" target="_blank" >View Resume from Profile</a>
</td>
</tr>
</table>
</div>
</div>
</body>
</html>