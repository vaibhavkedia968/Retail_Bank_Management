package com.yourbank.search;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/search_customer")
public class SearchCustomer extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.getWriter().println("Search customer works!");
	}
}
