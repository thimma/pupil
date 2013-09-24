<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Job</title>
<link href="css/profile.css" rel="stylesheet" type="text/css" />
<SCRIPT type="text/javascript">
function show_alert() {
	  if(confirm("Click 'OK' to save job and send email.Else,'cancel' to Save job without sending email")){
		document.getElementById('send_email').value='Y';
		document.forms['upj'].submit(); 
	    return true;
	    }
	  else{
		document.forms['upj'].elements["send_email"].value='N';
	  	document.forms['upj'].submit();  	
	    return true;
	    }
}
</SCRIPT>
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
<a href="<c:url value="viewjobs.do" />">View Jobs</a>
</div>
<div id="middle">
<form name="upj" method="post" action="updatejob.do?id=${detailJob.job_uid }" onsubmit="return show_alert();" >
<table border='1'>

<tr>

<td>
<div align="left"><b>Job Description:</b></div>
</td>

<td>
<input type="text" name="job_description" value="${detailJob.job_description }" size="100">
</td>

</tr>


<tr>
<td>
<div align="left"><b>Job Creation Date:</b></div>
</td>

<td>
<input type="text" name="job_creation_date" value="${detailJob.job_creation_date }">
</td>

</tr>

<tr>
<td>
<div align="left"><b>Job Location:</b></div>
</td>

<td>
<input type="text" name="job_location" value="${detailJob.job_location }">
</td>

</tr>

<tr>
<td>
<div align="left"><b>Part Time or Full Time:</b></div>
</td>

<td>
<select name="parttime_fulltime">
		<option value="F">Full Time</option>
		<option value="P">Part Time</option>
</select>
</td>

</tr>

<tr>
<td>
<div align="left"><b>Job Summary:</b></div>
</td>

<td>
<textarea rows="25" cols="80" name="job_summary">
${detailJob.job_summary }
</textarea>
</td>

</tr>

<tr>
<td>
<div align="left"><b>Is Job Open:</b></div>
</td>

<td>
<select name="is_job_open">
		<option value="Y">Yes</option>
		<option value="N">No</option>
</select>
</td>

</tr>

<tr>
<td>
<div align="left"><b>Job ID:</b></div>
</td>

<td>
<input type="text" name="job_id" value="${detailJob.job_id }">
</td>

</tr>

<tr>
		<td align="left" colspan=1>		
		<b>Select Employer:</b> 
		</td>
		
		<td>
		<select name="employer_id">
		<c:forEach var="employers" items="${employers}">		
			<option value="${employers.key}">${employers.value}</option>		
		</c:forEach>
		</select>
		</td>		
</tr>

<tr>

<td>
<div align="left"><b>Employer:</b></div>
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
<input type="text" name="contact_person_name" value="${detailJob.contact_person_name }">
</td>

</tr>

<tr>
<td>
<div align="left"><b>Contact Person Email:</b></div>
</td>

<td>
<input type="text" name="contact_person_email" value="${detailJob.contact_person_email }">
</td>

</tr>

<tr>
<td>
<div align="left"><b>Contact Person Phone:</b></div>
</td>

<td>
<input type="text" name="contact_person_phone" value="${detailJob.contact_person_phone }">
</td>

</tr>

<tr>
<td>
<div align="left"><b>Others:</b></div>
</td>

<td>
<input type="text" name="others" value="${detailJob.others }">
</td>

</tr>

<%-- <td colspan=1><div align="center"><b>${detailJob.job_description }</b></div></td> --%>
<tr>
<td>
<input type="hidden" name="send_email" id="send_email" size="10"><br>
</td>
</tr>
</table>
<input type="submit" value="Save" align="middle">
</form>
</div>
</div>
<%-- <%@ include file="Footer.jsp" %> --%>
</body>
</html>