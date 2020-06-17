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
<h1>Create Account</h1>
<form action="add/account" method = "post">
		Customer id : <input type = "text" name="${AccountConstants.CUST_ID}"><br><br>
		Account Type: <input type = "text" name="${AccountConstants.ACCOUNT_TYPE}"><br><br>
		Deposit Amount: <input type = "text" name="${AccountConstants.AMOUNT}"><br><br>
		<input type = "submit" value="Submit">
	</form>
	</center>
</body>
</html>