<div id="signup-container" style="display:none">
<div id="signup-message-container" class="messageText"></div>
<form name="signupForm" method="post">
<div id="form-container" class="tableContainerLayout">		
		<table>
			<tr>
				<td class="labelText">Username</td>
				<td><input type="text" name="signupUsername" size="20" /><span id="signupUsernameInfo" class="formInfoMessage">Valid username, Atleast 6 chars.</span></td>
			</tr>
			<tr>
				<td class="labelText">Password</td>
				<td><input type="password" name="password1" size="20" /><span id="password1Info" class="formInfoMessage">Valid Password, Atleast 8 chars.</span></td>
			</tr>
			<tr>
				<td class="labelText">Confirm Password</td>
				<td><input type="password" name="password2" size="20" /><span id="password2Info" class="formInfoMessage">Re-type password</span></td>
			</tr>
			
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2"><a id="signup-submit-button" href="javascript:signupObj.validateSignup();" class="anchorButton">Signup here</a><a id="signup-clear-button" href="javascript:signupObj.clearSignup();" class="anchorButton">Clear</a></td>
			</tr>
		</table>
	</div>
</form>
</div>