package com.sdzee.bdd;

public class BoughtProduct
{
	private int idBuy;
	private int idProduct;
	private int idUser;
	private java.sql.Date dateBought;
	private String nameProduct;
	
	public BoughtProduct()
	{
		
	}
	
	public BoughtProduct(int idBuyToSet, int idProductToSet, int idUserToSet, java.sql.Date dateBoughtToSet, String nameProductToSet)
	{
		this.idBuy = idBuyToSet;
		this.idProduct = idProductToSet;
		this.idUser = idUserToSet;
		this.dateBought = dateBoughtToSet;
		this.nameProduct = nameProductToSet;
	}
	
	public int getIdBuy()
	{
		return (this.idBuy);
	}
	
	public int getIdProduct()
	{
		return (this.idProduct);
	}
	
	public int getIdUser()
	{
		return (this.idUser);
	}
	
	public java.sql.Date getDateBought()
	{
		return (this.dateBought);
	}
	
	public String getNameProduct()
	{
		return (this.nameProduct);
	}
}
