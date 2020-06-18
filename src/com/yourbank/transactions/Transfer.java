package com.yourbank.transactions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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

@WebServlet(value="/transfer")
public class Transfer extends HttpServlet {
	
	boolean executeTransactions(Connection con,AccountDetails acc, TransactionDetails trans) throws SQLException
	{
		int affectedRowsAccount = Utilities.updateAccountDetails(con, acc);
		int affectedRowsTransaction = Utilities.addTransaction(con, trans);
		if(affectedRowsAccount==1 && affectedRowsTransaction==1)
			return true;
		else
			return false;
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		int sourceId = Integer.parseInt(req.getParameter(AccountConstants.SOURCE_ACCOUNT));
		int targetId = Integer.parseInt(req.getParameter(AccountConstants.TARGET_ACCOUNT));
		int amount = Integer.parseInt(req.getParameter(AccountConstants.AMOUNT));
		
		Connection con;
		AccountDetails source,target;
		
		try
		{
			con = DBConfig.getDBConnection();
			source = Utilities.getAccountDetails(con, sourceId);
			target = Utilities.getAccountDetails(con, targetId);
			if(source==null)
			{
				res.sendError(404, "source acc not found");
				return;
			}
			if(target==null)
			{
				res.sendError(404, "target acc not found");
				return;
			}
			if(amount>source.balance)
			{
				res.sendError(400, ErrorMessages.INSUFFICIENT_BALANCE);
				return;
			}
			source.balance-=amount;
			target.balance+=amount;
			
			long transactionIdSource = Utilities.getTransactionId();
			long transactionIdTarget = Utilities.getTransactionId();
			
			TransactionDetails transSource = new TransactionDetails(transactionIdSource, sourceId, amount, 0, Timestamp.valueOf(LocalDateTime.now()), AccountConstants.TRANSFER_TO+targetId);
			TransactionDetails transtarget = new TransactionDetails(transactionIdTarget, targetId, 0, amount, Timestamp.valueOf(LocalDateTime.now()), AccountConstants.TRANSFER_FROM+sourceId);
			
			con.setAutoCommit(false);
			boolean sourceFlag = executeTransactions(con, source, transSource);
			boolean targetFlag = executeTransactions(con, target, transtarget);
			
			if(sourceFlag && targetFlag)
			{
				con.commit();
				req.setAttribute(AccountConstants.SOURCE_OBJECT, source);
				req.setAttribute(AccountConstants.TARGET_OBJECT, target);
				res.getWriter().println("Transfered");
			}
			else
			{
				con.rollback();
				res.sendError(500, ErrorMessages.TRANSFER_FAILED);
			}		
		
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}	
	}
	
}
