package com.yourbank.account;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/delete_account")
public class DeleteAccount extends HttpServlet 
{
	public void doDelete(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.getWriter().println("Delete account works!");
	}

	
}
