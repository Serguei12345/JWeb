package com.sdzee.bdd;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User 
{
	private String login;
	private String password;
	private String rights;
	private int id;
	private java.sql.Date lastConnection;
	private java.sql.Time lCT;
	private boolean is_connected;
	private float credit;
	
	User()
	{
		
	}
	
	User(ResultSet rs)
	{
		try
		{
			this.login = rs.getString("login");
			this.password = rs.getString("password");
			this.rights = rs.getString("rights");
			this.id = rs.getInt("id_user");
			this.lastConnection = rs.getDate("last_connection");
			this.lCT = rs.getTime("last_connection");
			this.is_connected = rs.getBoolean("is_connected");
			this.credit = rs.getFloat("credit");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	User(User userToSet)
	{
		this.login = userToSet.getLogin();
		this.password = userToSet.getPassword();
		this.rights = userToSet.getRights();
		this.id = userToSet.getId();
		this.lastConnection = userToSet.getLastConnection();
		this.lCT = userToSet.getLastConnectionTime();
		this.is_connected = userToSet.getConnectionState();
		this.credit = userToSet.getCredit();
	}
	
	public float getCredit()
	{
		return (this.credit);
	}
	
	public String getLogin()
	{
		return (this.login);
	}
	
	public String getPassword()
	{
		return (this.password);
	}
	
	public String getRights()
	{
		return (this.rights);
	}
	
	public int getId()
	{
		return (this.id);
	}
	
	public java.sql.Date getLastConnection()
	{
		return (this.lastConnection);
	}
	
	public boolean getConnectionState()
	{
		return (this.is_connected);
	}
	
	public java.sql.Time getLastConnectionTime()
	{
		return (this.lCT);
	}
}
