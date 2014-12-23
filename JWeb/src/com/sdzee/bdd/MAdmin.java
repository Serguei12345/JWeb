package com.sdzee.bdd;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class MAdmin
{
	MAdmin()
	{
		
	}
	
	void insertArticleInDatabase(String text, String title)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
			java.sql.Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery("SELECT title FROM article;");
			
			String sqlRequest = "";
			rs.last();
			Integer lastRow = rs.getRow() + 1;
			String lastRowIncrement = lastRow.toString();
			sqlRequest += "INSERT into article VALUES (" + lastRowIncrement + ", " + "'" + title + "', " + "'" + text + "', 'lol', NOW(), " + "1);";
			statement.executeUpdate(sqlRequest);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
