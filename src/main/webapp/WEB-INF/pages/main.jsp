<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::RSS Fiddle:: Feeds</title>
</head>
<body>
	<div id ="body-container"></div>
	<div id="tab-container">
	
		<img id="tab-arrow"  src="${pageContext.servletContext.contextPath}/resources/images/tab_icon.png" width="30" height="30" style="padding: 5px 10px">
		<div id="login-tab" style="display:none">
			<div><span class="loginMessageText" style="margin:20px 0px 0px 50px">Read your favorite feeds</span></div>
			<button id ="tab-login-button" style="margin:20px 0px 0px 50px">Login</button>
		</div>
	</div>
	<div id="login-container" class="modal_window">
			<div id="form-container" class="tableContainerLayout">
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
			<div id="login-left-container">
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
							<td colspan="2"><a id="login-submit-button" href="javascript:loginObj.validateLogin();">Login</a>
								<a id="login-clear-button" href="javascript:loginObj.clearLogin();">Clear</a>
							</td>
						</tr>
						<tr>
							<td colspan="2"><span>New to RSS Fiddle? &nbsp;</span><a id="login-signup-button"
								href="${pageContext.servletContext.contextPath}/login/showSignup"
								>Signup Here</a></td>
						</tr>
					</table>
				</form>
			</div>			
			<div id="login-right-container">
								<div class="labelText">Login with Facebook</div><br><br>
								<a id="login-fb-button"
								href="javascript:loginObj.fbGetLoginStatus();"
								class="anchorButton">Facebook Login</a>
			</div>
		</div>
	</div>
	<div id="page-container">
		<div id="top-container">
			<div id="header-container">
				<a href="${pageContext.servletContext.contextPath}/"><img
					src="http://www.logomaker.com/logo-images/3370d01941c5e49c.gif"
					alt="RSS Fiddle" /></a>
			</div>
			<div id="social-container">
				<a class="social24 facebook" target="_blank"
					href="http://www.facebook.com/rssfiddle">Facebook</a> <a
					class="social24 twitter" target="_blank"
					href="http://www.twitter.com/rssfiddle">Twitter</a> <a
					class="social24 google" target="_blank"
					href="http://www.facebook.com/rssfiddle">Google Plus</a>
			</div>
			<div id="search-container">
				<input id="search-text" type="text" size="20" value="Search feed" /><img
					id="search-icon"
					src="${pageContext.servletContext.contextPath}/resources/images/lens_icon.png"
					width="15" />
			</div>
		</div>
		<div id="menu-container"></div>
		<div id="feeds-container"></div>
	</div>
	
</body>
</html>
<jsp:include page="scripts.jsp"></jsp:include>