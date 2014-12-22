package com.sdzee.bdd;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class CoreJDBC
 */
public class CoreJDBC extends HttpServlet
{
	ArrayList<ArrayList<String>> listOfArticles;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public ArrayList<ArrayList<String>> getListOfArticles()
	{
		return (this.listOfArticles);
	}
	
    public CoreJDBC()
    {
        super();
        this.listOfArticles = new ArrayList<ArrayList<String>>();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
        	java.sql.Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
        	java.sql.Statement statement = connexion.createStatement();
        	
        	String userLogin = request.getParameter("login");
        	String userPwd = request.getParameter("password");
        	ResultSet rs = statement.executeQuery("SELECT login, password FROM user WHERE login='" + userLogin + "' AND password='" + userPwd + "';");
        	
        	if (rs.next() == true)
        	{
        		request.setAttribute("coreUser", this);
        		getServletContext().getRequestDispatcher("/user.jsp").forward(request,response);
        		JOptionPane.showConfirmDialog(null, "USER CONFIRME");
        		this.articleActions(statement, rs);
        	}
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
	}
	
	protected void articleActions(java.sql.Statement statement, ResultSet rs) throws Exception
	{
		String str = "";
		
		listOfArticles.clear();
		ArrayList<String> elemsToAdd = new ArrayList<String>();
		rs = statement.executeQuery("SELECT title, text, image, date_edit FROM article ORDER BY date_edit DESC;");
		while (rs.next() == true)
		{
			elemsToAdd.clear();
			elemsToAdd.add(rs.getString("title"));
			elemsToAdd.add(rs.getString("text"));
			elemsToAdd.add(rs.getString("image"));
			Date dateToAdd = rs.getDate("date_edit");
			elemsToAdd.add(dateToAdd.toString());
			JOptionPane.showConfirmDialog(null, str);
			listOfArticles.add(elemsToAdd);
		}
		JOptionPane.showConfirmDialog(null, str);
	}
}
