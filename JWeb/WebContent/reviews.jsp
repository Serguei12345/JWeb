<%@page import="com.sdzee.bdd.ArticlesReviews"%>
<%@page import="com.sdzee.bdd.MArticlesReviews"%>
<%@page import="com.sdzee.bdd.Review"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reviews</title>
</head>
<body>
	<%
		MArticlesReviews mAr = (MArticlesReviews)session.getAttribute("MArticlesReviews");
		ArrayList<Review> reviewsList = mAr.getReviewsList();
		int counter = 0;
		while (counter < reviewsList.size())
		{
			Review reviewToUse = reviewsList.get(counter); %> <br/> 
			<% out.println("Title : " + reviewToUse.getTitle()); %> <br/> 
			<% out.println("Content : " + reviewToUse.getText()); %> <br/>
			<% out.println("Product : " + reviewToUse.getObjectName()); %> <br/> 
			<% out.println("Published by : " + reviewToUse.getAuthor() + " at " + reviewToUse.getDateOfEdition() + " :: " + reviewToUse.getTimeOfEdition()); %> <br/> <br/>
			<% ++counter;
		}
	%>
		<form method="POST" action="AdminManager">
			<input type="submit" id="go_to_user" name="go_to_user_name" value="UserZONE"/>
		</form>
</body>
</html>