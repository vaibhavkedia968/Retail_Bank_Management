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
	<form action="accountstatement" method = "get">
		<p>Account id : <input type = "text" name="${AccountConstants.ACCOUNT_ID}"></p>
		<p><input type="radio" name="${AccountConstants.STATEMENT_MODE}" value="1" onclick="inputN()"> Last N number of transactions</p>
		<p><input type="radio" name="${AccountConstants.STATEMENT_MODE}" value="2" onclick="inputDates()"> Start End dates</p>
		<p>Number of transactions: <input type="text" id="N" disabled="disabled" name="${AccountConstants.N_TRANSACTIONS}"><p>
		<p>Start date (YYYY-MM-DD): <input type="text" id="startdate" disabled="disabled" name="${AccountConstants.START_DATE}"><p>
		<p>End date (YYYY-MM-DD): <input type="text" id="enddate" disabled="disabled" name="${AccountConstants.END_DATE}"><p>
		
		<input type="submit" value="Submit">
	</form>
	
	</center>
	<script>
		function inputN(){
			var ele = document.getElementById("N");
			ele.disabled=false;
			var ele = document.getElementById("startdate");
			ele.disabled=true;
			var ele = document.getElementById("enddate");
			ele.disabled=true;
			
		}
		
		function inputDates(){
			var ele = document.getElementById("N");
			ele.disabled=true;
			var ele = document.getElementById("startdate");
			ele.disabled=false;
			var ele = document.getElementById("enddate");
			ele.disabled=false;
			
		}
	
	</script>
</body>
</html>