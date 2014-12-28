<%@page import="com.sdzee.bdd.CoreJDBC"%>
<%@page import="com.sdzee.bdd.Inscription"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/fonts.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/navBar.css">

<jsp:include page="header.html" />
<div class="page_title">Login</div>

<div style="width: 300px; display: inline-block; fload: left;"> 
	<form method="POST" action="CoreJDBC">
        <table width="100%" border="0" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF">
			<caption>Se connecter</caption>
	     	<tr>
	             <td width="500">Pseudo</td>
	             <td width="6">:</td>
	             <td width="294"><input type="text" id="login" name="login" /></td>
	        </tr>
	        <tr>
	             <td>Mot de passe</td>
	             <td>:</td>
	             <td><input type="password" id="password" name="password" /></td>
	        </tr>
	        <tr>
	             <td>&nbsp;</td>
	             <td>&nbsp;</td>
	             <td><input type="submit" id="submit" name="submit" value="Connection"/></td>
	        </tr>
          </table>
      </form>
      	<%
			String strError = (String)session.getAttribute("strError");
			if (strError != null && strError.length() > 0)
				out.println(strError);
		%>
 </div>

	<div style="width: 300px; display: inline-block; float: right;">

        <form method="POST" action="Inscription">
        	<table width="100%" border="0" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF">
           		<caption>S'inscrire</caption>
                <tr>
                	<td width="500">Pseudo</td>
                    <td width="6">:</td>
                    <td width="294"><input type="text" id="login" name="login" value="" size="20" maxlength="60" /></td>
                </tr>
                <tr>
                	<td>Mot de passe</td>
                    <td>:</td>
                    <td><input type="password" id="password" name="password" value="" size="20" maxlength="60" /></td>
                </tr>
                <tr>
                    <td>Répétez le mot de passe</td>
                    <td>:</td>
                    <td><input type="password" id="password-confirmation" name="password-confirmation" value="" size="20" maxlength="60" /></td>
                </tr>
                <tr>
                    <td>email</td>
                    <td>:</td>
                    <td><input type="text" id="email" name="email" value="" size="20" maxlength="60" /></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td><input type="submit" id="submit" name="submit" value="Inscription" /></td>
                </tr>
            </table>    
   		</form>
	</div>
<jsp:include page="footer.html" />
</body>
</html>
