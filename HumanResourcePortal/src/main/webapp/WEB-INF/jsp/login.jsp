<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
	.login-content {
		background: aliceblue;
    	text-align: center;
    	padding: 20px;
    	border-radius: 10px;
	}

.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>

<form:form action="login" method="post">
<div id="login-box" class="login-content">
<h2>Login Page</h2>
Please provide your credential to use this website
<br>
<br>
<%
String isValid=""+session.getAttribute("test");

if(isValid.equalsIgnoreCase("Wrong credentials")){
	out.print("<font color=red>Username or password is Incorrect</font><br/>"); 
	session.setAttribute("test", "");

}
%>
<div id="login-box-name" style="margin-top:20px;">User Id:</div>
<div id="login-box-field" style="margin-top:20px;margin-bottom:20px">
<input name="username" class="form-login" title="username" value="" size="30" maxlength="50" required/>
<td><springForm:errors path="name" cssClass="error" /></td>

</div>
<div id="login-box-name">Password:</div>
<div id="login-box-field" style="margin-top:20px; margin-bottom:20px">
<input name="password" type="password" class="form-login" title="Password" value="" size="30" maxlength="48" required/>
<td><springForm:errors path="password" cssClass="error" /></td>

</div>
<br />
<span class="login-box-options">
New User?  <a href="register" style="margin-left:30px;">Register Here</a>
</span>
<br />
<br />
<input type="submit" value="login" />
</div>
</form:form>
</body>
</html>