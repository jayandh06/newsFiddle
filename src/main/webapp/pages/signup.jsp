<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>:: Welcome to News-Fiddle</title>
<link rel="stylesheet" href="../css/main.css" type="text/css">
<script type="text/javascript" src="../js/login.js"></script>
<script src="../js/jquery/jquery-1.11.0.js"></script>
</head>
<body>
	<div id="page-container">
		<div style="width: 100%; overflow: hidden;">
			<div style="width: 900px; float: left;">
				<img src="../images/logo-big.png" alt="News-Fiddle" />
			</div>
			<div style="margin-left: 920px;">
				<a href="login/Logout.htm">Logout</a>
			</div>
		</div>
		
		<form action="/signup" method="post" onsubmit="validate(this)">
			<div id="signup-container">
				<div>New User Signup</div>
				<table>
					<tr>
						<td class="labelText">Username</td>
						<td><input type="text" name="username" size="20" /></td>
					</tr>
					<tr>
						<td class="labelText">Password</td>
						<td><input type="password" name="password1" size="20" /></td>
					</tr>
					<tr>
						<td class="labelText">Retype Password</td>
						<td><input type="password" name="password2" size="20" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Signup" /></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2"><font class="labelText">New User? </font><a href="signup.html">signup
								here</a></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>