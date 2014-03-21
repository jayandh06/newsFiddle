<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::RSS Fiddle:: Hot News</title>
<jsp:include page="scripts.jsp"></jsp:include>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/news.css"
	type="text/css">
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/news.js"></script>
</head>
<body>
	<div id="page-container">
		<jsp:include page="header.jsp"></jsp:include>
		<div id="menu-container"></div>
		<div id="news-container"></div>
	</div>
</body>
</html>