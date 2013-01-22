package controller;

import java.io.IOException;
import javax.servlet.http.*;

public class CoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException
	{
		res.sendRedirect("AccountServlet");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException
	{
		res.sendRedirect("AccountServlet");
	}
}
