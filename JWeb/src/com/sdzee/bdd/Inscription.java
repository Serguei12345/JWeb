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
/**
 * Servlet implementation class Inscription
 */
public class Inscription extends HttpServlet {
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
    	try
    	{
			Class.forName("com.mysql.jdbc.Driver");
	    	java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
	    	java.sql.Statement statement = connexion.createStatement();
	    	if (this.checkLogin(request, statement) == false || this.checkIfEmail(request, statement) == false
	    			|| this.checkIfPasswordGood(request, statement) == false)
	    	{
	    		
	    		response.sendRedirect("main.jsp");
	    	}
	    	else
	    	{
	    		ResultSet rs = statement.executeQuery("SELECT COUNT(login) FROM user;");
	    		rs.next();
	    		//rs.get
	    		String values = " VALUES (1, ";
	    		values += ("'" + request.getParameter("login") + "', ");
	    		values += ("'" + request.getParameter("password") + "', ");
	    		values += ("'" + request.getParameter("email") + "', ");
	    		values += "'00000', NOW(), TRUE);";
	    		statement.executeUpdate("INSERT INTO user" + values);
	    	}
	    }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
	}
	
	protected boolean checkLogin(HttpServletRequest request, java.sql.Statement statement)
	{
		try
		{
			String login = request.getParameter("login");
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
			String confirmation_email = request.getParameter("email-confirmation");
			
			if (email.equals("") == true)
				return (false);
			if (this.checkIfEmailIsValid(email) == false)
				return (false);
			if (email.equals(confirmation_email) == false)
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
		
		if (password.equals("") == true)
			return (false);
		if (password.equals(confirmation_password) == false)
			return (false);
		return (true);
	}
}
