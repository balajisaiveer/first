package com.balaji.modal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="finalusers")
public class User {
	
	
	@Id
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="balance")
	private int balance;
	
	
	
	
	public User()
	{
		
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(Object username)
	{
		this.username=(String)username;
	}

	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(Object password)
	{
		this.password=(String)password;
	}
	
	public int getBalance()
	{
		return balance;
	}
	public void setBalance(Object balance) 
	{
		this.balance=(int)balance;
	}
	
}


