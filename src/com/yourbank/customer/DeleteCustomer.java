package com.yourbank.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yourbank.data.CustomerConstants;
import com.yourbank.data.DBConfig;

@WebServlet(value = "/delete_customer")
public class DeleteCustomer extends HttpServlet 
{
	boolean isValidId(int CustId,Connection con) throws SQLException 
	{
		String sql="select * from customer where id ='"+CustId+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);

		return rs.next();
		
	}
	int deleteCust(Connection con,int custid) throws SQLException
	{
		String sql = "DELETE FROM customer WHERE id = '"+custid+"'";
		Statement st=con.createStatement();
		int affectedRows=st.executeUpdate(sql);
		return affectedRows;
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		String v=req.getParameter("slct");
		if(v.equals("Cancel"))
		res.sendRedirect("home.jsp");
		else{
			int custid = Integer.parseInt(req.getParameter(CustomerConstants.CUST_ID));
		Connection con;
		try 
		{
			con = DBConfig.getDBConnection();
			int s=0;
		    if(isValidId(custid,con))
		    	s=deleteCust(con,custid);
		    else
		    {
		    	res.getWriter().println(CustomerConstants.MESSAGE[4]);
		    }
		    if(s==1)
		    	res.getWriter().println(CustomerConstants.MESSAGE[3]);
		}	
		catch(Exception e)
		{
			System.err.println(e);
		}
		}	
	}

}
