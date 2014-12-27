package com.sdzee.bdd;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MAdmin
{
	MAdmin()
	{
		
	}
	
	boolean insertProduct(String name, String description, String priceString, User user)
	{
		try
		{
			Checks checks = new Checks();
			if (checks.isAlphanumeric(name) == false || checks.isAlphanumeric(description) == false || checks.isNumeric(priceString) == false)
				return (false);
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
			java.sql.Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery("SELECT name FROM product;");
			
			String sqlRequest = "";
			rs.last();
			Integer lastRow = rs.getRow() + 1;
			String lastRowIncrement = lastRow.toString();
			String id_author = ((Integer)user.getId()).toString();
			float price = Float.parseFloat(priceString);
			sqlRequest = "INSERT into product (id_product, name, date_publication, id_publisher, description, price, quantity) VALUES ("
						+ lastRowIncrement + ", '" + name + "', NOW(), " + id_author + ", '" + description + "', " + price + ", 0);";
			statement.executeUpdate(sqlRequest);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return (true);
	}
	
	boolean insertArticleInDatabase(String title, String text, User user)
	{
		try
		{
			Checks checks = new Checks();
			if (checks.isAlphanumeric(title) == false || checks.isAlphanumeric(text) == false)
				return (false);
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
			java.sql.Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery("SELECT title FROM article;");
			
			String sqlRequest = "";
			rs.last();
			Integer lastRow = rs.getRow() + 1;
			String lastRowIncrement = lastRow.toString();
			String id_author = ((Integer)user.getId()).toString();
			sqlRequest += "INSERT into article VALUES (" + lastRowIncrement + ", " + "'" + title + "', " + "'" + text + "', 'image', NOW(), "
					+ id_author + ");";
			statement.executeUpdate(sqlRequest);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return (true);
	}
	
	boolean insertReviewInDatabase(String title, String text, String productName, User user)
	{
		try
		{
			Checks checks = new Checks();
			if (checks.isAlphanumeric(title) == false || checks.isAlphanumeric(text) == false || checks.isAlphanumeric(productName) == false)
				return (false);
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
			java.sql.Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery("SELECT title FROM review;");
			
			String sqlRequest = "";
			rs.last();
			Integer lastRow = rs.getRow() + 1;
			String lastRowIncrement = lastRow.toString();
			String id_author = ((Integer)user.getId()).toString();
			String id_product = this.getIdOfProductByHisName(statement, productName);
			if (id_product.length() > 0)
			{
				sqlRequest += "INSERT INTO review VALUES (" + lastRowIncrement + ", " + id_author + ", '" + title + "', '"
						+ text + "', 'image', " + id_product + ", NOW());";
				JOptionPane.showConfirmDialog(null, sqlRequest);
				statement.executeUpdate(sqlRequest);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return (true);
	}
	
	String getIdOfProductByHisName(java.sql.Statement statement, String productName)
	{
		String strToRet = "";
		
		try
		{
			ResultSet rs = statement.executeQuery("SELECT id_product FROM product WHERE name='" + productName + "';");
			
			if (rs.next() == true)
				strToRet = rs.getString("id_product");
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (strToRet);
	}
	
	boolean setRightsOfUser(String login, String rightsToSet, User user)
	{
		try
		{
			Checks checks = new Checks();
			if (checks.isAlphanumeric(login) == false || checks.isAlphanumeric(rightsToSet) == false)
				return (false);
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
			java.sql.Statement statement = connexion.createStatement();
			
			String sqlRequest = "";
			sqlRequest += "UPDATE user SET rights='" + rightsToSet + "' WHERE login='" + login + "';";
			statement.executeUpdate(sqlRequest);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return (true);
	}
	
	boolean setCreditsOfUser(String login, String creditsToSet, User user)
	{
		try
		{
			Checks checks = new Checks();
			if (checks.isAlphanumeric(login) == false || checks.isNumeric(creditsToSet) == false)
				return (false);
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
			java.sql.Statement statement = connexion.createStatement();
			
			String sqlRequest = "";
			sqlRequest += "UPDATE user SET credit=" + creditsToSet + " WHERE login='" + login + "';";
			statement.executeUpdate(sqlRequest);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return (true);
	}
	
	boolean setQuantityOfProduct(String productName, String quantityOfProduct, User user)
	{
		try
		{
			Checks checks = new Checks();
			if (checks.isAlphanumeric(productName) == false || checks.isNumeric(quantityOfProduct) == false)
				return (false);
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
			java.sql.Statement statement = connexion.createStatement();
			
			String sqlRequest = "";
			sqlRequest += "UPDATE product SET quantity=" + quantityOfProduct + " WHERE name='" + productName + "';";
			statement.executeUpdate(sqlRequest);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return (true);
	}
}
