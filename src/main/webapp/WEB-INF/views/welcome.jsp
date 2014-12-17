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
		<div id="container">
			<table>
				<c:forEach items="${products}" var="product" varStatus="status">
						<c:choose>
						
							<c:when test="${((status.index) % 2) eq 0 }">
								<tr id="prod" style="background-color: lightblue;">
							</c:when>
							<c:otherwise>
								<tr id="prod" style="background-color: lightblue;">
							</c:otherwise>
						</c:choose>
							<td style="width: 400px;" ><img
								src="<c:out value="${product.productImage}"/>" alt="image" /></td>
							<td style="width: 400px; background-color: lightred;">
								<h3>${product.productName}</h3>
								<p>${product.productDescription}</p>
								<p>${product.productPrice}USD</p>
								<p>${product.productUploadedDate}</p>
								<p>
									<c:if test="${product.productAvailability == 1}">
									Available for Sale
									</c:if>
									<c:if test="${product.productAvailability == 0}">
									Sold
									</c:if>
								</p>
								<a href="<c:url value='/user/products/buy?productId=${product.productId}'/>">Buy</a>
							</td>
						</tr>
				</c:forEach>
			</table>
		</div>
	</div>


	<div id="footer">Copyright © Kemosabee</div>

</body>
</html>
