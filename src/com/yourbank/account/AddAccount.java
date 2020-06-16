package com.yourbank.account;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yourbank.data.Constants;

@WebServlet(value = "/add/account")
public class AddAccount extends HttpServlet {
	
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		int custId;
		char accountType; //S for savings, C for current according to srs
		int amount;
		
		custId = Integer.parseInt(req.getParameter(Constants.CUST_ID));
		accountType = Integer.parseInt(req.getParameter(Constants.ACCOUNT_TYPE));
		amount = Integer.parseInt(req.getParameter(Constants.AMOUNT));
		
		
		
		
		
	}

}
