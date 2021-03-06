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
    
    private enum Action
	{
		defaultView,
		backToDefaultView,
		findFlight
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
			res.sendRedirect("accountservlet");
			return;
		}
    	
		if (!userBean.getUser().isConnected())
			userBean.getUser().connect();
		
		//On recupere le searchFlightBean de la session    
    	bean.FlightBean searchFlightBean	= (bean.FlightBean) session.getAttribute("searchFlightBean");		
		if(searchFlightBean == null || searchFlightBean.getFlight().getKey() == null)
		{
			System.out.println("Warning: searchFlightBean is null in ChatServlet");
			searchFlightBean = new bean.FlightBean();
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
    	
    	Action actionenum = Action.defaultView;
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
		case findFlight:
		{
			// Le searchUserBean est sense etre null avant la recherche
			if (searchFlightBean == null)
			{
				searchFlightBean		=  new bean.FlightBean();				
			}
			String searchFrom 		= req.getParameter("searchFrom").trim();
			String searchTo 		= req.getParameter("searchTo").trim();
			
			searchFlightBean.setDepartureAirport(searchFrom);
			searchFlightBean.setArrivalAirport(searchTo);
			
			session.setAttribute("searchFlightBean", searchFlightBean);
			
			router.setUrl("searchFlights.jsp");	
		}break;
		
		case defaultView:
		{
			searchFlightBean = new bean.FlightBean();
			router.setAction("defaultView");
			router.setUrl("searchFlights.jsp");

		}break;
			
      	default:
    	{
    		searchFlightBean = new bean.FlightBean();
    		router.setAction("defaultView");
			router.setUrl("searchFlights.jsp");
			
    	}break;
		}
		
		rd = req.getRequestDispatcher("/content/flights/flights.jsp");
    	rd.forward(req, res);	
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
