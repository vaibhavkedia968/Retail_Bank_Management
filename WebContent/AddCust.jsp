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
<center>
<h1>Create Customer</h1>
<form action="add_customer" method = "post">
		<label style=display:inline-block>ssn id :</label> <input type = "text" name="${CustomerConstants.SSN_ID}" style="margin: 10px 5px;display:inline-block"></br>
		<label style=display:inline-block>name :</label> <input type = "text" name="${CustomerConstants.NAME}" style="margin: 10px 5px;display:inline-block"></br>
		<label style=display:inline-block>age :</label> <input type = "text" name="${CustomerConstants.AGE}" style="margin: 10px 5px;display:inline-block"></br>
		<label style=display:inline-block>address : <input type = "text" name="${CustomerConstants.ADDRESS}" style="margin: 10px 5px;display:inline-block"></br>
		<label style=display:inline-block>state :    </label> <select name="${CustomerConstants.STATE}"style="margin: 10px 5px;display:inline-block">
		<option>State</option>
		<option>West Bengal</option>
		<option>Goa</option>
		</select></br>
		<label style=display:inline-block>city :</label> <input type = "text" name="${CustomerConstants.CITY}" style="margin: 10px 5px;display:inline-block"></br>
		<input type = "submit" value="Submit" >
	</form>
	</center>
</body>
</html>