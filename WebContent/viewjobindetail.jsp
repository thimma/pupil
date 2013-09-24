<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Details</title>
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
<td colspan=2>
<div align="center"><b>${detailJob.job_description }</b></div>
<br>
<c:choose>
<c:when test="${userGroup eq 'student' }">
<div align="center"><div class="buttons"><a href="<c:out value="applyjob.do" />?id=${detailJob.job_uid }">Apply</a></div>
</div>
</c:when>
<c:otherwise>
<div align="center"><div class="buttons"><a href="<c:out value="editjob.do" />?id=${detailJob.job_uid }">Edit</a></div>
</div>
</c:otherwise>
</c:choose>
<br>
</td>
</tr>
<tr>
</tr>
<tr>
<td>
<div align="left"><b>Job Creation Date:</b></div>
</td>

<td>
${detailJob.job_creation_date }
</td>

</tr>

<tr>

<td>
<div align="left"><b>Job Location:</b></div>
</td>

<td>
${detailJob.job_location }
</td>

</tr>

<tr>

<td>
<div align="left"><b>Part Time or Full Time:</b></div>
</td>

<td>
${detailJob.parttime_fulltime }
</td>

</tr>
<tr>

<td>
<div align="left"><b>Job Summary:</b></div>
</td>

<td>
${detailJob.job_summary }
</td>

</tr>

<tr>

<td>
<div align="left"><b>Is Job Open:</b></div>
</td>

<td>
${detailJob.is_job_open }
</td>

</tr>

<c:if test="${userGroup eq 'faculty' }">
<tr>
<td><div align="left"><b>Job ID:</b></div></td>
<td>${detailJob.job_id }</td>
</tr>

<tr>

<td>
<div align="left"><b>Employer ID:</b></div>
</td>

<td>
${detailJob.employer_id }
</td>

</tr>

<tr>

<td>
<div align="left"><b>Contact Person Name:</b></div>
</td>

<td>
${detailJob.contact_person_name }
</td>

</tr>

<tr>

<td>
<div align="left"><b>Contact Person Email:</b></div>
</td>

<td>
${detailJob.contact_person_email }
</td>

</tr>
<tr>

<td>
<div align="left"><b>Contact Person Phone:</b></div>
</td>

<td>
${detailJob.contact_person_phone }
</td>

</tr>
<tr>

<td>
<div align="left"><b>Others:</b></div>
</td>

<td>
${detailJob.others }
</td>

</tr>
</c:if>

</table>
</div>
</div>
<%-- <%@ include file="Footer.jsp" %>--%>
</body>
</html>