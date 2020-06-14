package com.yourbank.customer;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/delete_customer")
public class DeleteCustomer extends HttpServlet 
{
	public void doDelete(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.getWriter().println("Delete customer works!");
	}

}
