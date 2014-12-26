package com.sdzee.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MArticlesReviews
{
	ArrayList<Article>	listOfArticles;
	ArrayList<Review>	listOfReviews;
	
	MArticlesReviews()
	{
		this.listOfArticles = new ArrayList<Article>();
		this.listOfReviews = new ArrayList<Review>();
	}
	
	public ArrayList<Article> getArticlesList()
	{
		return (this.listOfArticles);
	}
	
	public ArrayList<Review> getReviewsList()
	{
		return (this.listOfReviews);
	}
	
	void searchArticles()
	{		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
			Statement st = connexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT id_article, title, text, image, date_edit, id_author FROM article");
			
			this.listOfArticles.clear();
			while (rs.next() == true)
			{
				int idArticle = rs.getInt("id_article");
				String title = rs.getString("title");
				String text = rs.getString("text");
				String image = rs.getString("image");
				java.sql.Date date = rs.getDate("date_edit");
				java.sql.Time time = rs.getTime("date_edit");
				int idAuthor = rs.getInt("id_author");
				String author = this.searchNameOfLoginById(idAuthor, connexion);
				if (author.length() > 0)
				{
					Article articleToAdd = new Article(idArticle, title, text, image, date, time, author);
					this.listOfArticles.add(articleToAdd);
				}
			}
		}
		catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	String searchNameOfLoginById(int idOfLogin, Connection connexion)
	{
		String str = "";
		try
		{
			Statement st = connexion.createStatement();
			Integer itu = idOfLogin;
			ResultSet rs = st.executeQuery("SELECT login FROM user WHERE id_user=" + itu.toString() + ";");
			if (rs.next() == true)
				str = rs.getString("login");
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (str);
	}
	
	void searchReviews()
	{		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
			Statement st = connexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT id_review, id_author, title, text, image, id_product, date_edit FROM review");
			
			this.listOfReviews.clear();
			while (rs.next() == true)
			{
				int idArticle = rs.getInt("id_review");
				String title = rs.getString("title");
				String text = rs.getString("text");
				String image = rs.getString("image");
				java.sql.Date date = rs.getDate("date_edit");
				java.sql.Time time = rs.getTime("date_edit");
				int idAuthor = rs.getInt("id_author");
				int idProduct = rs.getInt("id_product");
				
				String author = this.searchNameOfLoginById(idAuthor, connexion);
				String productName = this.searchNameOfProductById(idProduct, connexion);
				JOptionPane.showConfirmDialog(null, author + "   " + productName);
				if (author.length() > 0 && productName.length() > 0)
				{
					Review articleToAdd = new Review(idArticle, title, text, image, date, time, author, productName);
					this.listOfReviews.add(articleToAdd);
				}
			}
		}
		catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	String searchNameOfProductById(int idOfProduct, Connection connexion)
	{
		String str = "";
		try
		{
			Statement st = connexion.createStatement();
			Integer itu = idOfProduct;
			ResultSet rs = st.executeQuery("SELECT name FROM product WHERE id_product=" + itu.toString() + ";");
			if (rs.next() == true)
				str = rs.getString("name");
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (str);
	}
}
