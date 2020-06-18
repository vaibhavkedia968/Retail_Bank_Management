<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.yourbank.data.AccountConstants" %>
    <%@ page import="com.yourbank.data.TransactionDetails" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<TransactionDetails> l=(List<TransactionDetails>)request.getAttribute(AccountConstants.TRANSACTION_STATEMENT);
out.println("<table border='|'> ");
out.println("<tr>");
out.println("<td>Details</td>");
out.println("</tr>");
int s=l.size();
int i=0;
while(i<s)
{
	out.println("<tr>");
	out.println("<td>"+l.get(i)+"</td>");
	out.println("</tr>");
	i++;
}
%>
</body>
</html>