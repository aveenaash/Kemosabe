<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</style>
<title>Welcome</title>
<link rel="stylesheet" href="resources/css/template.css" />
</head>
<body>

	<div id="header">
		<h1>KemoSabe Online Shopping</h1>
	</div>

	<div id="nav">
	
	</div>

	<div id="section">
		<div class="row">
			<%-- 			<c:forEach items="${products}" var="product"> --%>
			<div style="padding-bottom: 15px">
				<div>
					<%-- 					<img src="<c:url value="/resource/images/${product.productId}.png"></c:url>" alt="image"  style = "width:100%"/> --%>
					<div class="caption">
						<h3>product.name}</h3>
						<p>product.description}</p>
						<p>product.unitPrice}USD</p>
						<p>Available product.unitsInStock} units in stock</p>
						<p>
							<a
								href=" <spring:url value="/products/product?id=${product.productId}" /> "
								class="btn btn-primary"> <span
								class="glyphicon-info-sign glyphicon" /></span> Details
							</a>
						</p>
					</div>
				</div>
			</div>
			<%-- 			</c:forEach> --%>
			<div style="padding-bottom: 15px">
				<div>
					<%-- 					<img src="<c:url value="/resource/images/${product.productId}.png"></c:url>" alt="image"  style = "width:100%"/> --%>
					<div class="caption">
						<h3>product.name}</h3>
						<p>product.description}</p>
						<p>product.unitPrice}USD</p>
						<p>Available product.unitsInStock} units in stock</p>
						<p>
							<a
								href=" <spring:url value="/products/product?id=${product.productId}" /> "
								class="btn btn-primary"> <span
								class="glyphicon-info-sign glyphicon" /></span> Details
							</a>
						</p>
					</div>
				</div>
			</div>
			
		</div>
	</div>

	<div id="footer">Copyright © Kemosabee</div>

</body>
</html>
