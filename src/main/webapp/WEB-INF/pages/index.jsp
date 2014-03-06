<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="javax.servlet.jsp.PageContext"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>:: Welcome to News-Fiddle</title>
<jsp:include page="scripts.jsp"></jsp:include>	
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/login.js"></script>

</head>
<body>

	<div id="page-container">
		<jsp:include page="header.jsp"></jsp:include>		
		<div id="login-container" style="tableContainerLayout">
			<form action="/news/login" onsubmit="validate(this)" method="post">
				<table>
					<tr>
						<td class="labelText">Username</td>
						<td><input type="text" name="username" size="20" /></td>
					</tr>
					<tr>
						<td class="labelText">Password</td>
						<td><input type="password" name="password" size="20" /></td>
					</tr>
					<tr>
						<td colspan="2"> <a href="" class="mybtn">Login</a></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2"><font class="labelText">New User? </font> <a href="login/signup.htm" class="mybtn">signup
								here</a></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>