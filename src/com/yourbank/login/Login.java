package com.yourbank.login;

import java.io.IOException;

import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yourbank.data.Constants;
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
				//String timestamp = rs.getString(3);
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
		String user = req.getParameter(Constants.USERID);
		String password = req.getParameter(Constants.PASSWORD);
		if(validateUserID(user,getDataFromDB(user))){
			if(checkPassword(password,getDataFromDB(user))){
				HttpSession session=req.getSession();  
		        session.setAttribute(Constants.LOGGEDIN_USER,user);
		        session.setMaxInactiveInterval(60);
				loginSuccess(req,res);
				
			}
			else
				res.getWriter().println(ErrorMessages.INCORRECT_PASSWORD);}
		else
			res.getWriter().println(ErrorMessages.USER_NOT_FOUND);
			
			
		/*try{
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
	}*/
	//res.getWriter().println("Login works!");}
		//search for userid in database
		//if not found, display userid not found error msg
		//if found, compare password.
		//if password is incorrect, display incorrect password msg
		//if correct, log in the user succesfully and create a session for the user
	}
}
