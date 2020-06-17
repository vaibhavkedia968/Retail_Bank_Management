<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.yourbank.data.CustomerConstants" import="com.yourbank.data.DBConfig" import="java.sql.*" %>
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
<h1> Customer Status</h1>
<%
try{
	Connection con;
	con=DBConfig.getDBConnection();
	String sql="select * from customer";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(sql);
	out.println("<table border='|'> ");
	out.println("<tr>");
	out.println("<td>Customer ID</td> <td>Customer SSN ID</td> <td>Status</td> <td>Message</td> <td>Last Updated</td>");
	out.println("</tr>");
	while(rs.next())
	{
		int custid=rs.getInt(2);
		int ssnid=rs.getInt(1);
		int stat=rs.getInt(3);
		String status=CustomerConstants.STATUS[stat];
		int msg=rs.getInt(4);
		String message=CustomerConstants.MESSAGE[msg];
		Date dt=rs.getDate(5);
		out.println("<tr>");
		out.println("<td>"+custid+"</td> <td>"+ssnid+"</td> <td>"+status+"</td> <td>"+message+"</td> <td>"+dt+"</td>");
		out.println("</tr>");
	}
}
catch(Exception e)
{
	out.println(e);
}
%>
</center>
</body>
</html>