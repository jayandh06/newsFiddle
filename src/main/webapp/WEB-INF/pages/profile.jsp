<%@ page
	import="com.jay.news.fiddle.domain.User,com.jay.news.fiddle.util.NewsFiddleConstants"
	language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="scripts.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/profile.js"></script>

<%
	String username = (String) session
			.getAttribute(NewsFiddleConstants.SESSION_USER_NAME);
%>
<title>::RSS Fiddle:: Manage Profile</title>
</head>
<body>
<body>
	<div id="page-container">
		<jsp:include page="header.jsp" />
		<div id="form-container" class="tableContainerLayout">
			<div id="subtitleText">Manage your Profile</div>
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
			<form name="profileForm" method="post">
				<table>
					<tr>
						<td class="labelText">Username</td>
						<td><input type="text" name="username" size="20"
							maxlength="45" readonly="readonly" value="<%=username%>" /></td>
					</tr>
					<tr>
						<td class="labelText">First Name:</td>
						<td><input type="text" name="firstName" size="20"
							maxlength="45" /><span id="firstNameInfo">Your First Name</span></td>
					</tr>

					<tr>
						<td class="labelText">Last Name</td>
						<td><input type="text" name="lastName" size="20"
							maxlength="45" /><span id="lastNameInfo">Your Last Name</span></td>
					</tr>

					<tr>
						<td class="labelText">Gender</td>
						<td><input type="radio" name="gender" value="M"
							checked="checked">Male</input>&nbsp;<input type="radio"
							name="gender" value="F">Female</input><span id="lastNameInfo">Are
								you Male/ Female?</span></td>
					</tr>

					<tr>
						<td class="labelText">Primary Email</td>
						<td><input type="text" name="primaryEmail" size="20"
							maxlength="45" /><span id="primaryEmailInfo">Your Primary
								Email</span></td>
					</tr>

					<tr>
						<td class="labelText">Country</td>
						<td><select name="countryId">
								<option value="">-- Select Your country --</option>
						</select><span id="countryInfo">Which Country do you live in?</span></td>
					</tr>
					<tr>
						<td class="labelText">Zip Code</td>
						<td><input type="text" name="zipCode" size="6" maxlength="45" /><span
							id="zipCodeInfo">Your ZipCode</span></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><a
							href="javascript:profileObj.validateProfile('create');"
							class="anchorButton">Create</a> &nbsp; <a
							href="javascript:profileObj.validateProfile('update');"
							class="anchorButton">Modify</a></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</body>
</html>