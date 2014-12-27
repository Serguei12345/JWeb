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
		
		if ((String)session.getAttribute("strError") != null)
			out.println((String)session.getAttribute("strError"));
		Integer ct = 0;
		while (counter < productsListSize)
		{
			ct = counter + 1;
			Product productToUse = productsList.get(counter); %> <br/> 
			<% out.println("Produit : " + productToUse.getName()); %> <br/> 
			<% out.println("Description : " + productToUse.getDescription()); %> <br/>
			<% out.println("Prix : " + productToUse.getPrice() + " $"); %> <br/>
			<% out.println("Quantité : " + productToUse.getQuantity()); %> <br/>
			<% out.println("Publié par : " + productToUse.getLoginPublisher() + " le " + productToUse.getDateOfPublication() + " :: " + productToUse.getTimeOfPublication()); %> <br/> <br/>
			<form method="POST" action="ProductManager">
				<input type="submit" id="buy_item" name=<%="product" + ct.toString()%> value="Valider l'achat"/>
			</form>
			
			<% Integer li = counter;
				session.setAttribute("product" + li.toString(), productToUse.getName());
			++counter;
		}
	%>
</body>
</html>