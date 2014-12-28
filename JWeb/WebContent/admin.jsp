<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<jsp:include page="header.html" />
	<%
		String strError = (String)session.getAttribute("strError");
		if (strError != null && strError.length() > 0)
			out.println(strError);
		
	%>
	<div class="page_title">Admin</div>
		<div class="admin_box">
			<form method="POST" action="AdminManager">
			   <table  width="300px" height="150px" border="0" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF">
					<caption>Nouvel article</caption>
				     	<tr>
				             <td width="500">Titre</td>
				             <td width="6">:</td>
				             <td width="294"><input type="text" id="write_article_title" name="write_article_title_name" value = "Introduisez votre titre ici"/></td>
				        </tr>
				        <tr>
				             <td>Article</td>
				             <td>:</td>
				             <td><input type="text" id="write_article_text" name="write_article_text_name" value = "Introduisez votre texte ici"/></td>
				        </tr>
				        <tr>
				             <td>&nbsp;</td>
				             <td>&nbsp;</td>
				             <td><input type="submit" id="write_article_submit" name="write_article_submit_name" value="Validez votre article"/></td>
				        </tr>
          		</table>
      		</form>
		</div>
		<div class="admin_box">	
			<form method="POST" action="AdminManager">
			   <table width="300px" height="150px" border="0" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF">
					<caption>Nouvelle review</caption>
				     	<tr>
				             <td width="500">Titre</td>
				             <td width="6">:</td>
				             <td width="294"><input type="text" id="write_review_title" name="write_review_title_name" value = "Introduisez votre titre ici"/></td>
				        </tr>
				        <tr>
				             <td>Review</td>
				             <td>:</td>
				             <td><input type="text" id="write_review_text" name="write_review_text_name" value = "Introduisez votre texte ici"/></td>
				        </tr>
				        <tr>
				             <td>Nom du produit</td>
				             <td>:</td>
				             <td><input type="text" id="write_review_product" name="write_review_product_name" value="Introduisez le nom du produit ici"/></td>
				        </tr>
				        <tr>
				             <td>&nbsp;</td>
				             <td>&nbsp;</td>
				             <td><input type="submit" id="write_review_submit" name="write_review_submit_name" value="Validez votre review"/></td>
				        </tr>
          		</table>
      		</form>
		</div>
		<div class="admin_box">	
			<form method="POST" action="AdminManager">
			   <table width="300px" height="150px" border="0" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF">
					<caption>Changer les droits d'un utilisateur</caption>
				     	<tr>
				             <td width="500">Login</td>
				             <td width="6">:</td>
				             <td width="294"><input type="text" id="write_login_set" name="write_login_set_name" value="Introduisez le login de la personne"/></td>
				        </tr>
				        <tr>
				             <td>Droits</td>
				             <td>:</td>
				             <td><input type="text" id="write_rights_set" name="write_rights_set_name" value="Introduisez les droits en 0 et 1 ici"/></td>
				        </tr>
				        <tr>
				             <td>&nbsp;</td>
				             <td>&nbsp;</td>
				             <td><input type="submit" id="write_rights_submit" name="write_rights_submit" value="Valider"/></td>
				        </tr>
          		</table>
      		</form>
		</div>
		<div class="admin_box">	
			<form method="POST" action="AdminManager">
			   <table width="300px" height="150px" border="0" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF">
					<caption>Changer le solde d'un utilisateur</caption>
				     	<tr>
				             <td width="500">Login</td>
				             <td width="6">:</td>
				             <td width="294"><input type="text" id="write_login_set" name="write_login_set_name" value="Introduisez le login de la personne"/></td>
				        </tr>
				        <tr>
				             <td>Solde</td>
				             <td>:</td>
				             <td><input type="text" id="write_credit_set" name="write_credit_set_name" value="Introduisez le montant de l'utilisateur"/></td>
				        </tr>
				        <tr>
				             <td>&nbsp;</td>
				             <td>&nbsp;</td>
				             <td><input type="submit" id="write_credit_submit" name="write_credit_submit" value="Changer le montant d'un utilisateur"/></td>
				        </tr>
          		</table>
      		</form>
      	</div>
		<div class="admin_box">	
			<form method="POST" action="AdminManager">
			   <table width="300px" height="150px" border="0" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF">
					<caption>Nouveau produit</caption>
				     	<tr>
				             <td width="500">Nom du produit</td>
				             <td width="6">:</td>
				             <td width="294"><input type="text" id="write_product_name_set" name="write_product_name_set_name" value="Introduisez le nom du produit_ici"/></td>
				        </tr>
				        <tr>
				             <td>Description</td>
				             <td>:</td>
				             <td><input type="text" id="write_product_description_set" name="write_product_description_set_name" value="Introduisez la description du produit ici"/></td>
				        </tr>
				        <tr>
				             <td>Prix</td>
				             <td>:</td>
				             <td><input type="text" id="write_product_price_set" name="write_product_price_set_name" value="Introduisez le prix du produit ici"/></td>
				        </tr>
				        <tr>
				             <td>&nbsp;</td>
				             <td>&nbsp;</td>
				             <td><input type="submit" id="write_product_submit" name="write_product_submit_name" value="Validez votre produit"/></td>
				        </tr>
          		</table>
      		</form>
		</div>
		<div class="admin_box">	
			<form method="POST" action="AdminManager">
			   <table width="300px" height="150px" border="0" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF">
					<caption>Changer la quantité disponible d'un produit</caption>
				     	<tr>
				             <td width="500">Nom du produit</td>
				             <td width="6">:</td>
				             <td><input type="text" id="write_product_name_set" name="write_product_name_set_name" value="Introduisez le nom du produit_ici"/></td>
				        </tr>
				        <tr>
				             <td>Quantité</td>
				             <td>:</td>
				             <td><input type="text" id="write_product_quantity_set" name="write_product_quantity_set_name" value="Introduisez la quantité du produit ici"/></td>
				        </tr>
				        <tr>
				             <td>&nbsp;</td>
				             <td>&nbsp;</td>
				             <td><input type="submit" id="write_product_quantity_submit" name="write_product_quantity_submit_name" value="Validez"/></td>
				        </tr>
          		</table>
      		</form>
		</div>	
		
		<form method="POST" action="AdminManager">
			<input type="submit" id="go_to_user" name="go_to_user_name" value="UserZONE"/>
		</form>


		<jsp:include page="footer.html" />
</body>
</html>