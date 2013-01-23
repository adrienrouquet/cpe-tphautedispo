package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import objects.User;
import manager.UserManager;

public class FlightsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FlightsServlet() {
        super();        
    }
    
    private void routing(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
    	HttpSession session 	= req.getSession(true);
    	RequestDispatcher rd 	= null;
    	    	
    	//On recupere le userBean de la session    
    	bean.UserBean userBean	= (bean.UserBean) session.getAttribute("userBean");		
		if(userBean == null || userBean.getUser().getKey() == null)
		{
			System.out.println("Warning: userBean is null in ChatServlet");
			res.sendRedirect("AccountServlet");
			return;
		}
    	
		if (!userBean.getUser().isConnected())
			userBean.getUser().connect();
		
		//On recupere le searchBean de la session    
    	bean.UserBean searchBean	= (bean.UserBean) session.getAttribute("searchBean");		
		if(searchBean == null || searchBean.getUser().getKey() == null)
		{
			System.out.println("Warning: searchBean is null in ChatServlet");
			searchBean = new
		}
		
		//On recupere le flightsRouterBean de la session    	
    	bean.Router router 		= (bean.Router) session.getAttribute("flightsRouterBean");
    	if(router == null)
    	{
    		System.out.println("Warning: flightsRouterBean is null in FlightsServlet");
    		router = new bean.Router();
    		session.setAttribute("flightsRouterBean", router);
    	}
    	router.setAction(req.getParameter("action"));
    	
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
		switch(router.getAction())
		{
	      	default:
	    	{
//	    		router.setAction("DefaultView");
//	    		router.setUrl("contactWindow.jsp");
//	    		rd = req.getRequestDispatcher("content/chat/chat.jsp");
	    	}break;
		}
		
//    	rd.forward(req, res);	
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		System.out.println("User Entering ChatServlet.doGet");
		routing(req, res);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		System.out.println("ChatServlet: Entering doPost");
		routing(req, res);
	}
	
	private enum Action
	{
		defaultView
	}
}
