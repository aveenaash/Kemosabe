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
	
	</div>
	
	<div id="section">
		<div id="container">
			<table>
					<c:forEach items="${products}" var="product">
						<tr id="prod">
								<td style="width:400px;">
									<img src="<c:url value="/resources/images/${product.productId}.png"></c:url>" alt="image"/>
								</td>
								
								<td style="width:400px;">
									<h3>${product.productName}</h3>
									<p>${product.productDescription}</p>
									<p>${product.productPrice} USD</p>
									<p>${product.productAvailability}</p>							
									<p>${product.productUploadedDate}</p>
									<p>
										<a href="<spring:url value="/products/myProducts" />"
											class="btn btn-primary"> <span
											class="glyphicon-info-sign glyphicon" /></span> Details
										</a>
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
