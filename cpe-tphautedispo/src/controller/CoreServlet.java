package controller;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class CoreServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException
	{
		res.sendRedirect("AccountServlet");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException
	{
		res.sendRedirect("AccountServlet");
	}
}
