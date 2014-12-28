package com.sdzee.bdd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductManager
 */
public class ProductManager extends HttpServlet
{
	private MProductManager mPM;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductManager()
    {
        super();
        this.mPM = new MProductManager();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String str = "";
		String strError = "";
		if (request.getParameter("products_submit") != null)
		{
			this.mPM.searchProducts();
			HttpSession session = request.getSession();
			if (session.getAttribute("MProductManager") == null)
				session.setAttribute("MProductManager", this.mPM);
			getServletContext().getRequestDispatcher("/products.jsp").forward(request,response);
		}
		else if (request.getParameter("bought_products_submit_name") != null)
		{
			HttpSession session = request.getSession();
			User user = new User((User)session.getAttribute("userOfSession"));
			this.mPM.searchBoughtProducts(user);
			if (session.getAttribute("MProductManager") == null)
				session.setAttribute("MProductManager", this.mPM);
			getServletContext().getRequestDispatcher("/boughtProducts.jsp").forward(request,response);
		}
		else if (request.getParameter("go_to_user_name") != null)
		{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user.jsp");
			if (dispatcher != null)
				dispatcher.forward(request, response);
			return ;
		}
		else
		{
			User user = new User((User)request.getSession().getAttribute("userOfSession"));
			str = this.isBuyButtonPressed(request);
			str = str.substring(7, str.length());
			str = this.mPM.buyItemFindNameOfProductById(str);
			if (str.length() > 0)
			{
				int res = this.mPM.buyProductForUser(str, user);
				this.mPM.searchProducts();
				HttpSession session = request.getSession();
				
				if (session.getAttribute("MProductManager") == null)
					session.setAttribute("MProductManager", this.mPM);
				if (res == 0)
					strError = "L'achat s'est bien déroulé";
				else if (res == 1)
					strError = "Le produit est en rupture de stock";
				else if (res == 2)
					strError = "Vous n'avez pas assez de crédit";
				else if (res == 3)
					strError = "Le nom de ce produit n'est pas valide";
				
				session.setAttribute("userOfSession", user);
				session.setAttribute("strError", strError);
				getServletContext().getRequestDispatcher("/products.jsp").forward(request,response);
			}
		}
		
	}

	String isBuyButtonPressed(HttpServletRequest request)
	{
		Integer counter = 0;
		
		while (counter < 1000)
		{
			if (request.getParameter("product" + counter.toString()) != null)
				return ("product" + counter.toString());
			++counter;
		}
		return ("");
	}
}
