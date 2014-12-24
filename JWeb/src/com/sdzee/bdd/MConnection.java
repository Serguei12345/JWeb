package com.sdzee.bdd;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;

public class MConnection
{
	private ArrayList<ArrayList<String>> listOfArticles;
	private User userOfConnection;
	
	MConnection()
	{
		this.listOfArticles = new ArrayList<ArrayList<String>>();
	}
	
	public User getUser()
	{
		return (this.userOfConnection);
	}
	
	public ArrayList<ArrayList<String>> getListOfArticles()
	{
		return (this.listOfArticles);
	}
	
	public boolean connectionToDatabase(String userLogin, String userPwd) throws ServletException, IOException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
			java.sql.Statement statement = connexion.createStatement();
    	
			ResultSet rs = statement.executeQuery("SELECT login, password, rights, last_connection, is_connected, id_user FROM user WHERE login='" + userLogin + "' AND password='" + userPwd + "';");
			
			if (rs.next() == true)
			{
				this.userOfConnection = new User(rs);
				this.articleActions(statement);
				return (true);
			}
			return (false);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return (false);
	}
	
	protected void articleActions(java.sql.Statement statement) throws Exception
	{
		try
		{
			int counter = 0;
			listOfArticles.clear();
			ResultSet rs = statement.executeQuery("SELECT title, text, image, date_edit FROM article ORDER BY date_edit DESC;");
			
			while (rs.next() == true && counter < 10)
			{
				ArrayList<String> elemsToAdd = new ArrayList<String>();
				elemsToAdd.clear();
				elemsToAdd.add(rs.getString("title"));
				elemsToAdd.add(rs.getString("text"));
				elemsToAdd.add(rs.getString("image"));
				java.sql.Date dateToAdd = rs.getDate("date_edit");
				java.sql.Time timeToAdd = rs.getTime("date_edit");
				elemsToAdd.add(dateToAdd.toString());			
				elemsToAdd.add(timeToAdd.toString());
				listOfArticles.add(elemsToAdd);
				++counter;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
