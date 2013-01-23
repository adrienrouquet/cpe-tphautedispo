package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import manager.FlightManager;
import manager.UserManager;

import objects.Flight;
import objects.User;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private enum Action
	{
		manageFlights,
		manageUsers,
		deleteUser,
		deleteFlight,
		addFlight,
		view
	}
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException
	{
		adminRouting(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException
	{
		adminRouting(req, res);
	}

	private void adminRouting(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession(true);
		
		bean.UserBean userBean = (bean.UserBean) session.getAttribute("userBean");
		
		if (userBean == null || userBean.getUser() == null || !userBean.getUser().isAdmin()) {
			res.sendRedirect("accountservlet");
		}
		
		bean.Router router = (bean.Router) session.getAttribute("adminRouterBean");
		if (router == null) {
			router = new bean.Router();
			session.setAttribute("adminRouterBean", router);
		}
		
		Action actionenum = Action.view;
		String actionstring = req.getParameter("action");
		System.out.println(actionstring);
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
			case manageFlights:
				router.setUrl("adminManageFlights.jsp");
				break;
			case manageUsers:
				router.setUrl("adminManageUsers.jsp");
				break;
			case deleteUser:
				System.out.println("Entering Delete user");
				if(req.getParameter("userKey") != null)
				{
					UserManager.deleteUser(KeyFactory.stringToKey(req.getParameter("userKey")));
				}
				break;
			case deleteFlight:
				System.out.println("Entering Delete Flight");
				if(req.getParameter("flightKey") != null)
				{
					FlightManager.deleteFlight(KeyFactory.stringToKey(req.getParameter("flightKey")));
				}
				break;
			case addFlight:
				System.out.println("Entering Add Flight");
				String departureAirport = req.getParameter("flightDepartureAirport");
				String departureTime = req.getParameter("flightDepartureTime");
				String arrivalAirport = req.getParameter("flightArrivalAirport");
				String arrivalTime = req.getParameter("flightArrivalTime");
				String seatsAvailable = req.getParameter("flightAvailableSeats");
				String seatPrice = req.getParameter("flightSeatPrice");
				
				if (departureAirport!=null && departureTime!=null && arrivalAirport!=null && arrivalTime!=null && seatsAvailable!=null && seatPrice!=null) {
					Flight fl = new Flight(departureAirport, departureTime, arrivalAirport, arrivalTime, seatsAvailable, seatPrice);
					FlightManager.addFlight(fl);
				}
				router.setUrl("adminDefaultView.jsp");
				break;
			case view:
				router.setUrl("adminDefaultView.jsp");
				break;
			default:
				router.setUrl("adminDefaultView.jsp");
				break;
		}		
		
		try {
			RequestDispatcher rd = req.getRequestDispatcher("content/admin/admin.jsp");
			rd.forward(req, res);
		} catch (ServletException e) {
			System.err.println("ERROR IN adminRouting: " + e.getMessage());
		}
	}
}
