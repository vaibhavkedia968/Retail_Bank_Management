package com.yourbank.account;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yourbank.data.AccountConstants;
import com.yourbank.data.AccountDetails;
import com.yourbank.data.DBConfig;
import com.yourbank.data.ErrorMessages;
import com.yourbank.data.SuccessMessages;
import com.yourbank.data.Utilities;

@WebServlet(value = "/add/account")
public class AddAccount extends HttpServlet {
		
	int getAccountId()
	{
		int id = 700000000 + (new Random()).nextInt(90000000) + 10000000;
		return id;
	}
	
	int addAccount(Connection con, AccountDetails ac) throws SQLException
	{
		String insert = "INSERT INTO account ";
		String values = "VALUES ('"+ac.accountId+"', '"+ac.custId+"', '"+ac.accountType+"', '"+ac.status+"', '"+ac.message+"', '"+ac.lastUpdated+"', '"+ac.balance+"');";
		String sql = insert+values;

		Statement st=con.createStatement();
		int affectedRows=st.executeUpdate(sql);
		return affectedRows;
	
	}
	//todo
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		Utilities.checkSession();
		int custId,amount,accountId;
		char accountType; //S for savings, C for current according to srs
		Connection con;
		
		custId = Integer.parseInt(req.getParameter(AccountConstants.CUST_ID));
		accountType = req.getParameter(AccountConstants.ACCOUNT_TYPE).charAt(0);
		amount = Integer.parseInt(req.getParameter(AccountConstants.AMOUNT));
		
		try 
		{
			con = DBConfig.getDBConnection();
			if(amount<0)
				res.sendError(400,ErrorMessages.INSUFFICIENT_BALANCE);
			else if(!Utilities.isCustIdValid(con,custId))
				res.sendError(404,ErrorMessages.CUSTOMER_NOT_FOUND);
			else
			{
				accountId = getAccountId();
				AccountDetails ac = new AccountDetails(accountId, custId, accountType, 1, 1, amount);
				int affectedRows = addAccount(con,ac);
				if(affectedRows==0)
				{
					res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,ErrorMessages.ACCOUNT_CREATION_FAILED);
				}
				else
				{
					res.setStatus(HttpServletResponse.SC_CREATED, SuccessMessages.ACCOUNT_CREATED);
				}
				
				
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
