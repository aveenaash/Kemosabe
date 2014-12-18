<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

		<a class="navLink" href="<c:url value='/?language=en' />">English</a>
		<a class="navLink" href="<c:url value='/?language=fr' />">French</a>
		<br/>
			<form action="findProducts" method="post">
			
				<input type="text" name="search"/>
				<%-- <form:select path="categoryId">
					<form:option value="0">Select Category</form:option>
					<form:options items="${categories}" itemValue="categoryId" itemLabel="categoryName" />
				</form:select> --%>	
				<input type="submit" value="Find"/>
			</form>
	</div>

	<div id="nav">
		<c:choose>
			<c:when test="${empty loggedUser}">
				<a class="navLink" href="login">Login</a> <br />
				<a class="navLink" href="signup">Sign Up</a> <br />
			</c:when>
			<c:otherwise>
				<a class="navLink" href="<c:url value='/user/home' />">Home</a> <br />
			</c:otherwise>
		</c:choose>
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
					<td style="width: 400px;"><img style="width: 200px; height: 200px;"
						src="${pageContext.request.contextPath}/image/${product.productImage}" alt="image" /></td>
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
						</p> <a
						href="<c:url value='/user/products/buy?productId=${product.productId}'/>">Buy</a>
					</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>


	<div id="footer">Copyright © Kemosabee</div>

</body>
</html>
