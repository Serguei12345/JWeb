package com.sdzee.bdd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class AdminManager
 */
public class AdminManager extends HttpServlet
{
	private MAdmin mAdmin;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminManager()
    {
        super();
        this.mAdmin = new MAdmin();
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
		if (request.getParameter("admin_begin_submit") != null)
			getServletContext().getRequestDispatcher("/admin.jsp").forward(request,response);
		else if (request.getParameter("write_article_submit_name") != null)
			this.mAdmin.insertArticleInDatabase(request.getParameter("write_article_text_name"), request.getParameter("write_article_title_name"));
	}

}
