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


@WebServlet(value = "/edit_customer")
public class EditCustomer extends HttpServlet 
{
	boolean isValidId(int CustId,Connection con) throws SQLException 
	{
		String sql="select * from customer where id ='"+CustId+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);

		return rs.next();
		
	}
	int updateCust(Connection con,int custid,String nname,String nadd,int nage) throws SQLException
	{
		String sql = "UPDATE customer SET message = 2, name = '"+nname+"', address = '"+nadd+"',age = '"+nage+"' WHERE id = '"+custid+"'";
		Statement st=con.createStatement();
		int affectedRows=st.executeUpdate(sql);
		return affectedRows;
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		int custid = Integer.parseInt(req.getParameter(CustomerConstants.CUST_ID));
		Connection con;
		try{
			int a=0;
			con=DBConfig.getDBConnection();
			if(isValidId(custid,con))
			{
				String name = req.getParameter(CustomerConstants.N_NAME);
				int age = Integer.parseInt(req.getParameter(CustomerConstants.N_AGE));
				String address = req.getParameter(CustomerConstants.N_ADDRESS);
				a=updateCust(con,custid,name,address,age);
				
			}
			else
		    {
		    	res.getWriter().println(CustomerConstants.MESSAGE[4]);
		    }
			if(a==1)
				res.getWriter().println(CustomerConstants.MESSAGE[2]);
		}
		catch(Exception e){
			System.err.println(e);
		}
		
		
		//res.getWriter().println("Edit customer works!");
	}
}


