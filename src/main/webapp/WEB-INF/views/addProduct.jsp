<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
<head>
<style type="text/css">
#header {
	background-color: black;
	color: white;
	text-align: center;
	padding: 5px;
}

#nav {
	line-height: 30px;
	background-color: #eeeeee;
	height: 300px;
	width: 100px;
	float: left;
	padding: 5px;
}

#section {
	float: left;
	padding: 10px;
}

#footer {
	background-color: black;
	color: white;
	clear: both;
	text-align: center;
	padding: 5px;
}
</style>
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="resources/css/template.css" />
</head>
<body>

	<div id="header">
		<h1>KemoSabe Online Shopping</h1>
	</div>

	<div id="nav"></div>
	<div id="section">
		<h1>Add Product For Sale</h1>
		<form:form modelAttribute="newProduct" method="post">
			<table>
				<tr>
					<td><label for="name"><spring:message
								code="addProduct.form.productName.label" /></label></td>
					<td><form:input id="productName" path="productName"
							type="text"></form:input> <form:errors path="productName" /></td>
				</tr>
				<tr>
					<td><label for="categoryId"><spring:message
								code="addProduct.form.category.label" /></label></td>
					<td><form:select path="categoryId">
							<form:option value="-">Select Category</form:option>
							<form:options items="${categories}" itemValue="categoryId"
								itemLabel="categoryName" />
						</form:select>
						<form:errors path="categoryId" /></td>
				</tr>
				<tr>
					<td><label for="productDescription"><spring:message
								code="addProduct.form.productDescription.label" /></label></td>
					<td><form:input id="productDescription"
							path="productDescription" type="text"></form:input> <form:errors
							path="productDescription" /></td>
				</tr>
				<tr>
					<td><label for="productPrice"><spring:message
								code="addProduct.form.productPrice.label" /></label></td>
					<td><form:input id="productPrice" path="productPrice"
							type="text"></form:input> <form:errors path="productPrice" /></td>
				</tr>
				<tr>
					<td><label for="productImage"><spring:message
								code="addProduct.form.productImage.label" /></label></td>
					<td><form:input id="productImage" path="productImage"
							type="file" /> <form:errors path="productImage" /></td>
				</tr>
				<tr>
					<td><input type="reset" id="btnReset" value="Reset" /></td>
					<td><input type="submit" id="btnAdd" value="Add Product" /></td>
				</tr>
			</table>
		</form:form>

	</div>

	<div id="footer">Copyright � Kemosabee</div>

</body>
</html>