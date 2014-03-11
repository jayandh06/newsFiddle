<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>:: Welcome to News-Fiddle</title>
<jsp:include page="scripts.jsp"></jsp:include>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/login.js"></script>
</head>
<body>
	<div id="page-container">
		<jsp:include page="header.jsp" />


		<form name="signupForm" method="post">
		<div id="signup-container">
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
						<td class="labelText">Retype Password</td>
						<td><input type="password" name="password2" size="20" /><span id="password1Info">Re-type password</span></td>
					</tr>
					
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2"><a href="javascript:loginObj.validateSignup();" class="anchorButton">signup here</a></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>