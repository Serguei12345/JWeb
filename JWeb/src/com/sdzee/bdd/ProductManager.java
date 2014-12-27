package com.sdzee.bdd;

import java.io.IOException;

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
		else
		{
			User user = new User((User)request.getSession().getAttribute("userOfSession"));
			str = this.isBuyButtonPressed(request);
			if (str.length() > 0)
			{
				this.mPM.buyProductForUser(str, user);
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
