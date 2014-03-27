<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::RSS Fiddle:: Feeds</title>
<jsp:include page="scripts.jsp"></jsp:include>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/feeds.css"
	type="text/css">
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/feeds.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="page-container">
		<div id="menu-container"></div>
		<div id="feeds-container"></div>
	</div>
</body>
</html>