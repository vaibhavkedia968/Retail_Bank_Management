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
<h1>Delete Customer</h1>
<form action="delete_customer" method = "post">
		ssn id : <input type = "text" name="${CustomerConstants.SSN_ID}"><br><br>
		id : <input type = "text" name="${CustomerConstants.CUST_ID}"><br><br>
		name : <input type = "text" name="${CustomerConstants.NAME}"><br><br>
		age : <input type = "text" name="${CustomerConstants.AGE}"><br><br>
		address : <input type = "text" name="${CustomerConstants.ADDRESS}"><br><br>
		<input type = "submit" name="slct" value="Delete Customer" style="margin-right:10px"> <input type="submit" name="slct" value="Cancel" >
	</form>
	</center>
</body>
</html>