package com.yourbank.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public final class Utilities {

	public static boolean isCustIdValid(Connection con, int custId) throws SQLException
	{
		String sql="select * from customer where id ='"+custId+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);

		return rs.next();
	}
	
	public static boolean isAccountIdValid(Connection con, int accountId) throws SQLException 
	{
		String sql="select * from account where accountId ='"+accountId+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);

		return rs.next();
		
	}
	
	public static AccountDetails getAccountDetails(Connection con, int accountId) throws SQLException
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
	
	public static int updateAccountDetails(Connection con, AccountDetails acc) throws SQLException
	{
		String sql = "UPDATE account "
				+ "SET status="+acc.status+", message="+acc.message+", balance="+acc.balance//+", lastUpdated="+Date.valueOf(LocalDate.now())
				+" WHERE accountId="+acc.accountId;
		Statement st=con.createStatement();
		int affectedRows=st.executeUpdate(sql);
		
		return affectedRows;
		
	}
	public static int addTransaction(Connection con, TransactionDetails trans) throws SQLException
	{
		String sql = "INSERT INTO transactions "
				+ "VALUES ('"+trans.transactionId+"', '"+trans.accountId+"', '"+trans.debit+"', '"+trans.credit+"', '"+trans.timestamp+"','"+trans.description+"');";

		Statement st=con.createStatement();
		int affectedRows=st.executeUpdate(sql);
		return affectedRows;
	
	}
	
	public static long getTransactionId()
	{
		long x =(long)Math.pow(10, 15);
		long id = Math.abs((new Random()).nextLong()*9*x + x);
		return id;
	}
	
	public static void checkSession() 
	{
		
	}
	
	
}
