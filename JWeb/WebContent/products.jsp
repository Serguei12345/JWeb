<%@page import="com.sdzee.bdd.ProductManager"%>
<%@page import="com.sdzee.bdd.MProductManager"%>
<%@page import="com.sdzee.bdd.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produits</title>
</head>
<body>
	<%
		MProductManager mPM = (MProductManager)session.getAttribute("MProductManager");
		ArrayList<Product> productsList = mPM.getListOfProducts();
		int counter = 0;
		int productsListSize = productsList.size();
		JOptionPane.showConfirmDialog(null, productsListSize);
		while (counter < productsListSize)
		{
			Product productToUse = productsList.get(counter); %> <br/> 
			<% out.println("Name : " + productToUse.getName()); %> <br/> 
			<% out.println("Description : " + productToUse.getDescription()); %> <br/>
			<% out.println("Price : " + productToUse.getPrice()); %> <br/> 
			<% out.println("Published by : " + productToUse.getLoginPublisher() + " at " + productToUse.getDateOfPublication() + " :: " + productToUse.getTimeOfPublication()); %> <br/> <br/>
			<% ++counter;
		}
	%>
</body>
</html>