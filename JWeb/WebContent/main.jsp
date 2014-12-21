<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<form method="POST" action="CoreJDBC">
		<p>Vous pouvez vous connecter via ce formulaire</p>
		<input type="text" id="login" name="login" value="Entrez votre identifiant"/>
		<br/>
		<input type="password" id="password" name="password" value=""/>
		<br/>
		<input type="submit" id="submit" name="submit" value="Connection"/>
	</form>
	<form method="POST" action="Inscription">
		<p>Vous pouvez vous inscrire via ce formulaire</p>
		<input type="text" id="login" name="login" value="" size="20" maxlength="60"/>
		<br/>
		<input type="password" id="password" name="password" value="" size="20" maxlength="60"/>
		<br/>
		<input type="password" id="password-confirmation" name="password-confirmation" value="" size="20" maxlength="60"/>
		<br/>	
		<input type="text" id="email" name="email" value="" size="20" maxlength="60"/>
		<br/>
		<input type="text" id="email-confirmation" name="email-confirmation" value="" size="20" maxlength="60"/>
		<br/>
		<input type="submit" id="submit" name="submit" value="Inscription"/>
	</form>
	<table>
		<tr>
		</tr>	
	</table>
</body>
</html>