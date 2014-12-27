<%@page import="com.sdzee.bdd.CoreJDBC"%>
<%@page import="com.sdzee.bdd.MConnection"%>
<%@page import="com.sdzee.bdd.User"%>
<%@page import="com.sdzee.bdd.AdminManager"%>
<%@page import="com.sdzee.bdd.ArticlesReviews"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Utilisateur</title>
</head>
<body>
	<%
		MConnection coreUser = (MConnection)session.getAttribute("MConnection");
		User user = (User)coreUser.getUser();
		Float credit = user.getCredit();
	
		out.println("Bonjour " + user.getLogin() + ". Vous disposez de " + credit + " $."); %> <br/> 
	<%
		ArrayList<ArrayList<String>> list = coreUser.getListOfArticles();
		int counterArticle = 0;
		int counterArticleElement;
			int sizeOfArticleElements;
		int sizeOfArticles = list.size();
		if (sizeOfArticles > 5)
			sizeOfArticles = 5;
		out.println("Nouveaux Articles :");	
	%>	
		<br/>
	<%
		while (counterArticle < sizeOfArticles)
		{
			counterArticleElement = 0;
			sizeOfArticleElements = list.get(counterArticle).size();
			while (counterArticleElement < sizeOfArticleElements)
			{
				out.println(list.get(counterArticle).get(counterArticleElement) + " ");
				out.println("");
				++counterArticleElement;
			}
			++counterArticle; %> <br/> 
	<%
		}

		String rights = user.getRights();
	
		out.println(rights);
		if (rights.charAt(0) == '1')
		{	
	%>

		<form method="POST" action="AdminManager">
			<input type="submit" id="submit_admin" name="admin_begin_submit" value="AdminZONE"/>
		</form>
		
		<form method="POST" action="ArticlesReviews">
			<input type="submit" id="submit_articles" name="articles_submit" value="Voir les articles"/>
		</form>
		
		<form method="POST" action="ArticlesReviews">
			<input type="submit" id="submit_reviews" name="reviews_submit" value="Voir les reviews"/>
		</form>
		
		<form method="POST" action="ProductManager">
			<input type="submit" id="submit_products" name="products_submit" value="Voir les produits disponibles"/>
		</form>
		
		<form method="POST" action="ProductManager">
			<input type="submit" id="bought_products_submit" name="bought_products_submit_name" value="Voir vos achats"/>
		</form>
	<%
		}
	%>
</body>
</html>