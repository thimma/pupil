<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Jobs List</title>
<link href="css/profile.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
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

<div id="mid">

<form method="get" action="groupJobs.do">
<input type="submit" value="Group Jobs by">

<select name="employer_id">
	<c:forEach var="employers" items="${employers}">		
			<option value="${employers.key}">${employers.value}</option>		
	</c:forEach>
</select>

Jobs which are:

<select name="is_job_open">
	<option value="Y">Open</option>
	<option value="N">Closed</option>
</select>

In the Date Range From:
<input type="text" name="jobs_from_date" size="10" id="datepicker">
To :
<input type="text" name="jobs_to_date" size="10">
</form>
<br>
<table border='1'>
<c:forEach var="jobList" items="${jobsList}">	
	<tr>	
	<td>
	<c:out value="${jobList.job_id }"></c:out>	
	</td>
	<td>
	<c:out value="${jobList.job_description }"></c:out>	
	</td>
	<td>
	<!--  <a href="<c:url value="viewjobindetail.do?id=${jobList.job_id }" />">View</a>
	<a href="<c:url value="viewjobindetail.do" var="detailjoburl" >
	<c:param name="id" value="${jobList.job_id }"></c:param>
	</c:url>">View</a> -->
	
	<a href="<c:out value="viewjobindetail.do" />?id=${jobList.job_uid }">View Job</a>
	</td>
	<c:if test="${userGroup eq 'faculty' }">
	<td>
	<a href="<c:out value="viewapplicants.do" />?id=${jobList.job_uid }">View Applicants</a>
	</td>
	</c:if>					
	</tr>
	
</c:forEach>
</table>
</div>

</div>
<%-- <%@ include file="Footer.jsp" %> --%>
</body>
</html>