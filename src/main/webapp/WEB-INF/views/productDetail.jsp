<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<html>
<head>
<style type="text/css">
#header {
    background-color:black;
    color:white;
    text-align:center;
    padding:5px;
}
#nav {
	margin-top:20px;
	margin-bottom:20px;
    line-height:30px;
    background-color:#eeeeee;
    height:300px;
    width:200px;
    float:left;
    padding:5px; 
}
#section {
    float:left;
    padding:10px; 
}
#footer {
    background-color:black;
    color:white;
    clear:both;
    text-align:center;
    padding:5px; 
}
a {
	padding: 2px;
	text-decoration: none;
}

a:active {
	color: black;
}
</style>
<title>Product Detail</title>
<link rel="stylesheet" href="/kemosabe/resources/css/template.css" />
</head>
<body>
	
	<sec:authorize access="hasRole('ROLE_USER')"></sec:authorize>
	<div id="header">
		<h1>KemoSabe Online Shopping</h1>
		<br/>
		<h5>Welcome ${loggedUser.userName}</h5>
	</div>

	<div id="nav">
		<a href="<c:url value='/'/>">Welcome</a> <br />
		<a href="<c:url value='/user/products/add'/>">Add New Product</a><br />
		<a href="<c:url value='/user/products/myProducts'/>">Your Products</a><br />
		<a href="">Products Bought</a><br />
		<a href="<c:url value='/user/logout'/>">logout</a><br />
	</div>

	<div id="section">
		<img/>
		<h1>Product Detail Name</h1>
		<p>Description</p>
		<p>Price</p>
		<form action="buy" method="post">
		<input type="hidden" id="productId" value="35" />
		<input type="submit" id="btnAdd" value="Buy" />
		</form>
	</div>

	<div id="footer">Copyright © Kemosabee</div>

</body>
</html>
