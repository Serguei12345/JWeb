package com.sdzee.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MProductManager
{
	private ArrayList<Product> listOfProducts;
	private ArrayList<BoughtProduct> listOfBoughtProducts;
	
	public ArrayList<Product> getListOfProducts()
	{
		return (this.listOfProducts);
	}
	
	public ArrayList<BoughtProduct> getListOfBoughtProducts()
	{
		return (this.listOfBoughtProducts);
	}
	
	MProductManager()
	{
		this.listOfProducts = new ArrayList<Product>();
		this.listOfBoughtProducts = new ArrayList<BoughtProduct>();
	}
	
	void searchBoughtProducts(User user)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
			Statement st = connexion.createStatement();
			Integer itu = user.getId();
			ResultSet rs = st.executeQuery("SELECT id_buy, id_product, id_user, date_bought FROM bought_products WHERE id_user=" + itu.toString() + ";");
			
			this.listOfBoughtProducts.clear();
			while (rs.next() == true)
			{
				Integer idBuy= rs.getInt("id_buy");
				Integer idProduct = rs.getInt("id_product");
				Integer idUser = rs.getInt("id_user");
				java.sql.Date dateBought= rs.getDate("date_bought");
				java.sql.Time timeBought= rs.getTime("date_bought");
				String name = this.findItemNameByHisId(idProduct, connexion);
				BoughtProduct boughtProduct = new BoughtProduct(idBuy, idProduct, idUser, dateBought, timeBought, name);
				this.listOfBoughtProducts.add(boughtProduct);
			}

		}
		catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	void searchProducts()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
			Statement st = connexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT id_product, name, date_publication, id_publisher, description, price, quantity FROM product");
			
			this.listOfProducts.clear();
			while (rs.next() == true)
			{
				int idArticle = rs.getInt("id_product");
				String name = rs.getString("name");
				java.sql.Date datePublication = rs.getDate("date_publication");
				java.sql.Time timePublication = rs.getTime("date_publication");
				int idPublisher = rs.getInt("id_publisher");
				String description = rs.getString("description");
				float price = rs.getFloat("price");
				int quantity = rs.getInt("quantity");
				
				String loginPublisher = this.searchLoginById(idPublisher, connexion);
				if (loginPublisher.length() > 0)
				{
					Product productToAdd = new Product(idArticle, name, datePublication, timePublication, loginPublisher, description, price, quantity);
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
			e.printStackTrace();
		}
		return (str);
	}
	
	int buyProductForUser(String nameOfItem, User user)
	{
		try
		{
			Checks checks = new Checks();
			if (checks.isAlphanumeric(nameOfItem) == false)
				return (3);
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
			Statement st = connexion.createStatement();

			this.buyItemInsertInBoughtItems(nameOfItem, user, st);
			if (this.buyItemReduceQuantityOfItems(nameOfItem, st) == false)
				return (1);
			if (this.buyItemReduceUserCredits(user, nameOfItem, st) == false)
				return (2);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return (0);
	}
	
	void buyItemInsertInBoughtItems(String nameOfItem, User user, Statement statement)
	{
		try
		{
			Integer idProduct = this.buyItemFindIdOfProductByName(nameOfItem, statement);
			Integer idUser = user.getId();
			ResultSet rs = statement.executeQuery("SELECT id_buy FROM bought_products;");
			rs.last();
			Integer lastRow = rs.getRow() + 1;
			statement.executeUpdate("INSERT INTO bought_products VALUES (" + lastRow.toString() + ", " + idProduct.toString() + ", " + idUser.toString() + ", NOW());");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	String buyItemFindNameOfProductById(String idProduct)
	{
		String strToRet = "";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
			Statement st = connexion.createStatement();
			String itu = idProduct;
			ResultSet rs = st.executeQuery("SELECT name FROM product WHERE id_product='" + itu + "';");
			if (rs.next() == true)
				strToRet = rs.getString("name");
		}
		catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return (strToRet);
	}
	
	int buyItemFindIdOfProductByName(String nameOfItem, Statement statement)
	{
		int intToRet = 0;
		
		try
		{
			String itu = nameOfItem;
			ResultSet rs = statement.executeQuery("SELECT id_product FROM product WHERE name='" + itu + "';");
			if (rs.next() == true)
				intToRet = rs.getInt("id_product");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return (intToRet);
	}
	
	String findItemNameByHisId(int itemId, Connection connexion)
	{
		String strToRet = "";
		try
		{
			Integer itu = itemId;
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery("SELECT name FROM product WHERE id_product=" + itu.toString() + ";");
			if (rs.next() == true)
				strToRet = rs.getString("name");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return (strToRet);
	}
	
	float buyItemFindPriceOfProductByName(String nameOfItem, Statement statement)
	{
		float intToRet = 0;
		
		try
		{
			String itu = nameOfItem;
			ResultSet rs = statement.executeQuery("SELECT price FROM product WHERE name='" + itu + "';");
			if (rs.next() == true)
				intToRet = rs.getInt("price");
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (intToRet);
	}
	
	float buyItemFindCreditsOfUserByLogin(String loginOfUser, Statement statement)
	{
		float intToRet = 0;
		
		try
		{
			String itu = loginOfUser;
			ResultSet rs = statement.executeQuery("SELECT credit FROM user WHERE login='" + itu + "';");
			if (rs.next() == true)
				intToRet = rs.getInt("credit");
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (intToRet);
	}
	
	boolean buyItemReduceQuantityOfItems(String nameOfItem, Statement statement)
	{
		try
		{
			Integer idProduct = this.buyItemFindIdOfProductByName(nameOfItem, statement);
			ResultSet rs = statement.executeQuery("SELECT quantity FROM product WHERE id_product=" + idProduct.toString() + ";");
			
			if (rs.next() == true)
			{
				Integer quantity = rs.getInt("quantity") - 1;
				if (quantity < 0)
				{
					this.cancelFirst(statement);
					return (false);
				}
				String sqlRequest = "UPDATE product SET quantity=" + quantity.toString() + " WHERE id_product=" + idProduct.toString() + ";";
				statement.executeUpdate(sqlRequest);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (true);
	}
	
	void cancelFirst(Statement statement)
	{
		
		try
		{
			ResultSet rs = statement.executeQuery("SELECT id_buy FROM bought_products;");
			rs.last();
			Integer lastRow = rs.getRow();
			statement.executeUpdate("DELETE FROM bought_products WHERE id_buy=" + lastRow.toString() + ";");
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	void cancelSecond(String nameOfItem, Statement statement)
	{
		try
		{
			Integer idProduct = this.buyItemFindIdOfProductByName(nameOfItem, statement);
			ResultSet rs = statement.executeQuery("SELECT quantity FROM product WHERE id_product=" + idProduct.toString() + ";");
			
			if (rs.next() == true)
			{
				Integer quantity = rs.getInt("quantity") + 1;
				String sqlRequest = "UPDATE product SET quantity=" + quantity.toString() + " WHERE id_product=" + idProduct.toString() + ";";
				statement.executeUpdate(sqlRequest);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	boolean buyItemReduceUserCredits(User user, String nameOfItem, Statement statement)
	{
		try
		{
			Float priceOfItem = this.buyItemFindPriceOfProductByName(nameOfItem, statement);
			Float creditsOfUser = this.buyItemFindCreditsOfUserByLogin(user.getLogin(), statement);
			
			if (creditsOfUser - priceOfItem < 0)
			{
				this.cancelFirst(statement);
				this.cancelSecond(nameOfItem, statement);
				return (false);
			}
			creditsOfUser -= priceOfItem;
			String sqlRequest = "UPDATE user SET credit=" + creditsOfUser.toString() + " WHERE login='" + user.getLogin() + "';";
			statement.executeUpdate(sqlRequest);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (true);
	}
}
