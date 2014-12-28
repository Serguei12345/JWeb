package com.sdzee.bdd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String strError = "";
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("userOfSession");
		if (user == null)
			strError = "Erreur interne";
		else
		{
			if (request.getParameter("admin_begin_submit") != null)
			{
				getServletContext().getRequestDispatcher("/admin.jsp").forward(request,response);
				return ;
			}
			else if (request.getParameter("write_article_submit_name") != null)
			{
				if (this.mAdmin.insertArticleInDatabase(request.getParameter("write_article_title_name"), request.getParameter("write_article_text_name"), user) == false)
					strError = "Echec de l'insertion de l'article dans la BDD";
			}
			else if (request.getParameter("write_review_submit_name") != null)
			{
				if (this.mAdmin.insertReviewInDatabase(request.getParameter("write_review_title_name"), request.getParameter("write_review_text_name"), request.getParameter("write_review_product_name"), user) == false)
					strError = "Echec de l'insertion du review dans la BDD";
			}			
			else if (request.getParameter("write_rights_submit") != null)
			{
				if (this.mAdmin.setRightsOfUser(request.getParameter("write_login_set_name"), request.getParameter("write_rights_set_name"), user) == false)
				strError = "Echec de changement des droits de l'utilisateur dans la BDD";
			}
			else if (request.getParameter("write_credit_submit") != null)
			{
				if (this.mAdmin.setCreditsOfUser(request.getParameter("write_login_set_name"), request.getParameter("write_credit_set_name"), user) == false)
					strError = "Echec du changement du montant de l'utilisateur dans la BDD";
			}
			else if (request.getParameter("write_product_quantity_submit_name") != null)
			{
				if (this.mAdmin.setQuantityOfProduct(request.getParameter("write_product_name_set_name"), request.getParameter("write_product_quantity_set_name"), user) == false)
					strError = "Echec du changement de la quantité du produit dans la BDD";
			}
			else if (request.getParameter("write_product_submit_name") != null)
			{
				if (this.mAdmin.insertProduct(request.getParameter("write_product_name_set_name"), request.getParameter("write_product_description_set_name"), request.getParameter("write_product_price_set_name"), user) == false)
					strError = "Echec de l'insertion du produit dans la BDD";
			}
			else if (request.getParameter("go_to_user_name") != null)
			{
				session.setAttribute("userOfSession", user);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user.jsp");
				if (dispatcher != null)
					dispatcher.forward(request, response);
				return ;
			}
			if (strError == "")
				strError = "L'opération a été accomplie avec succès";
		}
		session.setAttribute("userOfSession", user);
		session.setAttribute("strError", strError);
		getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
	}
}
