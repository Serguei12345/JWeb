<%@page import="com.sdzee.bdd.CoreJDBC"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/fonts.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/navBar.css">

</head>
<body>
	<div class="nav2">
        <div class="nav2_960">
	    	<div class="nav2_menu_gen">
	        	<a href="/"><div class="nav_menu"><span class="nav_menu_home"></span><span>Home</span></div></a>
	        	<a href="/"><div class="nav_menu"><span class="nav_menu_boutique"></span><span>Shop</span></div></a>
	        	<a href="/"><div class="nav_menu"><span class="nav_menu_login"></span><span>login</span></div></a>
	    	</div>
    	</div>
	</div>

<a href="/"><div class="nav2_logo" id="nav2_logo"><img src="img/logo_armenian_shop.png" alt="logo de the armenian shop" width=480 /></div>
</a>
<div class="content">

<div class="page_title"><span class="page_title_text">Login</span></div>
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
</div>
</body>
</html>
