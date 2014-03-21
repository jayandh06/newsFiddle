<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@page import="java.util.Map,javax.servlet.jsp.PageContext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="scripts.jsp"></jsp:include>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/category.css"
	type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/categoryDetail.js"></script>
<title>::RSS Fiddle:: Manage Category Detail</title>
</head>
<body>
	<div id="page-container">
		<jsp:include page="header.jsp" />
		<div id="menu-container">
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
		<div id="message-container" class="messageText">
			<%
				String message = (String) request.getAttribute("message");
				if (message != null) {
			%>
			<%=message%>
			<%
				}
			%>

		</div>
		<div id="list-container" class="listContainerLayout">
			<div>
				<a href="javascript:categoryDetailObj.addCategoryDetail();">Add
					Category Detail</a>
			</div>
			<table id="categorydetail-list-table">
				<tr class='headerRow'>
					<td class="headerCell">Id</td>
					<td class="headerCell">Provider</td>
					<td class="headerCell">Provider URL</td>
					<td class="headerCell">RSS URL</td>
					<td class="headerCell">Category Name</td>
				</tr>
			</table>
		</div>
		<div id="form-container" class="tableContainerLayout">
			<form name="categoryDetailForm" method="post">
				<div id="subtitleText">Category Details Form</div>
				<table>
					<tr>
						<td class="labelText">Category Detail Id</td>
						<td><input type="text" name="categoryDetailId" size="5"
							maxlength="45" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="labelText">Provider Name</td>
						<td><input type="text" name="providerName" size="20"
							maxlength="45" /><span id="providerNameInfo">Name of Feed
								provider?, Atleast 4 chars.</span></td>
					</tr>
					<tr>
						<td class="labelText">Provider Url</td>
						<td><input type="text" name="providerUrl" size="20"
							maxlength="45" /><span id="providerUrlInfo">Feed provider
								URL?</span></td>
					</tr>
					<tr>
						<td class="labelText">Category</td>
						<td><select name="categoryId">
								<option value="">-- Choose Category --</option>
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
						</select><span id="categoryIdInfo">Choose your Feed Category from
								list</span></td>
					</tr>
					<tr>
						<td class="labelText">RSS Url</td>
						<td><input type="text" name="rssUrl" size="" maxlength="200" /><span
							id="rssUrlInfo">Feed URL?</span></td>
					</tr>
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