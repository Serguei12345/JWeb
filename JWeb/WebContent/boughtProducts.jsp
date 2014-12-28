<%@page import="com.sdzee.bdd.ProductManager"%>
<%@page import="com.sdzee.bdd.MProductManager"%>
<%@page import="com.sdzee.bdd.BoughtProduct"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Les produits que vous avez acheté</title>
<jsp:include page="header.html" />
<div class="page_title">Produits acheté</div>
		<%
			MProductManager mPM = (MProductManager)session.getAttribute("MProductManager");
			ArrayList<BoughtProduct> productsList = mPM.getListOfBoughtProducts();
			int counter = 0;
			int productsListSize = productsList.size();
		
			while (counter < productsListSize)
			{
				BoughtProduct productToUse = productsList.get(counter);
				out.println("Produit : " + productToUse.getNameProduct()); %> <br/> 
				<% out.println("Date de l'achat : " + productToUse.getDateBought() + " à " + productToUse.getTimeBought()); %> <br/> <br/> <%
				++counter;
			}
		%>
		<form method="POST" action="AdminManager">
			<input type="submit" id="go_to_user" name="go_to_user_name" value="UserZONE"/>
		</form>
		<jsp:include page="footer.html" />
</body>
</html>