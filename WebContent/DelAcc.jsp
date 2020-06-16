<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.yourbank.data.AccountConstants" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Delete Account</h1>
<form action="delete_account" method = "post">
Account Id : <select name="${AccountConstants.CUST_ID}">
<option value="">Select ID</option>
</select><br><br>
Account type :<input type = "text" name="${AccountConstants.ACCOUNT_TYPE}"><br><br> 
<input type = "submit" value="Delete">
	</form>
	</center>
</body>
</html>