<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<%!
public String execute (int id,int typeofid)throws SQLException,ClassNotFoundException//0 for ssn ,1 for cust
{
	String s="default";
		Connection con;
		con=DBConfig.getDBConnection();
		String sql;
		if(typeofid==0)
			sql="select * from customer where ssnId= '"+id+"'";
		else
			sql="select * from customer where id= '"+id+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next())
			{
			   
			   s="SSN ID : \n "+rs.getInt(1)+" Customer Id: \n "+rs.getInt(2)+" Name: \n"+rs.getString(10)+" Status: \n "+CustomerConstants.STATUS[rs.getInt(3)]+" Message: \n "+CustomerConstants.MESSAGE[rs.getInt(4)]+" LastUpdated: \n"+rs.getDate(5)+" Age: \n"+rs.getInt(6)+" Address: \n"+rs.getString(7)+" City: \n"+rs.getString(8)+" State: \n"+rs.getString(9);
			}
		else
			s=CustomerConstants.MESSAGE[4];
	return s;
}
%>
<%
	
	int ssnid,custid;
	try{
		String ssn=request.getParameter(CustomerConstants.SSN_ID);
		String cust=request.getParameter(CustomerConstants.CUST_ID);
	if(ssn!=""){
		 ssnid=Integer.parseInt(ssn);
		 out.println(execute(ssnid,0));
	     }
	else if(cust!="")
	{
		custid=Integer.parseInt(cust);
		out.println(execute(custid,1));
		
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
</body>
</html>