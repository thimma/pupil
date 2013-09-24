<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Job</title>
<link href="css/profile.css" rel="stylesheet" type="text/css" />

<SCRIPT type="text/javascript">
function show_alert() {
	  if(confirm("Click 'OK' to save job and send email.Else,'cancel' to Save job without sending email")){
		document.getElementById('send_email').value='Y';
		document.forms['fm'].submit(); 
	    return true;
	    }
	  else{
		document.forms['fm'].elements["send_email"].value='N';
	  	document.forms['fm'].submit();  	
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
<a href="<c:url value="viewjobs.do"/>">View Jobs</a>
</div>

<div id="middle">
<form name="fm" method="post" action="createjobindb.do" onsubmit="return show_alert();">
<table >


	<tr>
		<td align="left" colspan=1>		
		<b>Job ID:</b> 
		</td>
		
		<td colspan=3>
		<input type="text" name="job_id" size="10"><br>
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
		
		<td>
		<a href="<c:url value="createnewemployer.jsp" />">Create a new Employer</a>
		</td>		
</tr>

<tr>
		<td align="left" colspan=1>		
		<b>Job Description:</b> 
		</td>
		
		<td colspan=3>
		<input type="text" name="job_description" size="100"><br>
		</td>
	</tr>

<tr>
		<td align="left" colspan=1>		
		<b>Job Creation Date:</b> 
		</td>
		
		<td colspan=3>
		<input type="text" name="job_creation_date" size="20"><br>
		</td>
	</tr>
	
<tr>
		<td align="left" colspan=1>		
		<b>Job Location:</b> 
		</td>
		
		<td colspan=3>
		<input type="text" name="job_location" size="30"><br>
		</td>
	</tr>
<tr>
		<td align="left" colspan=1>		
		<b>Part Time or Full Time:</b> 
		</td>
		
		<td colspan=3>
		<select name="parttime_fulltime">
		<option value="F">Full Time</option>
		<option value="P">Part Time</option>
		</select><br>
		</td>
	</tr>
	
<tr>
		<td align="left" colspan=1>		
		<b>Is Job Open</b> 
		</td>
		
		<td colspan=3>
		<select name="is_job_open">
		<option value="Y">Yes</option>
		<option value="N">No</option>
		</select><br>
		</td>
	</tr>
<tr>
		<td align="left" colspan=1>		
		<b>Job Summary:</b> 
		</td>
		
		<td colspan=3>
		<textarea rows="5" cols="80" name="job_summary">
		</textarea><br>
		</td>
	</tr>
<tr>
		<td align="left" colspan=1>		
		<b>Contact Person Name:</b> 
		</td>
		
		<td colspan=3>
		<input type="text" name="contact_person_name" size="30"><br>
		</td>
	</tr>

<tr>
		<td align="left" colspan=1>		
		<b>Contact Person Email:</b> 
		</td>
		
		<td colspan=3>
		<input type="text" name="contact_person_email" size="30"><br>
		</td>
</tr>
<tr>
		<td align="left" colspan=1>		
		<b>Contact Person Phone:</b> 
		</td>
		
		<td colspan=3>
		<input type="text" name="contact_person_phone" size="30"><br>
		</td>
	</tr>
<tr>
		<td align="left" colspan=1>		
		<b>Other Information:</b> 
		</td>
		
		<td colspan=3>
		<input type="text" name="others" size="100"><br>
		</td>
</tr>
<%-- <c:if test="${false}"> --%>
<tr>
<td>
<input type="hidden" name="send_email" id="send_email" size="10"><br>
</td>
</tr>
<%-- </c:if> --%>
</table>
<br>
<br>

<div align="center">
<input type="submit" value="Save"> 
</div>

<br>   
</form>


</div>
</div>
<%--<%@ include file="Footer.jsp" %> --%>
</body>
</html>