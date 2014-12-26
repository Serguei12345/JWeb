package com.sdzee.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MProductManager
{
	private ArrayList<Product> listOfProducts;
	
	
	public ArrayList<Product> getListOfProducts()
	{
		return (this.listOfProducts);
	}
	
	MProductManager()
	{
		this.listOfProducts = new ArrayList<Product>();
	}
	
	void searchProducts()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
			Statement st = connexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT id_product, name, date_publication, is_bought, id_buyer, date_of_buy, id_publisher, description, price FROM product");
			
			this.listOfProducts.clear();
			while (rs.next() == true)
			{
				int idArticle = rs.getInt("id_product");
				String name = rs.getString("name");
				java.sql.Date datePublication = rs.getDate("date_publication");
				java.sql.Time timePublication = rs.getTime("date_publication");
				boolean isBought = rs.getBoolean("is_bought");
				int idBuyer = rs.getInt("id_buyer");
				java.sql.Date dateBuy = rs.getDate("date_of_buy");
				java.sql.Time timeBuy = rs.getTime("date_of_buy");
				int idPublisher = rs.getInt("id_publisher");
				String description = rs.getString("description");
				float price = rs.getFloat("price");
				
				String loginBuyer = this.searchLoginById(idBuyer, connexion);
				String loginPublisher = this.searchLoginById(idPublisher, connexion);
				JOptionPane.showConfirmDialog(null, loginBuyer + "   " + loginPublisher);
				if (loginPublisher.length() > 0)
				{
					Product productToAdd = new Product(idArticle, name, datePublication, timePublication, isBought,
													loginBuyer, dateBuy, timeBuy, loginPublisher, description, price);
					this.listOfProducts.add(productToAdd);
				}
			}
		}
		catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	String searchLoginById(int idOfUser, Connection connexion)
	{
		String str = "";
		try
		{
			Statement st = connexion.createStatement();
			Integer itu = idOfUser;
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
}
