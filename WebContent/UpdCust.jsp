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
<h1>Update Customer Details</h1>
<form action="edit_customer" method = "post">
		ssn id : <input type = "text" name="${CustomerConstants.SSN_ID}"><br><br>
		id : <input type = "text" name="${CustomerConstants.CUST_ID}"><br><br>
		old name : <input type = "text" name="${CustomerConstants.NAME}"><br><br>
		new name : <input type = "text" name="${CustomerConstants.N_NAME}"><br><br>
		old address : <input type = "text" name="${CustomerConstants.ADDRESS}"><br><br>
		new address : <input type = "text" name="${CustomerConstants.N_ADDRESS}"><br><br>
		old age : <input type = "text" name="${CustomerConstants.AGE}"><br><br>
		new age : <input type = "text" name="${CustomerConstants.N_AGE}"><br><br>
		<input type = "submit" value="Update">
	</form>
	</center>
</body>
</html>