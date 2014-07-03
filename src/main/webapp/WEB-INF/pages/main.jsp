<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::RSS Fiddle:: Feeds</title>
</head>
<body>
	<div id ="body-container"></div>
	<jsp:include page="tab.jsp"></jsp:include>
	<jsp:include page="login.jsp"></jsp:include>
	<jsp:include page="signup.jsp"></jsp:include>
	<div id="page-container">
		<jsp:include page="header.jsp"></jsp:include>
		<div id="feeds-container"></div>
		<jsp:include page="categoryList.jsp"></jsp:include>
	</div>
	
</body>
</html>
<jsp:include page="scripts.jsp"></jsp:include>