package com.yourbank.transactions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Random;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yourbank.data.AccountConstants;
import com.yourbank.data.AccountDetails;
import com.yourbank.data.DBConfig;
import com.yourbank.data.ErrorMessages;
import com.yourbank.data.TransactionDetails;
import com.yourbank.data.Utilities;

@WebServlet(value="/withdraw")
public class Withdraw extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		int accountId = Integer.parseInt(req.getParameter(AccountConstants.ACCOUNT_ID));
		int withdraw = Integer.parseInt(req.getParameter(AccountConstants.AMOUNT));

		Connection con;
		
		try 
		{
			con = DBConfig.getDBConnection();
			AccountDetails acc = Utilities.getAccountDetails(con, accountId);
			if(acc==null)
				res.sendError(404, ErrorMessages.ACCOUNT_NOT_FOUND);
			else
			{
				acc.balance-=withdraw;
				if(acc.balance<0)
				{
					res.sendError(400,ErrorMessages.INSUFFICIENT_BALANCE);
					return;
				}
				long transactionId = Utilities.getTransactionId();
				TransactionDetails trans = new TransactionDetails(transactionId, accountId,  withdraw,0, Timestamp.valueOf(LocalDateTime.now()), AccountConstants.WITHDRAW);
				con.setAutoCommit(false);
				int affectedRowsAccount = Utilities.updateAccountDetails(con, acc);
				int affectedRowsTransaction = Utilities.addTransaction(con, trans);
				if(affectedRowsAccount == 1 && affectedRowsTransaction == 1)
				{
					con.commit();
					req.setAttribute(AccountConstants.ACCOUNT_OBJECT, acc);
					res.getWriter().println("Withdraw complete");
				}
				else
				{
					con.rollback();
					res.sendError(500, ErrorMessages.WITHDRAW_FAILED);
				}
				
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}


}
