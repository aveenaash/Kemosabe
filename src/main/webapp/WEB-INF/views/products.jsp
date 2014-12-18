<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    line-height:30px;
    background-color:#eeeeee;
    height:300px;
    width:150px;
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

#container{
    padding:5px;
}

#prod{

    height:300px;
    width:800px;
	margin-right:20px;
	margin-left:20px;
	
	border:1px solid #cccccc; 
}


</style>
<title>Products</title>
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
		<div id="container">
			<table>
					<c:forEach items="${products}" var="product">
						<tr id="prod">
								<td style="width:400px;">
								<img style="width: 200px; height: 200px;" src="${pageContext.request.contextPath}/image/${product.productImage}" alt="image"/>
								</td>
								<td style="width:400px;">
									<h3>${product.productName}</h3>
									<p>${product.productDescription}</p>
									<p>${product.productPrice} USD</p>
									<p>${product.productUploadedDate}</p>
									<p><c:if test="${product.productAvailability == 1}">
									Available for Sale
									</c:if>
									<c:if test="${product.productAvailability == 0}">
									Sold
									</c:if>
									</p>							
								</td>
						</tr>
					</c:forEach>
				</table>
		</div>	
	</div>	



	<div id="footer">Copyright © Kemosabee</div>

</body>
</html>
