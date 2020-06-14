package com.yourbank.login;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yourbank.constants.Utilities;

@WebServlet(value = "/login")
public class Login extends HttpServlet {

	public void doPost(HttpServletRequest req,HttpServletResponse res)
	{
		String userId = req.getParameter(Utilities.USERID);
		String password = req.getParameter(Utilities.PASSWORD);
		
		//search for userid in database
		//if not found, display userid not found error msg
		//if found, compare password.
		//if password is incorrect, display incorrect password msg
		//if correct, log in the user succesfully and create a session for the user
	}
}
