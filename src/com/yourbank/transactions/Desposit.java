package com.yourbank.transactions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yourbank.data.AccountConstants;
import com.yourbank.data.DBConfig;

@WebServlet(value="/deposit")
public class Desposit extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	{
		int custId = Integer.parseInt(req.getParameter(AccountConstants.CUST_ID));
		int accountId = Integer.parseInt(req.getParameter(AccountConstants.ACCOUNT_ID));
		Connection con;
		
		try 
		{
			con = DBConfig.getDBConnection();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}

}
