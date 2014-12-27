package com.sdzee.bdd;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Inscription
 */
public class Inscription extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String strError = "";
    	try
    	{    		
			Class.forName("com.mysql.jdbc.Driver");
	    	java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
	    	java.sql.Statement statement = connexion.createStatement();
	    	boolean bLogin = this.checkLogin(request, statement);
	    	boolean bEmail = this.checkIfEmail(request, statement);
	    	boolean bPwd = this.checkIfPasswordGood(request, statement);
	    	if (bLogin == false || bEmail == false || bPwd == false)
	    	{
	    		if (bLogin == false)
	    		{
	    			strError = "Le login que vous avez inséré n'est pas valide";
	    			HttpSession session = request.getSession();
	    			session.setAttribute("strError", strError);
	    			getServletContext().getRequestDispatcher("/main.jsp").forward(request,response);
	    		}
	    		else if (bEmail == false)
	    		{
	    			strError = "L'adresse mail que vous avez inséré n'est pas valide";
	    			HttpSession session = request.getSession();
	    			session.setAttribute("strError", strError);
	    			getServletContext().getRequestDispatcher("/main.jsp").forward(request,response);
	    		}
	    		else if (bPwd == false)
	    		{
	    			strError = "Les mots de passe que vous avez inséré ne sont pas valides";
	    			HttpSession session = request.getSession();
	    			session.setAttribute("strError", strError);
	    			getServletContext().getRequestDispatcher("/main.jsp").forward(request,response);
	    		}
	    	}
	    	else
	    	{		
	    		ResultSet rs = statement.executeQuery("SELECT COUNT(login) FROM user;");
	    		rs.next();
	    		rs.last();
	    		Integer lastRow = rs.getRow() + 1;
	    		rs.first();
	    		String increment = lastRow.toString();
	    		String values = " VALUES (" + increment + ", ";
	    		values += ("'" + request.getParameter("login") + "', ");
	    		values += ("'" + request.getParameter("password") + "', ");
	    		values += ("'" + request.getParameter("email") + "', ");
	    		values += "'00000', NOW(), TRUE, 0);";
	    		statement.executeUpdate("INSERT INTO user" + values);
	    		strError = "Vous avez bien crée votre compte ARMENIAN SHOP";
	    		HttpSession session = request.getSession();
	    		session.setAttribute("strError", strError);
	    		getServletContext().getRequestDispatcher("/main.jsp").forward(request,response);
	    	}
	    }
        catch(Exception e)
        {
    		e.printStackTrace();
        }
	}
	
	protected boolean checkLogin(HttpServletRequest request, java.sql.Statement statement)
	{
		try
		{
			String login = request.getParameter("login");
			Checks checks = new Checks();
			
			if (checks.isAlphanumeric(login) == false)
				return (false);
			if (login.equals("") == true)
				return (false);
			ResultSet rs = statement.executeQuery("SELECT login FROM user WHERE login='" + login + "';");
			int counter = 0;
			while (rs.next())
				++counter;
			if (counter > 0)
				return (false);
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return (true);
	}
	
	protected boolean checkIfEmail(HttpServletRequest request, java.sql.Statement statement)
	{
		try
		{
			String email = request.getParameter("email");
			Checks checks = new Checks();
			
			if (checks.isAlphanumericWithPointsAt(email) == false)
				return (false);
			if (email.equals("") == true)
				return (false);
			if (this.checkIfEmailIsValid(email) == false)
				return (false);
			ResultSet rs = statement.executeQuery("SELECT login FROM user WHERE email='" + email + "';");
			int counter = 0;
			while (rs.next())
				++counter;
			if (counter > 0)
				return (false);
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return (true);
	}
	
	protected boolean checkIfEmailIsValid(String email)
	{
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(email);
		boolean matchFound = m.matches();
		if (matchFound)
			return (true);
		return (false);
	}
	
	protected boolean checkIfPasswordGood(HttpServletRequest request, java.sql.Statement statement)
	{
		String password = request.getParameter("password");
		String confirmation_password = request.getParameter("password-confirmation");
		Checks checks = new Checks();
		
		if (checks.isAlphanumeric(password) == false)
			return (false);
		if (password.equals("") == true)
			return (false);
		if (password.equals(confirmation_password) == false)
			return (false);
		return (true);
	}
}
