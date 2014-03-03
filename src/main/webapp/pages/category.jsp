<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/category.js"></script>
<script src="js/jquery/jquery-1.11.0.js"></script>

<title>Manage Category</title>
</head>
<body>
	<div>
		<form action="/category" method="post">
			<table>
				<tr>
					<td>Category Id</td>
					<td><input type="text" name="categoryId" size="5"
						maxlength="5" /></td>
				<tr>
					<td>Category Name</td>
					<td><input type="text" name="cateogryName" size="20"
						maxlength="45" /></td>
				</tr>
				<tr>
					<td colspan="2"><a href="javascript:validateCreateCategory(this.form);" class="mybtn">Create</a></td> &nbsp;
					<td colspan="2"><a href="javascript:validateModifyCategory(this.form);" class="mybtn">Modify</a></td> &nbsp;
					<td colspan="2"><a href="" class="mybtn">Delete</a></td> &nbsp;
				</tr>
			</table>
		</form>
	</div>
</body>
</html>