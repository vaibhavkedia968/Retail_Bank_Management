<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.yourbank.data.EmployeeConstants" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Login </title>
</head>
<body>
<h1>Login Page</h1>
<form name="loginform" action="login" method="post">
<table>
<tr>
<td>User ID</td>
<td><input type="text" name="${EmployeeConstants.USERID}"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="${EmployeeConstants.PASSWORD}"></td>
</tr>
<tr>
<td><input type="submit" name="sub" value="Login"></td>
</tr>
</table>
</form>
</body>
</html>