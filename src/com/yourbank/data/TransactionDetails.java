package com.yourbank.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TransactionDetails {
	
	public long transactionId;
	public int accountId;
	public int debit;
	public int credit;
	public Timestamp timestamp;
	public String description;
	
	public TransactionDetails(long transactionId, int accountId, int debit, int credit, Timestamp timestamp, String description) 
	{
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.debit = debit;
		this.credit = credit;
		this.timestamp = timestamp;
		this.description = description;
	}

	public TransactionDetails(ResultSet rs) throws SQLException 
	{
		this.transactionId = rs.getLong("transactionId");
		this.accountId = rs.getInt("accountId");
		this.debit = rs.getInt("debit");
		this.credit = rs.getInt("credit");
		this.timestamp = rs.getTimestamp("timestamp");
		this.description = rs.getString("description");
	}
}
