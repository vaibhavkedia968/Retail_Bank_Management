<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.yourbank.data.CustomerConstants" %>
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
<h1>Search Customer Details</h1>
<form action="search_customer" method = "post">
		Enter ssn id : <input type = "text" name="${CustomerConstants.SSN_ID}"><br><br>
		<label style="align:center">Or</label><br><br>
		Enter Customer id : <input type = "text" name="${CustomerConstants.CUST_ID}"><br><br>
		<input type = "submit" value="Search" >
</form>
</center>
</body>
</html>