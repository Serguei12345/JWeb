<%@page import="com.sdzee.bdd.ArticlesReviews"%>
<%@page import="com.sdzee.bdd.MArticlesReviews"%>
<%@page import="com.sdzee.bdd.Article"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Articles</title>
<jsp:include page="header.html" />
<div class="page_title">Articles</div>
	<%
		MArticlesReviews mAr = (MArticlesReviews)session.getAttribute("MArticlesReviews");
		if (mAr != null)
		{
			ArrayList<Article> articlesList = mAr.getArticlesList();
			if (articlesList != null)
			{
				int counter = 0;
				while (counter < articlesList.size())
				{
					Article articleToUse = articlesList.get(counter); %> <br/> 
					<% out.println("Title : " + articleToUse.getTitle()); %> <br/> 
					<% out.println("Content : " + articleToUse.getText()); %> <br/> 
					<% out.println("Published by : " + articleToUse.getAuthor() + " at " + articleToUse.getDateOfEdition() + " :: " + articleToUse.getTimeOfEdition()); %> <br/> <br/>
					<% ++counter;
				}
			}
		}
	%>
		<form method="POST" action="AdminManager">
			<input type="submit" id="go_to_user" name="go_to_user_name" value="UserZONE"/>
		</form>
		<jsp:include page="footer.html" />
		
</body>
</html>