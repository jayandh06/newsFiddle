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
		<jsp:include page="header.jsp"></jsp:include>
		<div id="fb-root"></div>
		<div id="form-container" class="tableContainerLayout">
			<div id="subtitleText">RSS Fiddle Login</div>
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
			<div id="left-container">
				<form name="loginForm" method="post">
					<table>
						<tr>
							<td class="labelText">Username</td>
							<td><input type="text" name="username" size="20" /><span
								id="usernameInfo"></span></td>
						</tr>
						<tr>
							<td class="labelText">Password</td>
							<td><input type="password" name="password" size="20" /><span
								id="passwordInfo"></span></td>
						</tr>
						<tr>
							<td colspan="2"><a
								href="javascript:loginObj.validateLogin();" class="anchorButton">Login</a>
								<a href="javascript:loginObj.clearLogin();" class="anchorButton">Clear</a>
							</td>
						</tr>
						<tr>
							<td colspan="2"><a
								href="${pageContext.servletContext.contextPath}/login/showSignup"
								class="anchorButton">New User? Signup Here</a></td>
						</tr>
					</table>
				</form>
			</div>
			<div id="line-container">
			</div>
			<div id="right-container">
								<div class="labelText">Login with Facebook</div><br><br>
								<a
								href="javascript:loginObj.fbGetLoginStatus();"
								class="anchorButton">Facebook Login</a>
			</div>
		</div>
		<div></div>
	</div>
</body>
</html>