package com.sdzee.bdd;

public class Product
{
	private int idProduct;
	private String name;
	private java.sql.Date datePublication;
	private java.sql.Time timePublication;
	private boolean isBought;
	private int idBuyer;
	private java.sql.Date dateOfBuy;
	private java.sql.Time timeOfBuy;
	private int idPublisher;
	private String description;
	
	Product()
	{
		
	}
	
	Product(int idProductToSet, String nameToSet, java.sql.Date dpToSet,
			java.sql.Time tpToSet, boolean ibToSet, int idBuyerToSet,
			java.sql.Date dbToSet, java.sql.Time tbToSet, int iPToSet,
			String descriptionToSet)
	{
		this.idProduct = idProductToSet;
		this.name = nameToSet;
		this.datePublication = dpToSet;
		this.timePublication = tpToSet;
		this.isBought = ibToSet;
		this.idBuyer = idBuyerToSet;
		this.dateOfBuy = dbToSet;
		this.timeOfBuy = tbToSet;
		this.idPublisher = iPToSet;
		this.description = descriptionToSet;
	}
	
	int getIdProduct()
	{
		return (this.idProduct);
	}
	
	String getName()
	{
		return (this.name);
	}
	
	java.sql.Date getDateOfPublication()
	{
		return (this.datePublication);
	}
	
	java.sql.Time getTimeOfPublication()
	{
		return (this.timePublication);
	}
	
	boolean getIsBought()
	{
		return (this.isBought);
	}
	
	int getIdBuyer()
	{
		return (this.idBuyer);
	}

	java.sql.Date getDateOfBuy()
	{
		return (this.dateOfBuy);
	}
	
	java.sql.Time getTimeOfBuy()
	{
		return (this.timeOfBuy);
	}
	
	int getIdPublisher()
	{
		return (this.idPublisher);
	}
	
	String getDescription()
	{
		return (this.description);
	}
}
