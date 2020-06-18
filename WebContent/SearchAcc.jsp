<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.yourbank.data.AccountConstants" %>
    <%@ page import="com.yourbank.data.CustomerConstants" %>
    <%@page import="java.sql.*" %>
    <%@page import="com.yourbank.data.DBConfig" %>
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
<h1>Account Details</h1>
<%!
public ResultSet execute (int id,int typeofid)throws SQLException,ClassNotFoundException//0 for ssn ,1 for cust
{
	String s="default";
		Connection con;
		con=DBConfig.getDBConnection();
		String sql;
		if(typeofid==0)
			sql="select * from account where accountId = '"+id+"'";
		else
			sql="select * from account where custId = '"+id+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
	return rs;
}
%>
<%
	
	int accid,custid;
	try{
		String acc=request.getParameter(AccountConstants.ACCOUNT_ID);
		String cust=request.getParameter(AccountConstants.CUST_ID);
	if(acc!=""){
		 accid=Integer.parseInt(acc);
		 ResultSet rs=execute(accid,0);
		 if(rs==null)
			 out.println(CustomerConstants.MESSAGE[4]);
		 out.println("<table border='|'> ");
			out.println("<tr>");
			out.println("<td>Account ID</td> <td>Customer ID</td> <td>Account Type</td> <td>Account Status</td> <td>Message</td> <td>Last Updated</td > <td>Balance</td>");
			out.println("</tr>");
		 while(rs.next())
			{
			   out.println("<tr>");
			   out.println("<td>"+rs.getInt(1)+"</td> <td>"+rs.getInt(2)+"</td> <td>"+rs.getString(3)+"</td> <td> "+AccountConstants.STATUS[rs.getInt(4)]+"</td> <td> "+AccountConstants.MESSAGE[rs.getInt(5)]+"</td> <td> "+rs.getDate(6)+"</td> <td>"+rs.getInt(7)+"</td>");
			   out.println("</tr>");
			}
	     }
	else if(cust!="")
	{
		custid=Integer.parseInt(cust);
		ResultSet rs=execute(custid,1);
		 if(rs==null)
			 out.println(CustomerConstants.MESSAGE[4]);
		 out.println("<table border='|'> ");
			out.println("<tr>");
			out.println("<td>Account ID</td> <td>Customer ID</td> <td>Account Type</td> <td>Account Status</td> <td>Message</td> <td>Last Updated</td > <td>Balance</td>");
			out.println("</tr>");
		 while(rs.next())
			{
			   out.println("<tr>");
			   out.println("<td>"+rs.getInt(1)+"</td> <td>"+rs.getInt(2)+"</td> <td>"+rs.getString(3)+"</td> <td> "+AccountConstants.STATUS[rs.getInt(4)]+"</td> <td> "+AccountConstants.MESSAGE[rs.getInt(5)]+"</td> <td> "+rs.getDate(6)+"</td> <td>"+rs.getInt(7)+"</td>");
			   out.println("</tr>");
			}
			
		
	}
	else
	{
		out.println("Both fields cannot be empty!");
		
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