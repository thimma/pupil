<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Applicants List</title>
<link href="css/profile.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="Header.jsp"%>
<div id="centered">

<div id="left">
</div>
<div id="index">
<%-- <a href="profile.do">Profile</a>--%>
<c:choose>
<c:when test="${userGroup eq 'student' }">
<a href="<c:url value="homepagestudent.jsp" />">Home</a>
</c:when>
<c:otherwise>
<a href="<c:url value="homepagefaculty.jsp" />">Home</a>
</c:otherwise>
</c:choose>
<br>
<a href="<c:url value="viewjobs.do"/>">View Jobs</a>
</div>

<div id="middle">
<table border='1'>
<c:forEach var="applicantsList" items="${jobApplicantsList}">
<tr>	
	<td>
	<c:out value="${applicantsList.firstName }"></c:out>	
	
	<c:out value="${applicantsList.lastName }"></c:out>	
	</td>
	<td>
	<c:out value="${applicantsList.emailId }"></c:out>	
	</td>
	<td>
	${requestScope.job_uid}
	</td>
	<td>	
	<a href="<c:out value="viewapplicantprofile.do" />?acctid=${applicantsList.accountId }&job_uid=${requestScope.job_uid}">View Profile</a>
	</td>						
	</tr>
</c:forEach>
</table>

</div>
</div>
</body>
</html>