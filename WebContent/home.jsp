<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function preventBack(){
	window.history.forward();
}
setTimeout("preventBack()",0);
window.onunload=function(){ null};
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="btns" align="right">
        <form action="login.jsp">
        <input type="submit" value="Logout">
        </form>
        </div>
<center>
<%
   /*response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    response.setHeader("Pragma","no-cache");
    response.setHeader("Expires","0");*/
    if(session.getAttribute("LOGGEDIN_USER")==null)
    {
    	response.sendRedirect("login.jsp");
    }
%>
Welcome ${LOGGEDIN_USER}<br>
        <div class="select" style="display:inline-block"> 
            <select name="slctcus" id="slct1" onChange="location = this.value;"> 
                <option>Manage Customers</option> 
                <option value="AddCust.jsp">Add</option> 
                <option value="UpdCust.jsp">Update</option> 
                <option value="DelCust.jsp">Delete</option> 
                <option value="SearchCust.jsp">Search</option> 
                <option value="StatusCust.jsp">View Status</option> 
            </select> 
        </div> 
        <div class="select" style="display:inline-block" > 
            <select name="slctacc" id="slct2" onChange="location = this.value;"> 
                <option>Manage Account</option> 
                <option value="AddAcc.jsp">Add</option> 
                <option value="DelAcc.jsp">Delete</option> 
                <option value="SearchAcc.jsp">Search</option> 
                <option value="StatusAcc.jsp">View Status</option> 
            </select> 
        </div> 
        <div class="select" style="display:inline-block"> 
            <select name="slctopr" id="slct3" onChange="location = this.value;"> 
                <option>Account Operations</option> 
                <option value="">Deposit</option> 
                <option value="">Withdraw</option> 
                <option value="">Transfer</option> 
                <option value="">View Statements</option> 
            </select> 
        </div> 
        
        
 </center>
</body>
</html>