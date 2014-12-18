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
<title>Error</title>
<link rel="stylesheet" href="/kemosabe/resources/css/template.css" />
</head>
<body>

	<div id="header">
		<h1>KemoSabe Online Shopping</h1>
	</div>

	<div id="nav">
		<a href="<c:url value='/'/>">Welcome</a> <br />
		<a href="<c:url value='/user/products/add'/>">Add New Product</a><br />
		<a href="<c:url value='/user/products/myProducts'/>">Your Products</a><br />
		<a href="">Products Bought</a><br />
		<a href="<c:url value='/user/logout'/>">logout</a><br />
	</div>

	<div id="section">
		<h1>${exception.message}</h1>
		<h3>${url}</h3>
	</div>

	<div id="footer">Copyright © Kemosabee</div>

</body>
</html>
