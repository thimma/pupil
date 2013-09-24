<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Profile</title>
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
<form method="post" action="updateProfile.do" enctype="multipart/form-data">
<strong>Personal Information</strong> 
<br>
<br>
First Name
<br>
${requestScope.studentAccountDetails.firstName}
<!--  <input type="text" name="FIRST_NAME" value="${requestScope.studentAccountDetails.firstName}"> -->
<br>
Last Name
<br>
${requestScope.studentAccountDetails.lastName}
<!-- <input type="text" name="LAST_NAME" value="${requestScope.studentAccountDetails.lastName}"> -->
<br>
E-mail
<br>
${requestScope.studentAccountDetails.emailId}
<!-- <input type="text" name="EMAIL_ID" value="${requestScope.studentAccountDetails.emailId}"> -->
<br>
<br>
<br>
<strong>Contact Information</strong> 
<br>
<br>
Address
<br>
<input type="text" name="ADDRESS" value="${requestScope.studentContactDetails.address}">
<br>
Phone Number
<br>
<input type="text" name="PHONE_NUMBER" value="${requestScope.studentContactDetails.phoneNumber}">
<br>
Mobile Number
<br>
<input type="text" name="MOBILE_NUMBER" value="${requestScope.studentContactDetails.mobileNumber}">
<br>
City
<br> 
<input type="text" name="CITY" value="${requestScope.studentContactDetails.city}">
<br>
State 
<br>
<input type="text" name="STATE" value="${requestScope.studentContactDetails.state}">
<br>
Zip
<br>
<input type="text" name="ZIP" value="${requestScope.studentContactDetails.zip}">
<br>
Country
<br>
<input type="text" name="COUNTRY" value="${requestScope.studentContactDetails.country}">
<br>
<br>
<br>
<strong>Current Program</strong>
<br>
<br>
Current Program
<br>
<input type="text" name="CURRENT_PROGRAM" value="${requestScope.studentCurrentProgramDetails.currentProgram}">
<br>
Level
<br>
<input type="text" name="LEVEL" value="${requestScope.studentCurrentProgramDetails.level}">
<br>
Expected Graduation Date
<br>
<input type="text" name="EXPECTED_GRAD_DATE" value="${requestScope.studentCurrentProgramDetails.expectedGradDate}">
<br>
College
<br>
<input type="text" name="COLLEGE" value="${requestScope.studentCurrentProgramDetails.college}">
<br>
Campus
<br>
<input type="text" name="CAMPUS" value="${requestScope.studentCurrentProgramDetails.campus}">
<br>
Major
<br>
<input type="text" name="MAJOR" value="${requestScope.studentCurrentProgramDetails.major}">
<br>
Department
<br>
<input type="text" name="DEPARTMENT" value="${requestScope.studentCurrentProgramDetails.department}">
<br>
<br>
<br>
<strong>Resume</strong>
<br>
<br>
Upload Resume
<br>
<input type="file" name="RESUME">
<a href="<c:url value="getresume.do" />" target="_blank">View Resume</a>
<br>
Upload Cover Letter
<br>
<textarea rows="15" cols="70" name="COVER_LETTER">
${requestScope.studentResumeDetails.coverLetter }
</textarea>
<br>
<br>
<input type="submit" value="Save Profile" align="middle">
</form>
</div>

<!-- <div id="right">
</div>-->
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>