package com.balaji.controller;

public class Users {
	
	String username;
	String password;
	int balance;
	
	public Users()
	{
		
	}
	
	public Users(String username,String password)
	{
		super();
		this.username=username;
		this.password=password;
		//this.balance=balance;
	}

	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username=username;
	}

	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password=password;
	}
	
	public int getBalance()
	{
		return balance;
	}
	public void setBalance(int balance)
	{
		this.balance=balance;
	}
}


