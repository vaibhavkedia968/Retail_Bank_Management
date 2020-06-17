package com.yourbank.account;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.yourbank.data.AccountConstants;
import com.yourbank.data.AccountDetails;
import com.yourbank.data.DBConfig;
import com.yourbank.data.ErrorMessages;

@WebServlet(value="/status/account")
public class ViewAccountStatus extends HttpServlet 
{
	AccountDetails getAccountDetails(Connection con, int accountId) throws SQLException
	{
		String sql="select * from account where accountId ='"+accountId+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		AccountDetails acc;
		if(rs.next())
		{
			acc = new AccountDetails(rs);
		}
		else
		{
			acc = null;
		}
		return acc;
	}
	
	List<Integer> getAccountList(Connection con, int custId) throws SQLException 
	{
		List<Integer> accountsList = new ArrayList<Integer>();
		String sql="select accountId from account where custId ='"+custId+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) 
		{
			accountsList.add(rs.getInt(1));
		}
		
		return accountsList;
		
	}
	
	boolean isValidCustId(Connection con, int custId) throws SQLException 
	{
		String sql="select * from customer where id ='"+custId+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		return rs.next();
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		String custId = req.getParameter(AccountConstants.CUST_ID);
		String accountId = req.getParameter(AccountConstants.ACCOUNT_ID);
		Connection con;
		AccountDetails acc;
		
		if(custId == null && accountId != null)
		{
			try 
			{
				con = DBConfig.getDBConnection();
				acc = getAccountDetails(con,Integer.parseInt(accountId));
				if(acc==null)
					res.sendError(HttpServletResponse.SC_NOT_FOUND, ErrorMessages.ACCOUNT_NOT_FOUND);
				else
				{
					/*
					req.setAttribute(AccountConstants.ACCOUNT_OBJECT, acc);
					RequestDispatcher rd = req.getRequestDispatcher("AccountStatus.jsp");
					rd.forward(req, res);
					*/
					res.getWriter().println(acc);
				}
			} 
			catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		}
		else if (custId != null && accountId == null)
		{
			try 
			{
				List<Integer> accountList;
				con = DBConfig.getDBConnection();
				if(!isValidCustId(con,Integer.parseInt(custId)))
					res.sendError(HttpServletResponse.SC_NOT_FOUND, ErrorMessages.CUSTOMER_NOT_FOUND);
				else
				{
					accountList = getAccountList(con,Integer.parseInt(custId));
					/*
					req.setAttribute(AccountConstants.ACCOUNT_LIST, accountList);
					RequestDispatcher rd = req.getRequestDispatcher("AccountStatus.jsp");
					rd.forward(req, res);
					*/
					res.getWriter().print(accountList);
				}
			} 
			catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
		
		
	}


	
}
