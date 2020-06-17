package com.yourbank.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class Utilities {

	public static boolean isCustIdValid(Connection con, int custId) throws SQLException
	{
		String sql="select * from customer where id ='"+custId+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);

		return rs.next();
	}
	
	public static boolean isAccountIdValid(int accountId,Connection con) throws SQLException 
	{
		String sql="select * from account where accountId ='"+accountId+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);

		return rs.next();
		
	}
	
	public static void checkSession() 
	{
		
	}
	
	
}
