<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::RSS Fiddle:: Administration</title>
<jsp:include page="scripts.jsp"></jsp:include>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/settings.js"></script>
</head>
<body>
	<div id="page-container">
		<jsp:include page="header.jsp"></jsp:include>
		<div id="menu-container">
			<div class="category-element">
				<a class="alink" href="${pageContext.servletContext.contextPath}/admin/category">Manage Category</a>
			</div>
			<div class="category-element">
				<a class="alink" href="${pageContext.servletContext.contextPath}/admin/categoryDetail">Manage Category Details</a>
			</div>
			<div class="category-element">
				<a class="alink" href="${pageContext.servletContext.contextPath}/admin/user">Manage User</a>
			</div>
		</div>
	</div>
</body>

</html>