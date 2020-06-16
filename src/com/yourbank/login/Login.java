package com.yourbank.login;

import java.io.IOException;

import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yourbank.data.EmployeeConstants;
import com.yourbank.data.ErrorMessages;
import com.yourbank.data.DBConfig;
import com.yourbank.data.LoginCredentials;

@WebServlet(value = "/login")
public class Login extends HttpServlet {
	LoginCredentials getDataFromDB(String userId)
	{
		//Establish database connection
		LoginCredentials logCred=null;
		try{
			Class.forName(DBConfig.CLASS_NAME);
			Connection con=DriverManager.getConnection(DBConfig.URL,DBConfig.USER,DBConfig.PASSWORD);
			//Fetch the row corresponding to userId
			String sql="select * from employee where UserId ='"+userId+"'";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			if(rs.next())
			{
				String userid=rs.getString(1);
				String password=rs.getString(2);
				logCred=new LoginCredentials(userid,password,"");
			}
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		return logCred;
		
	}
	
	boolean checkPassword(String password, LoginCredentials logCred)
	{
		if(password.compareTo(logCred.password) == 0)
			return true;
		else
			return false;
	}
    boolean validateUserID(String userId,LoginCredentials logCred)
    {
    	if(logCred==null)
    		return false;
    	else
    		return true;
    }
	void loginSuccess(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		//Perform this operation for successful login
		//res.getWriter().println("SUCCESSFUL");
		
		res.sendRedirect("home.jsp");
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{ 
		String user = req.getParameter(EmployeeConstants.USERID);
		String password = req.getParameter(EmployeeConstants.PASSWORD);
		if(validateUserID(user,getDataFromDB(user))){
			if(checkPassword(password,getDataFromDB(user))){
				HttpSession session=req.getSession();  
		        session.setAttribute("LOGGEDIN_USER",user);
		        session.setMaxInactiveInterval(60);
				loginSuccess(req,res);
				
			}
			else
			//instead of printing it on a different page, we need to display it beside the password input field
				res.getWriter().println(ErrorMessages.INCORRECT_PASSWORD);}
		else
			//instead of printing it on a different page, we need to display it beside the userid input field	
			res.getWriter().println(ErrorMessages.USER_NOT_FOUND);
	}
}
