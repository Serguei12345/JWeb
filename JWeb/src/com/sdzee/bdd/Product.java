package com.sdzee.bdd;

public class Product
{
	private int idProduct;
	private String name;
	private java.sql.Date datePublication;
	private java.sql.Time timePublication;
	private boolean isBought;
	private String loginBuyer;
	private java.sql.Date dateOfBuy;
	private java.sql.Time timeOfBuy;
	private String loginPublisher;
	private String description;
	private float price;
	
	Product()
	{
		
	}
	
	Product(int idProductToSet, String nameToSet, java.sql.Date dpToSet,
			java.sql.Time tpToSet, boolean ibToSet, String loginBuyerToSet,
			java.sql.Date dbToSet, java.sql.Time tbToSet, String loginPublisherToSet,
			String descriptionToSet, float priceToSet)
	{
		this.idProduct = idProductToSet;
		this.name = nameToSet;
		this.datePublication = dpToSet;
		this.timePublication = tpToSet;
		this.isBought = ibToSet;
		this.loginBuyer = loginBuyerToSet;
		this.dateOfBuy = dbToSet;
		this.timeOfBuy = tbToSet;
		this.loginPublisher = loginPublisherToSet;
		this.description = descriptionToSet;
		this.price = priceToSet;
	}
	
	public int getIdProduct()
	{
		return (this.idProduct);
	}
	
	public String getName()
	{
		return (this.name);
	}
	
	public java.sql.Date getDateOfPublication()
	{
		return (this.datePublication);
	}
	
	public java.sql.Time getTimeOfPublication()
	{
		return (this.timePublication);
	}
	
	public boolean getIsBought()
	{
		return (this.isBought);
	}
	
	public String getLoginBuyer()
	{
		return (this.loginBuyer);
	}

	public java.sql.Date getDateOfBuy()
	{
		return (this.dateOfBuy);
	}
	
	public java.sql.Time getTimeOfBuy()
	{
		return (this.timeOfBuy);
	}
	
	public String getLoginPublisher()
	{
		return (this.loginPublisher);
	}
	
	public String getDescription()
	{
		return (this.description);
	}
	
	public float getPrice()
	{
		return (this.price);
	}
}
