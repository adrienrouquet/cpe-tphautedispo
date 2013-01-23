package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import objects.User;

public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException
	{
		test(req,res);
		adminRouting(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException
	{
		test(req,res);
		adminRouting(req, res);
	}

	private void adminRouting(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession(true);
		
		bean.UserBean userBean = (bean.UserBean) session.getAttribute("userBean");
		
		if (userBean == null || userBean.getUser() == null || !userBean.getUser().isAdmin()) {
			res.sendRedirect("AccountServlet");
		}
		
		bean.Router router = (bean.Router) session.getAttribute("adminRouterBean");
		
		switch (router.getAction()) {
		case "manageFlight":
			router.setUrl("manageFlight.jsp");
			break;
		case "manageUser":
			router.setUrl("manageUser.jsp");
			break;
		default:
			router.setUrl("index.jsp");
			break;
		}
		
		try {
			RequestDispatcher rd = req.getRequestDispatcher("content/admin/admin.jsp");
			rd.forward(req, res);
		} catch (ServletException e) {
			System.err.println("ERROR IN adminRouting: " + e.getMessage());
		}
	}
	
	private void test(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession(true);
		
		User user = new User();
		user.setFirstName("Adrien");
		user.setLastName("ROUQUET");
		user.setRightTypeId(1);
		
		bean.UserBean userBean = new bean.UserBean();
		userBean.setUser(user);
		session.setAttribute("userBean", userBean);
		session.setAttribute("adminRouterBean", new bean.Router());
	}
}
