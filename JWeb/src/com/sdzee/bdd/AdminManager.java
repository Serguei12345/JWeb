package com.sdzee.bdd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("userOfSession");
		if (request.getParameter("admin_begin_submit") != null)
			getServletContext().getRequestDispatcher("/admin.jsp").forward(request,response);
		else if (request.getParameter("write_article_submit_name") != null)
			this.mAdmin.insertArticleInDatabase(request.getParameter("write_article_title_name"), request.getParameter("write_article_text_name"), user);
		else if (request.getParameter("write_review_submit_name") != null)
			this.mAdmin.insertReviewInDatabase(request.getParameter("write_review_title_name"), request.getParameter("write_review_text_name"),
					request.getParameter("write_review_product_name"), user);
		else if (request.getParameter("write_rights_submit") != null)
			this.mAdmin.setRightsOfUser(request.getParameter("write_login_set_name"), request.getParameter("write_rights_set_name"), user);
		else if (request.getParameter("write_product_submit_name") != null)
			this.mAdmin.insertProduct(request.getParameter("write_product_name_set_name"), request.getParameter("write_product_description_set_name"),
					request.getParameter("write_product_price_set_name"), user);
		else if (request.getParameter("go_to_user_name") != null)
		{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user.jsp");
			if (dispatcher == null)
				JOptionPane.showConfirmDialog(null, "Step1");
			dispatcher.forward(request, response);
		}
	}

}
