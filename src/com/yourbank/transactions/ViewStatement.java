package com.yourbank.transactions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import com.yourbank.data.AccountConstants;
import com.yourbank.data.DBConfig;
import com.yourbank.data.ErrorMessages;
import com.yourbank.data.TransactionDetails;
import com.yourbank.data.Utilities;


@WebServlet(value="/account/statement")
public class ViewStatement extends HttpServlet {
	
	List<TransactionDetails> executeQuery(Connection con,String sql) throws SQLException
	{
		List<TransactionDetails> TransactionList = new ArrayList<TransactionDetails>();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			TransactionList.add(new TransactionDetails(rs));
		}
		
		return TransactionList;
	}
	
	
	List<TransactionDetails> getLastNTransactions(Connection con,int n,int accountId) throws SQLException
	{
		
		String sql = "SELECT * FROM transactions"
					+" WHERE accountId = "+accountId
					+" ORDER BY timestamp DESC"
					+" LIMIT "+n;
		List<TransactionDetails> TransactionList = executeQuery(con, sql);
		return TransactionList;
	}
	
	List<TransactionDetails> getTransactionsDateWise(Connection con, Date start, Date end, int accountId) throws SQLException
	{
		String sql = "SELECT * FROM transactions"
				+" WHERE accountId = "+accountId+" and timestamp BETWEEN '"+start+"' AND '"+end+"'"
				+" ORDER BY timestamp DESC";
		
		List<TransactionDetails> TransactionList = executeQuery(con, sql);
		return TransactionList;
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		int accountId = Integer.parseInt(req.getParameter(AccountConstants.ACCOUNT_ID));
		int mode = Integer.parseInt(req.getParameter(AccountConstants.STATEMENT_MODE));
		//mode=1 for last num of transactions
		//mode=2 for date wise transactions
		
		Connection con;
		List<TransactionDetails> TransactionList = new ArrayList<TransactionDetails>();
		try {
			con = DBConfig.getDBConnection();
			if(!Utilities.isAccountIdValid(con, accountId))
			{
				res.sendError(404,ErrorMessages.ACCOUNT_NOT_FOUND);
			}
			if(mode==1)
			{
				int n = Integer.parseInt(req.getParameter(AccountConstants.N_TRANSACTIONS));
				TransactionList = getLastNTransactions(con,n,accountId);
			}
			else if(mode==2)
			{
				Date start = Date.valueOf(req.getParameter(AccountConstants.START_DATE));
				Date end = Date.valueOf(req.getParameter(AccountConstants.END_DATE));
				
				TransactionList = getTransactionsDateWise(con,start,end,accountId);	
			}
			req.setAttribute(AccountConstants.TRANSACTION_STATEMENT, TransactionList);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
