<%@page import="com.sdzee.bdd.CoreJDBC"%>
<%@page import="com.sdzee.bdd.MConnection"%>
<%@page import="com.sdzee.bdd.User"%>
<%@page import="com.sdzee.bdd.AdminManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>
</head>
<body>
	<%
		MConnection coreUser = (MConnection)session.getAttribute("MConnection");

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
				++counterArticleElement;
			}
			++counterArticle;
	%>
			<br/>
	<%	
		}
		
		User user = coreUser.getUser();
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
	<%
		}
	%>
</body>
</html>