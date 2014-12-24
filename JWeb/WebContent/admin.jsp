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
		
		<form method="POST" action="AdminManager">
			<input type="text" id="write_review_title" name="write_review_title_name" value = "Introduisez votre titre ici"/><br/>
			<input type="text" id="write_review_text" name="write_review_text_name" value = "Introduisez votre texte ici"/><br/>
			<input type="text" id="write_review_product" name="write_review_product_name" value="Introduisez le nom du produit ici"/><br/>
			<input type="submit" id="write_review_submit" name="write_review_submit_name" value="Validez votre article"/><br/>
		</form>

		<form method="POST" action="AdminManager">
			<input type="text" id="write_rights_set" name="write_rights_set_name" value="Introduisez les droits en 0 et 1 ici"/><br/>
			<input type="text" id="write_login_set" name="write_login_set_name" value="Introduisez le login de la personne"/><br/>
			<input type="submit" id="write_rights_submit" name="write_rights_submit" value="Valider"/><br/>
		</form>
</body>
</html>