package com.sdzee.bdd;

public class Product
{
	private int idProduct;
	private String name;
	private java.sql.Date datePublication;
	private java.sql.Time timePublication;
	private String loginPublisher;
	private String description;
	private float price;
	private int quantity;
	
	Product()
	{
		
	}
	
	Product(int idProductToSet, String nameToSet, java.sql.Date dpToSet,
			java.sql.Time tpToSet, String loginPublisherToSet,
			String descriptionToSet, float priceToSet, int quantityToSet)
	{
		this.idProduct = idProductToSet;
		this.name = nameToSet;
		this.datePublication = dpToSet;
		this.timePublication = tpToSet;
		this.loginPublisher = loginPublisherToSet;
		this.description = descriptionToSet;
		this.price = priceToSet;
		this.quantity = quantityToSet;
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
	
	public float getQuantity()
	{
		return (this.quantity);
	}
}
