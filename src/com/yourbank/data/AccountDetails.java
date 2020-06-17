package com.yourbank.data;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AccountDetails {
	public int accountId;
	public int custId;
	public char accountType;
	public int status;
	public int message;
	public Date lastUpdated;
	public int balance;
	
	public AccountDetails(int accountId,int custId,char accountType,int status,int message,int balance) 
	{
		this.accountId = accountId;
		this.custId = custId;
		this.accountType = accountType;
		this.status = status;
		this.message = message;
		this.balance = balance;
		this.lastUpdated = Date.valueOf(LocalDate.now());
	}
	 public AccountDetails(ResultSet rs) throws NumberFormatException, SQLException
	 {
		 this.accountId = rs.getInt("accountId");
		 this.custId = rs.getInt("custId");
		 this.accountType = rs.getString("accountType").charAt(0);
		 this.status = rs.getInt("status");
		 this.message = rs.getInt("message");
		 this.balance = rs.getInt("balance");
		 this.lastUpdated = rs.getDate("lastUpdated");
	 }
	
}
