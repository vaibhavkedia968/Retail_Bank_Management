package com.yourbank.login;

import java.io.IOException;

import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yourbank.data.Utilities;
import com.yourbank.data.LoginCredentials;

//@WebServlet(value = "/login")
public class Login extends HttpServlet {
	LoginCredentials getDataFromDB(String userId)
	{
		//Establish database connection
		//Fetch the row corresponding to userId
		//Create a LoginCredentials object
		//If row found, then store the userId, password, timestamp into that LoginCredentials object
		//If not found, then initialize it as null
		//Return this object
		
		//Returning a sample LoginCredentials object for now
		LoginCredentials logCred = new LoginCredentials("admin","admin12345","");
		return logCred;
		
	}
	
	boolean checkPassword(String password, LoginCredentials logCred)
	{
		if(password.compareTo(logCred.password) == 0)
			return true;
		else
			return false;
	}

	void loginSuccess()
	{
		//Perform this operation for successful login
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{ try{
		String userId = req.getParameter("na");
		String password = req.getParameter("psw");
		//System.out.println("Reached here");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
		String sql="select * from employee where UserId = ' "+userId+" '";
		//String sql="insert into employee values("+userId+",' "+password+" ')";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		int flag=0;
		
		while(rs.next())
		{
			flag++;
		}
		if(flag==0)
			res.getWriter().println("Invalid username");
		else{
			sql="select * from Employee where Password= ' "+password+" '";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				flag++;
			}
			if(flag<2)
				res.getWriter().println("Invalid Password");
			else{
				res.getWriter().println("Logged in");//res.sendRidirect("loginsuccess.jsp");
			}
		}
		
	}catch(Exception e)
	{
		System.err.println(e);
	}
	//res.getWriter().println("Login works!");}
		//search for userid in database
		//if not found, display userid not found error msg
		//if found, compare password.
		//if password is incorrect, display incorrect password msg
		//if correct, log in the user succesfully and create a session for the user
	}
}
