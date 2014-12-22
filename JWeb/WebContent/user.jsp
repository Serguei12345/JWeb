<%@page import="com.sdzee.bdd.CoreJDBC"%>
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
		CoreJDBC coreUser = (CoreJDBC)request.getAttribute("coreUser");

		ArrayList<ArrayList<String>> list = coreUser.getListOfArticles();
		out.println(list.get(0).get(0));
	%>

</body>
</html>