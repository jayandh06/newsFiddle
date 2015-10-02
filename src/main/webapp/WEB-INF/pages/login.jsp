<%@ page import="com.company.rssfiddle.util.RSSFiddleConstants" %>
<script>var GLOBAL_HAS_USERSESSION = <%= session.getAttribute(RSSFiddleConstants.SESSION_USER_ID) != null %></script>
<div id="login-container" style="display:none">
	<div id="form-container" class="tableContainerLayout">
		<div id="login-message-container" class="messageText"></div>
		<div id="login-left-container">
			<form name="loginForm" method="post">
				<table>
					<tr>
						<td class="labelText">Username</td>
					</tr>
					<tr>
						<td><input type="text" name="loginUsername" size="20" /><span
							id="loginUsernameInfo" class="formInfoMessage"></span></td>
					</tr>
					<tr>
						<td class="labelText">Password</td>
					</tr>
					<tr>	
						<td><input type="password" name="password" size="20" /><span
							id="passwordInfo" class="formInfoMessage"></span></td>
					</tr>
					<tr>
						<td colspan="2"><a id="login-submit-button" href="javascript:loginObj.validateLogin();">Login</a>
							<a id="login-clear-button" href="javascript:loginObj.clearLogin();">Clear</a>
						</td>
					</tr>
					<tr>
						<td colspan="2"><span>New to RSS Fiddle? &nbsp;</span><a id="login-signup-button"
							href="javascript:signupObj.showSignup();"
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