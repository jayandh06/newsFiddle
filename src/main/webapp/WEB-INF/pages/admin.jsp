<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>News-Fiddle Administration</title>
<jsp:include page="scripts.jsp"></jsp:include>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/admin.js"></script>
</head>
<body>
	<div id="page-container">
		<jsp:include page="header.jsp"></jsp:include>
		<div>
			<a  href="${pageContext.servletContext.contextPath}/admin/category" class="mybtn">Category</a>
		</div>
		<div>
			<a
				href="${pageContext.servletContext.contextPath}/admin/categoryDetail" class="mybtn">Category
				Details</a>
		</div>
		<div>
			<a href="${pageContext.servletContext.contextPath}/admin/user" class="mybtn">User</a>
		</div>			
</body>

</html>