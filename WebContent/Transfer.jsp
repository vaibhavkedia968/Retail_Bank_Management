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
<body>
<div class="btns" align="right">
        <form action="home.jsp">
        <input type="submit" value="Home">
        </form>
        </div>
<center>
<h1>Transfer Money</h1>
<form action="transfer" method = "post">
        Customer id : <input type = "text" name="${AccountConstants.CUST_ID}"><br><br>
		Source Account id : <input type = "text" name="${AccountConstants.SOURCE_ACCOUNT}"><br><br>
		Target Account id : <input type = "text" name="${AccountConstants.TARGET_ACCOUNT}"><br><br>
		Transfer Amount : <input type = "text" name="${AccountConstants.AMOUNT}"><br><br>
		<input type = "submit" value="Transfer">
	</form>
	</center>
</body>
</html>