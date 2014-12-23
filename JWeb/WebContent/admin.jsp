<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body>
		<form method="POST" action="AdminManager">
		<input type="text" id="write_article_title" name="write_article_title_name" value = "Introduisez votre titre ici"/><br/>
		<input type="text" id="write_article_text" name="write_article_text_name" value = "Introduisez votre texte ici"/><br/>
		<input type="submit" id="write_article_submit" name="write_article_submit_name" value="Validez votre article"/><br/>
	</form>
</body>
</html>