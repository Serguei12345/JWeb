package com.sdzee.bdd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class CoreJDBC
 */

public class CoreJDBC extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    private MConnection mc;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public CoreJDBC()
    {
        super();
        mc = new MConnection();
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
		String userLogin = request.getParameter("login");
		String userPwd = request.getParameter("password");
			
		if (this.mc.connectionToDatabase(userLogin, userPwd) == true)
		{
			HttpSession session = request.getSession();
			if (session.getAttribute("MConnection") == null)
				session.setAttribute("MConnection", this.mc);

			if (session.getAttribute("userOfSession") == null)
				session.setAttribute("userOfSession", this.mc.getUser());
			getServletContext().getRequestDispatcher("/user.jsp").forward(request,response);
		}
	}
}
