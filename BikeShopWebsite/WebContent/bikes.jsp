<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bike Shop</title>
	<link rel="stylesheet" type="text/css" href="css/bikes.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<div id="brand">
		<h2>${requestScope.brand}</h2>
	</div>
	<div id="bikes">
	</div>
	
	<jsp:include page="footer.jsp" />
</body>
</html>