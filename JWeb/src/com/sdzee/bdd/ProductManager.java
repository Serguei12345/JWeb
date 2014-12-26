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
		this.mPM.searchProducts();
		HttpSession session = request.getSession();
		if (session.getAttribute("MProductManager") == null)
			session.setAttribute("MProductManager", this.mPM);
		getServletContext().getRequestDispatcher("/products.jsp").forward(request,response);
	}

}
