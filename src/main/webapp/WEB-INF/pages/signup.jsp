<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="javax.servlet.jsp.PageContext"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Welcome to ::RSS Fiddle::</title>
<jsp:include page="scripts.jsp"></jsp:include>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/login.js"></script>
</head>
<body>
	<div id="page-container">
		<jsp:include page="header.jsp" />


		<form name="signupForm" method="post">
		<div id="form-container" class="tableContainerLayout">
				<div id="subtitleText">New User Signup</div>
				<table>
					<tr>
						<td class="labelText">Username</td>
						<td><input type="text" name="username" size="20" /><span id="usernameInfo">Valid username, Atleast 6 chars.</span></td>
					</tr>
					<tr>
						<td class="labelText">Password</td>
						<td><input type="password" name="password1" size="20" /><span id="password1Info">Valid Password, Atleast 8 chars.</span></td>
					</tr>
					<tr>
						<td class="labelText">Confirm Password</td>
						<td><input type="password" name="password2" size="20" /><span id="password2Info">Re-type password</span></td>
					</tr>
					
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2"><a href="javascript:loginObj.validateSignup();" class="anchorButton">Signup here</a><a href="javascript:loginObj.clearLogin();" class="anchorButton">Clear</a></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>