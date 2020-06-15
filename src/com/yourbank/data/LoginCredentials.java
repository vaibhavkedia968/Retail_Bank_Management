package com.yourbank.data;

public class LoginCredentials {
	public String userId;
	public String password;
	public String timestamp;
	
	public LoginCredentials(String userId,String password,String timestamp) 
	{
		this.userId = userId;
		this.password = password;
		this.timestamp = timestamp;
		
	}

}
