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
import com.yourbank.data.AccountDetails;
import com.yourbank.data.DBConfig;
import com.yourbank.data.ErrorMessages;
import com.yourbank.data.Utilities;

@WebServlet(value="/deposit")
public class Desposit extends HttpServlet {
	
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		int accountId = Integer.parseInt(req.getParameter(AccountConstants.ACCOUNT_ID));
		int deposit = Integer.parseInt(req.getParameter(AccountConstants.DEPOSIT));

		Connection con;
		
		try 
		{
			con = DBConfig.getDBConnection();
			AccountDetails acc = Utilities.getAccountDetails(con, accountId);
			if(acc==null)
				res.sendError(404, ErrorMessages.ACCOUNT_NOT_FOUND);
			else
			{
				acc.balance+=deposit;
				int affectedRows = Utilities.updateAccountDetails(con, acc);
				if(affectedRows==0)
					res.sendError(500, ErrorMessages.DEPOSIT_FAILED);
				else
				{
					req.setAttribute(AccountConstants.ACCOUNT_OBJECT, acc);
					res.getWriter().println("Deposited");
				}
				
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}

}
