<%@page import="manager.FlightManager"%>
<%@page import="java.util.ArrayList" %>
<%@page import="objects.Flight" %>
<jsp:useBean id="routerBean" class="bean.Router" scope="session" />
<jsp:useBean id="userBean" class="bean.UserBean" scope="session" />
<section>
<form name="mainForm" id="mainForm" action="adminservlet" method="post">
<input type="hidden" name="action" value="manageUsers" />
<input type="hidden" name="userKey" value="" />
<%
	ArrayList flights = FlightManager.getFlights();
	
	if(flights.size() > 0)
	{
		for(Object obj : flights)
		{
			Flight flight = (Flight) obj;
			String onClickDeleteContent = "setValue('mainForm','action','deleteFlight');setValue('mainForm','userKey','" + flight.getKeyAsString() + "');submitForm('mainForm');";
%>
<div class="userWrapper">
	<div class="userName"><%= flight.getFlightNumber() %></div>
	<div class="userCreationDate"><%= flight.getDepartureAirport() %></div>
	<div class="userCreationDate"><%= flight.getDepartureTime() %></div>
	<div class="userCreationDate"><%= flight.getArrivalAirport() %></div>
	<div class="userCreationDate"><%= flight.getArrivalTime() %></div>
	<div class="userCreationDate"><%= flight.getAvailableSeats() %></div>
	<div class="userCreationDate"><%= flight.getSeatPrice() %></div>
	<input type="button" class="imageButton delete floatRight w40 h40" onclick="<%=onClickDeleteContent%>"/>
</div>
<%

		}
	}
	else
	{
		out.print("No flight to display");
	}
%>
</form>
</section>