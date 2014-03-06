<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:: News-Fiddle :: Hot News</title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/main.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/news.css"
	type="text/css">
<script
	src="${pageContext.servletContext.contextPath}/resources/js/jquery/jquery-1.11.0.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/resources/js/jquery/plugins/jquery.loadTemplate-1.4.1.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/resources/js/jquery/plugins/jquery.tmpl.js"></script>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/main.js"></script>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/news.js"></script>

<script id="newsTemplate" type="text/x-jquery-tmpl">
<div class="">
	<div class="newsTitle">{%= title%}</div>
	<div class="newsDate">{%= updateDate%}</div>
    <div>{%html description.Text%}</div>
	<div class><a href='{%= uri%}'> Link to original page</a></div>
	<div><hr></div>
	<div>&nbsp;</div>
</div>
</script>
</head>
<body>
	<div id="page-container">
		<div id="newsContainer"></div>
	</div>
</body>
</html>