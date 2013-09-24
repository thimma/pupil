<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apply to this job</title>
<link href="css/profile.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="Header.jsp"%>
<div id="centered">

<div id="left">
</div>
<div id="index">
<a href="profile.do">Profile</a>
<br>
<a href="<c:url value="viewjobs.do"/>">View Jobs</a>
</div>

<div id="middle">
<div><b>${detailJob.job_description }</b></div>
<br>
<br>
<form method="post" action="applytothisjob.do?id=${detailJob.job_uid }" enctype="multipart/form-data">
<strong>Submit Resume</strong>
<br>
<br>
<a href="<c:url value="getresume.do" />" target="_blank" >View Resume from Profile</a>
<div align="justify">Use Resume from profile
<select name="useprofile">
		<option value="Y">Yes</option>
		<option value="N">No</option>
</select>
</div>

<br>
<br>
Upload Resume for this Job
<br>
<input type="file" name="RESUME">
<br>
<br>
Cover Letter for this job
<br>
<textarea rows="15" cols="70" name="COVER_LETTER">
${requestScope.studentResumeDetails.coverLetter }
</textarea>
<br>
<br>
<input type="submit" value="Submit" align="middle">
</form>
</div>
</div>
</body>
</html>