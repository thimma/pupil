<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script>

window.onload=function() {

	document.getElementById("email").focus();
	document.getElementById("email").onblur=mandatoryField;
  document.getElementById("password").onblur=mandatoryField;
  document.getElementById("signup").onsubmit=finalCheck;
}

function removealert() {

   var msg = document.getElementById("msg");
   if (msg) {
      document.body.removeChild(msg);
   }
}

function resetField(elem) {
   elem.parentNode.setAttribute("style","background-color: #ffffff");
   var valid = elem.getAttribute("aria-invalid");
   if (valid) elem.removeAttribute("aria-invalid");
}

function badField(elem) {
  elem.parentNode.setAttribute("style", "background-color: #dbd9d9");
  elem.setAttribute("aria-invalid","true");
}
function generatealert(txt) {

   // create new text and div elements and set
   // Aria and class values and id
   var txtNd = document.createTextNode(txt);
   msg = document.createElement("div");
   msg.setAttribute("role","alert");
   msg.setAttribute("id","msg");
   msg.setAttribute("class","alert");

   // append text to div, div to document
   msg.appendChild(txtNd);
   document.body.appendChild(msg);
}

function validateField() {

  // remove any existing alert regardless of value
  removealert();

  // check for number
  if (!isNaN(parseFloat(this.value))) {
     resetField(this);
  } else {
     badField(this);
     generatealert("You entered an invalid value in Third Field.Only numeric values such as 105 or 3.54 are allowed");
  }
}

function mandatoryField() {

   // remove any existing alert
   removealert();

   // check for value
   if (this.value.length > 0) {
     resetField(this);
   } else {
     badField(this);
     generatealert("You must enter a value in required Fields");
   }
}
function finalCheck() {

  removealert();

  var fields = document.querySelectorAll("[aria-invalid='true']");
  if (fields.length > 0) {
    generatealert("You have incorrect fields entries that must be fixed before you can submit this form");
    return false;
  }
}

</script>
</head>
<body>

<%@ include file="Header.jsp"%> 

<div id="centered">
<div id="left">
</div>
<div id="index">
</div>
<div id="middle">

<div id="midtop">
</div>

<div id="login">

<div id="loginleft">
</div>

<div id="loginmid">
<form method="post" id="signup" action="signup.do">
<center><input type="submit" name="submitButton" value="Sign-up"></center>
<br>
<div>
<label for="email">
E-mail*:
</label>
<br>
<input id="email" type="text" name="EMAIL_ID" aria-required="true">
</div>
<br>
<div>
<label for="password">
Password*:
</label>
<br>
<input id="password" type="password" name="PASSWORD" aria-required="true">
<br>
 </div>       
<input type="submit" name="submitButton" value="Sign-in" align="middle">
<br>

<center><a href="<c:url value="forgotpassword.do" />">forgot password</a></center>
</form>
</div>

<div id="loginright">
</div>

</div>

<div id="midbot">
</div>

</div>

<!--<div id="right">  -->

<!-- </div> -->

</div>
<%@ include file="Footer.jsp" %>

</body>
</html>