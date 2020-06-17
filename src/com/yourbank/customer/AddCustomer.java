package com.yourbank.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import com.yourbank.data.DBConfig;
import com.yourbank.data.CustomerConstants;

@WebServlet(value = "/add_customer")
public class AddCustomer extends HttpServlet 
{
	public void createSuccess(HttpServletRequest req,HttpServletResponse res)
	{
		req.setAttribute("Message","Customer Created successfully");
		RequestDispatcher rd=req.getRequestDispatcher("AddCust.jsp");
		try{
		rd.include(req, res);}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		int ssn_id = Integer.parseInt(req.getParameter(CustomerConstants.SSN_ID));
		Random random=new Random();
		int id=random.nextInt(1000);
		int status=1;
		int message=1;
		String name = req.getParameter(CustomerConstants.NAME);
		int age = Integer.parseInt(req.getParameter(CustomerConstants.AGE));
		String address = req.getParameter(CustomerConstants.ADDRESS);
		String state = req.getParameter(CustomerConstants.STATE);
		String city = req.getParameter(CustomerConstants.CITY);
		boolean x=false;
		Connection con; 
		try{
			con = DBConfig.getDBConnection();
		String sql="insert into customer values('"+ssn_id+"','"+id+"','"+status+"','"+message+"',?,'"+age+"','"+address+"','"+city+"','"+state+"','"+name+"')";
		PreparedStatement st = con.prepareStatement(sql);
		st.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
		 x=st.execute();
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		if(x){
			createSuccess(req,res);
			res.getWriter().println("Customer created successfully");
		}
	 
		}
}
