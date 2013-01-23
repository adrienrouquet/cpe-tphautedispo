package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.UserManager;
import objects.User;

public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccountServlet() throws SQLException {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		System.out.println("AccountServlet: Entering doGet");
		
		accountRouting(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		System.out.println("AccountServlet: Entering doPost");
		
		accountRouting(req,res);
	}
	
	protected void accountRouting(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session 	= req.getSession(true);
		RequestDispatcher rd 	= null;
		
		//On recupere le routerBean de la session
		bean.Router router 	= (bean.Router) session.getAttribute("routerBean");
		if(router == null)
		{
			System.out.println("Warning: routerBean is null in AccountServlet");
    		router = new bean.Router();
			session.setAttribute("routerBean", router);
		}
		
		//On recupere le UserBean de la session
		bean.UserBean userBean 			= (bean.UserBean) session.getAttribute("userBean");		
		if(userBean == null)
		{
			System.out.println("Warning: userBean is null in AccountServlet");
			userBean	=  new bean.UserBean();
			session.setAttribute("userBean", userBean);
		}
		
		if(req.getParameter("action") != null)
		{
			Action actionenum = Action.login;
			String actionstring = req.getParameter("action");
			
			for(Action a : Action.values())
			{
				if (a.toString().equalsIgnoreCase(actionstring))
				{
					actionenum = a;
					break;
				}
			}
			
			switch(actionenum)
			{
				case login:
				{
					System.out.println("AccountServlet: Checking User credentials");
						
					String login 		= req.getParameter("login").trim().toLowerCase();
					String password 	= req.getParameter("password").trim();
					
					if (UserManager.checkCredentials(login,password))
					{
						System.out.println("AccountServlet: Connecting user");
						//On recupere le user de la database et on le set dans un bean session
						
						User user = UserManager.getUserFromCredentials(login, password);
						user.connect();
						
						userBean.setUser(user);
						session.setAttribute("userBean", userBean);
						session.setAttribute("routerBean", new bean.Router());
						System.out.println("AccountServlet: UserId " + userBean.getKey() + " is now connected");
						if(user.isAdmin())
						{
							res.sendRedirect("adminservlet");
						}
						else
						{
							res.sendRedirect("flightsservlet");
						}
						return;
					}
					else
					{
						System.out.println("AccountServlet: Wrong credentials");
						//Par defaut, on forward sur accountLogin.jsp
						router.setUrl("accountLogin.jsp");
						rd = req.getRequestDispatcher("/content/account/account.jsp");
						rd.forward(req, res);
					}
				}break;
				case logout:
				{
					System.out.println("AccountServlet: Logout action received");
					session.setAttribute("userBean", null);
					session.setAttribute("RouterBean", null);
					session.invalidate();
					req.getSession(true);
					res.sendRedirect("accountservlet");
				}break;
				case subscribe:
				{
					router.setUrl("accountSubscribe.jsp");
					rd = req.getRequestDispatcher("/content/account/account.jsp");
					rd.forward(req, res);
				}break;
				case submitSubscribe:
				{
					String firstName	= req.getParameter("firstName").trim().toLowerCase();
					String lastName		= req.getParameter("lastName").trim().toLowerCase();
					
					Integer yearOfBirth	= Integer.parseInt(req.getParameter("yearOfBirth").trim().toLowerCase());
					String email		= req.getParameter("email").trim().toLowerCase();
					String login 		= req.getParameter("login").trim().toLowerCase();
					String password 	= req.getParameter("password").trim();
					
					String errors 		= UserManager.userExists(email,login);
					
					if(errors.equals(""))
					{
						UserManager.addUser(firstName, lastName, yearOfBirth, email, login, password);
						router.setUrl("accountLogin.jsp?valid=subscribe");
					}
					else
					{
						router.setUrl("accountSubscribe.jsp?error="+errors);						
					}
					rd = req.getRequestDispatcher("/content/account/account.jsp");
					rd.forward(req, res);
				}break;
				
				default:
				{
					
				}break;				
			}
		}
		else
		{
			//Par defaut, on forward sur accountLogin.jsp
			router.setUrl("accountLogin.jsp");
			rd = req.getRequestDispatcher("content/account/account.jsp");
			rd.forward(req, res);
		}
	}
	
	private enum Action
	{
		login,
		logout,
		subscribe,
		submitSubscribe
	}
}
