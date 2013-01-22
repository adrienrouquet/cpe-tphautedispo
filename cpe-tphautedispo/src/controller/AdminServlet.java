package controller;

import java.io.IOException;
import javax.servlet.http.*;

import objects.User;

import bean.Router;
import bean.UserBean;

@SuppressWarnings("serial")
public class AdminServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException
	{
		adminRouting(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException
	{
		adminRouting(req, res);
	}

	private void adminRouting(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		UserBean userBean = (UserBean) req.getAttribute("userBean");
		
		User user = userBean.getUser();
		
		if (!user.isAdmin()) {
			res.sendRedirect("AccountServlet");
		}
		
		Router router = (Router) req.getAttribute("routerBean");
		
		switch (router.getAction()) {
		case "manageFlight":
			
			break;

		default:
			break;
		}
	}
}
