<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<title>Add Product</title>
<link rel="stylesheet" type="text/css" href="/kemosabe/resources/css/template.css" />
</head>
<body>

	<div id="header">
		<h1>KemoSabe Online Shopping</h1>
		<br/>
		<h5>Welcome ${loggedUser.userName}</h5>
	</div>

	<div id="nav">
		<a href="<c:url value='user/products/add'/>">Add New Product</a><br />
		<a href="<c:url value='user/products/add'/>">Your Products</a><br />
		<a href="">Products Bought</a><br />
	</div>
	<div id="section">
		<h1>Add Product For Sale</h1>
		<form:form modelAttribute="newProduct" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td><label for="name">
						<spring:message code="addProduct.form.productName.label" /></label></td>
					<td><form:input id="productName" path="productName"
							type="text"></form:input> <form:errors path="productName" /></td>
				</tr>
				<tr>
					<td><label for="categoryId"><spring:message
								code="addProduct.form.category.label" /></label></td>
					<td><form:select path="categoryId">
							<form:option value="0">Select Category</form:option>
							<form:options items="${categories}" itemValue="categoryId"
								itemLabel="categoryName" />
						</form:select>
						<form:errors path="categoryId" /></td>
				</tr>
				<tr>
					<td><label for="productDescription"><spring:message
								code="addProduct.form.productDescription.label" /></label></td>
					<td><form:textarea id="productDescription" rows="4" cols="60"
							path="productDescription" type="text"></form:textarea> <form:errors
							path="productDescription" /></td>
				</tr>
				<tr>
					<td><label for="productPrice"><spring:message
								code="addProduct.form.productPrice.label" /></label></td>
					<td><form:input id="productPrice" path="productPrice"
							type="text"></form:input> <form:errors path="productPrice" /></td>
				</tr>
				<tr>
					<td><label for="productImg"><spring:message
								code="addProduct.form.productImage.label" /></label></td>
					<td><form:input id="productImg" path="productImg"
							type="file" /> <form:errors path="productImg" /></td>
				</tr>
				<tr>
					<td><input type="reset" id="btnReset" value="Reset" /></td>
					<td><input type="submit" id="btnAdd" value="Add Product" /></td>
				</tr>
			</table>
		</form:form>
	</div>

	<div id="footer">Copyright © Kemosabee</div>

</body>
</html>
