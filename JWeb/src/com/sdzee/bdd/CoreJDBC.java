package com.sdzee.bdd;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class CoreJDBC
 */
public class CoreJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoreJDBC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
        	java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
        	java.sql.Statement statement = connexion.createStatement();
        	
        	String userLogin = request.getParameter("login");
        	String userPwd = request.getParameter("password");
        	ResultSet rs = statement.executeQuery("SELECT login, password FROM user WHERE login='" + userLogin + "' AND password='" + userPwd + "';");
        	
        	if (rs.next() == true)
        		JOptionPane.showConfirmDialog(null, "USER CONFIRME");
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
	}

}
