<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page session="false"%>

<html>
<head>
<style>
a {
	padding: 2px;
	text-decoration: none;
}

.center {
	margin-left: auto;
	margin-right: auto;
	width: 70%;
	background-color: #b0e0e6;
}

#danger {
	color: red;
}

a:active {
	color: black;
}
</style>
<title>Welcome</title>
<link rel="stylesheet" href="/kemosabe/resources/css/template.css" />
</head>
<body>

	<div id="header">
		<h1>KemoSabe Online Shopping</h1>
		<a class="navLink" href="<c:url value='?language=en' />">English</a>
		<a class="navLink" href="<c:url value='?language=fr' />">French</a>
	</div>

	<div id="nav">
		<a class="navLink" href="/kemosabe">Home</a><br />
	</div>

	<div id="section">
		<div class="center">

			<c:choose>
				<c:when test="${invalidCredentials eq 'true'}">
					<span style="color: red;">Invalid Username or password</span>
				</c:when>
			</c:choose>

			<form:form modelAttribute="user" method="POST">
				<div id="danger">
					<form:errors path="*" />
					<br />
				</div>

				<spring:message code="app.login.message.userName" />
				<form:input path="userName" type="text" />
				<form:errors path="userName"></form:errors>
				<br />

				<spring:message code="app.login.message.password" />
				<form:input path="password" type="password" />
				<form:errors path="password" />
				<br />

				<div align="right">
					<input type="submit" value="submit" /> <input type="reset"
						value="reset" />
				</div>
			</form:form>
		</div>
	</div>

	<div id="footer">Copyright © Kemosabee</div>

</body>
</html>
