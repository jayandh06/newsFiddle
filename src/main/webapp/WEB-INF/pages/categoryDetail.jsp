<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@page import="java.util.Map,javax.servlet.jsp.PageContext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="scripts.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/categoryDetail.js"></script>
<title>Manage Category Detail</title>
</head>
<body>
	<div id="page-container">
		<jsp:include page="header.jsp" />
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
		<div id="categoryDetail-list" class="listContainerLayout">
			<div>
				<a href="javascript:categoryDetailObj.addCategoryDetail();">Add Category Detail</a>
			</div>
			<table id="categorydetail-list-table">
				<tr class='headerRow'>
					<th class="headerCell">Id</th>
					<th class="headerCell">Provider</th>
					<th class="headerCell">Provider URL</th>
					<th class="headerCell">RSS URL</th>
					<th class="headerCell">Category Name</th>
				</tr>
			</table>
		</div>
		<div id="categoryDetail-container" class="tableContainerLayout">

			<form name="categoryDetailForm" method="post">
				<table>
					<tr>
						<td class="labelText">Category Detail Id</td>
						<td><input type="text" name="categoryDetailId" size="5"
							maxlength="45" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="labelText">Company Name</td>
						<td><input type="text" name="companyName" size="20"
							maxlength="45" /></td>
					</tr>
					<tr>
						<td class="labelText">Company Url</td>
						<td><input type="text" name="companyUrl" size="20"
							maxlength="45" /></td>
					</tr>
					<tr>
						<td class="labelText">Category</td>
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
						<td class="labelText">RSS Url</td>
						<td><input type="text" name="rssUrl" size="" maxlength="200" /></td>
					<tr>
						<td colspan="2" align="center"><a
							href="javascript:categoryDetailObj.validateCategoryDetail('create');"
							class="anchorButton">Create</a> &nbsp; <a
							href="javascript:categoryDetailObj.validateCategoryDetail('update');"
							class="anchorButton">Modify</a> &nbsp;<a
							href="javascript:categoryDetailObj.validateCategoryDetail('delete');"
							class="anchorButton">Delete</a></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>