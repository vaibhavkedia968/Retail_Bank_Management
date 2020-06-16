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
<h1>Update Customer Details</h1>
<form action="edit_customer" method = "post">
		ssn id : <input type = "text" name="ssn id"><br><br>
		id : <input type = "text" name="id"><br><br>
		old name : <input type = "text" name="oldname"><br><br>
		new name : <input type = "text" name="newname"><br><br>
		old address : <input type = "text" name="oldaddress"><br><br>
		new address : <input type = "text" name="newaddress"><br><br>
		old age : <input type = "text" name="age"><br><br>
		new age : <input type = "text" name="newage"><br><br>
		<input type = "submit" value="Update">
	</form>
	</center>
</body>
</html>