<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>:: Welcome to News-Fiddle</title>
<link rel="stylesheet" href="css/main.css" type="text/css">
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script src="js/jquery/jquery-1.11.0.js"></script>
</head>
<body>
	<div id="page-container">
		<div style="width: 100%; overflow: hidden;">
			<div style="width: 900px; float: left;"><img src="images/logo-big.png" alt="News-Fiddle"/> </div>
			<div style="margin-left: 920px;"><a href="login/Logout.htm">Logout</a></div>
			
		</div>

		<div id="login-container">
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