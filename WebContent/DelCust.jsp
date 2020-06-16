<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Delete Customer</h1>
<form action="delete_customer" method = "post">
		ssn id : <input type = "text" name="ssn id"><br><br>
		id : <input type = "text" name="id"><br><br>
		name : <input type = "text" name="name"><br><br>
		age : <input type = "text" name="age"><br><br>
		address : <input type = "text" name="oldaddress"><br><br>
		<input type = "submit" value="Delete Customer" style="margin-right:10px"> <input type="submit" value="Cancel">
	</form>
	</center>
</body>
</html>