package com.sdzee.bdd;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ArticlesReviews
 */
public class ArticlesReviews extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	MArticlesReviews mAR;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticlesReviews()
    {
        super();
        this.mAR = new MArticlesReviews();
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
		if (request.getParameter("reviews_submit") != null)
		{
			this.mAR.searchReviews();
			HttpSession session = request.getSession();
			if (session.getAttribute("MArticlesReviews") == null)
				session.setAttribute("MArticlesReviews", this.mAR);
			getServletContext().getRequestDispatcher("/reviews.jsp").forward(request,response);
		}
		else if (request.getParameter("articles_submit") != null)
		{
			this.mAR.searchArticles();
			HttpSession session = request.getSession();
			if (session.getAttribute("MArticlesReviews") == null)
				session.setAttribute("MArticlesReviews", this.mAR);
			getServletContext().getRequestDispatcher("/articles.jsp").forward(request,response);
		}
	}
}
