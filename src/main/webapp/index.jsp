<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>:: Welcome to News-Fiddle</title>
<script type="text/javascript" src="./js/login.js"></script>

</head>
<body>
	<div>News-Fiddle</div>
	<div>
		<form action ="login.do" onsubmit="validate(this)" method="post">
		<table>
			<tr>
				<td>Enter your Username</td>
				<td><input type="text" name="username" size="20" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" size="20"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value ="Login"/></td>
			</tr>		
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td colspan="2"> New User? <a href="signup.html">signup here</a></td></tr>	
		</table>
		</form>
	</div>
</body>
</html>