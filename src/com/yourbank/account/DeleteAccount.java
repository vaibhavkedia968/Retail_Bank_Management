package com.yourbank.account;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yourbank.data.AccountConstants;
import com.yourbank.data.DBConfig;
import com.yourbank.data.ErrorMessages;
import com.yourbank.data.SuccessMessages;
import com.yourbank.data.Utilities;

@WebServlet(value = "/delete/account")
public class DeleteAccount extends HttpServlet 
{		
	int deleteAccount(Connection con,int accountId) throws SQLException
	{
		String sql = "DELETE FROM account WHERE accountId = '"+accountId+"'";
		Statement st=con.createStatement();
		int affectedRows=st.executeUpdate(sql);
		return affectedRows;
	}
	
	
	public void doDelete(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		Utilities.checkSession();
		
		int accountId = Integer.parseInt(req.getParameter(AccountConstants.ACCOUNT_ID));
		Connection con;
		
		try 
		{
			con = DBConfig.getDBConnection();
			if(!Utilities.isAccountIdValid(accountId,con))
				res.sendError(HttpServletResponse.SC_NOT_FOUND,ErrorMessages.ACCOUNT_NOT_FOUND);
			else
			{
				int affectedRows = deleteAccount(con,accountId);
				if(affectedRows==1)
				{
					res.setStatus(HttpServletResponse.SC_OK, SuccessMessages.ACCOUNT_DELETED);
				}
				else
				{
					res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,ErrorMessages.ACCOUTN_DELETION_FAILED);
				}
			}
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{			
			e.printStackTrace();
		}
		
		
	}

	

	
}
