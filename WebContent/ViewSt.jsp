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
<div class="btns" align="right">
        <form action="home.jsp">
        <input type="submit" value="Home">
        </form>
        </div>
<center>
<h1>Account Statement</h1>
<form action="deposit" method = "post">
		Account id : <input type = "text" name="${AccountConstants.ACCOUNT_ID}"><br><br>
		<input type="radio" value="Last number of transactions" name="lastNoOfTr">Last Number of Transactions<br><br>
		<input type="radio" value="start end dates" name="StartEnd">Start-End Dates<br><br>
		Number of transactions: <select name="noOfTr">
		<option>2</option>
		<option>4</option>
		<option>8</option>
		</select><br><br>
		<input type = "submit" value="Submit">
</center>
</body>
</html>