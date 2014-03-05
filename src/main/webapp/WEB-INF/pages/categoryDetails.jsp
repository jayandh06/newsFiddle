<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@page import="java.util.Map,javax.servlet.jsp.PageContext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/main.css"
	type="text/css">
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/main.js"></script>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/category.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/resources/js/jquery/jquery-1.11.0.js"></script>

<title>Manage Category Detail</title>
</head>
<body>
	<div id="page-container">


		<div id="category-container" class="tableContainerLayout">
			<div id="messageContainer">
				<%
					String message = (String) request.getAttribute("message");
					if (message != null) {
				%>
				<%=message%>
				<%
					}
				%>

			</div>
			<form name="categoryDetailForm" method="post">
				<table>
					<tr>
						<td>Company Name</td>
						<td><input type="text" name="companyName" size="20"
							maxlength="45" /></td>
					</tr>
					<tr>
						<td>Company Url</td>
						<td><input type="text" name="companyUrl" size="20"
							maxlength="45" /></td>
					</tr>
					<tr>
						<td>Category</td>
						<td><select name="categoryId">
								<%
									Map<String, Integer> categoryMap = (Map<String, Integer>) request
											.getAttribute("categoryMap");
									for (String category : categoryMap.keySet()) {
								%>
								<option value="<%=categoryMap.get(category)%>">
									<%=category%></option>
								<%
									}
								%>
						</select></td>
					</tr>
					<tr>
						<td>RSS Url</td>
						<td><input type="text" name="rssUrl" size="" maxlength="200" /></td>
					<tr>
						<td colspan="2" align="center"><a
							href="javascript:categoryObj.validateCreateCategory('create');"
							class="mybtn">Create</a> &nbsp; <a
							href="javascript:categoryObj.validateModifyCategory('modify');"
							class="mybtn">Modify</a> &nbsp;<a href="" class="mybtn">Delete</a></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>