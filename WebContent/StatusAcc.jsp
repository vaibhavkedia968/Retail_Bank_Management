<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.yourbank.data.AccountConstants" import="com.yourbank.data.DBConfig" import="java.sql.*" %>
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
<h1> Account Status</h1>
<%
try{
	Connection con;
	con=DBConfig.getDBConnection();
	String sql="select * from account";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(sql);
	out.println("<table border='|'> ");
	out.println("<tr>");
	out.println("<td>Customer ID</td> <td>Account ID</td> <td>Account Type</td> <td>Account Status</td> <td>Message</td> <td>Last Updated</td >");
	out.println("</tr>");
	while(rs.next())
	{
		int custid=rs.getInt(2);
		int accid=rs.getInt(1);
		String acctype=rs.getString(3);
		int stat=rs.getInt(4);
		String status=AccountConstants.STATUS[stat];
		int msg=rs.getInt(5);
		String message=AccountConstants.MESSAGE[msg];
		Date dt=rs.getDate(6);
		out.println("<tr>");
		out.println("<td>"+custid+"</td> <td>"+accid+"</td> <td>"+acctype+"</td> <td>"+status+"</td> <td>"+message+"</td> <td>"+dt+"</td>");
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