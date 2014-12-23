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
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
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
	
	public int getid()
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