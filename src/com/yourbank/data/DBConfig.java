package com.yourbank.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConfig {
	public static String CLASS_NAME = "com.mysql.jdbc.Driver";
	public static String URL = "jdbc:mysql://localhost:3306/bank?useTimezone=true&serverTimezone=UTC";
	public static String USER = "root";
	public static String PASSWORD = "";
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName(CLASS_NAME);
		Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
		return con;
	}

}
