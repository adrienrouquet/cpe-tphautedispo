package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import objects.User;
//import AppCore.Websocket;
import manager.UserManager;


//@WebServlet("/ChatServlet")
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
		
		//On recupere le chatRouterBean de la session    	
    	bean.Router router 		= (bean.Router) session.getAttribute("routerBean");
    	if(router == null)
    	{
    		System.out.println("Warning: routerBean is null in FlightsServlet");
    		router = new bean.Router();
    		session.setAttribute("chatRouterBean", router);
    	}
    	router.setAction(req.getParameter("action"));
    	
    	
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
	
	
}
