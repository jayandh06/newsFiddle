<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<jsp:include page="scripts.jsp"></jsp:include>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/category.js"></script>

<title>Manage Category</title>
</head>
<body>
	<div id="page-container">
		<jsp:include page="header.jsp"></jsp:include>
		<div id="category-menucontainer">
			<div class="category-element">
				<a class="alink"
					href="${pageContext.servletContext.contextPath}/admin/category">Category</a>
			</div>
			<div class="category-element">
				<a class="alink"
					href="${pageContext.servletContext.contextPath}/admin/categoryDetail">Category
					Details</a>
			</div>
			<div class="category-element">
				<a class="alink"
					href="${pageContext.servletContext.contextPath}/admin/user">User</a>
			</div>
		</div>

		<div id="messageContainer" class="messageText">
			<%
				String message = (String) request.getAttribute("message");
				if (message != null) {
			%>
			<%=message%>
			<%
				}
			%>

		</div>
		<div id="category-list" class="listContainerLayout">
			<div><a href="javascript:categoryObj.addCategory();">Add Category</a></div>
			<table id="category-list-table">
				<tr class='headerRow'>
					<th class="headerCell">Category Id</th>
					<th class="headerCell">Category Name</th>
				</tr>
			</table>
		</div>
		<div id="category-container" class="tableContainerLayout">

			<form name="categoryForm" method="post">
				<table>
					<tr>
						<td class="labelText">Category Id</td>

						<td><input type="text" name="categoryId" size="5"
							maxlength="5" readonly="readonly" /></td>
					<tr>
						<td class="labelText">Category Name</td>
						<td><input type="text" name="categoryName" size="20"
							maxlength="45" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><a
							href="javascript:categoryObj.validateCategory('create');"
							class="anchorButton">Create</a> &nbsp; <a
							href="javascript:categoryObj.validateCategory('modify');"
							class="anchorButton">Modify</a> &nbsp;<a
							href="javascript:categoryObj.validateCategory('delete');"
							class="anchorButton">Delete</a></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>