<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<style>
a {
	padding: 2px;
	text-decoration: none;
}

a:active {
	color: black;
}
</style>
<title>Welcome</title>
<link rel="stylesheet" href="/kemosabe/resources/css/template.css" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

</head>
<body>

	<div id="header">
		<h1>KemoSabe Online Shopping</h1>
	</div>

	<div id="nav">
		<a class="navLink" href="login">Login</a><br />
		 <a class="navLink" href="signup">Sign Up</a><br />
	</div>

	<div id="section">
		    <form:form modelAttribute="signup" method="POST">
			<span style="color: red;"><form:errors path="*" /> <br/></span>
		
			<spring:message code="app.signup.username" />
			<form:input path="username" type="text"/> 
			<span style="color: red"><form:errors path="username" /></span>
			<br />
			
			<spring:message code="app.signup.password" />
			<form:input path="password" type="password"/> 
			<span style="color: red"><form:errors path="password" /></span>
			<br />
			
			<spring:message code="app.signup.addressLine1" />
			<form:input path="addressLine1" type="text"/> 
			<span style="color: red"><form:errors path="addressLine1" /></span>
			<br />
			
			<spring:message code="app.signup.city" />
			<form:input path="city" type="text"/> 
			<span style="color: red"><form:errors path="city" /></span>
			<br />
			
			<spring:message code="app.signup.state" />
			<form:input path="state" type="text"/> 
			<span style="color: red"><form:errors path="state" /></span>
			<br />
			
			<spring:message code="app.signup.country" />
			<form:input path="country" type="text"/> 
			<span style="color: red"><form:errors path="country" /></span>
			<br />
			
			<spring:message code="app.signup.zipcode" />
			<form:input path="zipcode" type="text"/> 
			<span style="color: red"><form:errors path="zipcode" /></span>
			<br />
			
			<spring:message code="app.signup.email" />
			<form:input path="email" type="text"/> 
			<span style="color: red"><form:errors path="email" /></span>
			<br />
			
			<spring:message code="app.signup.visiblename" />
			<form:input path="visiblename" type="text"/> 
			<span style="color: red"><form:errors path="visiblename" /></span>
			<br />
			
			<input type="submit" value="Signup" />
		</form:form>
	</div>

	<div id="footer">Copyright © Kemosabee</div>

</body>
</html>
