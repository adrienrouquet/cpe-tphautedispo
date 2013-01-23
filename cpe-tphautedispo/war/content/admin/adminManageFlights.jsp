<%@page import="manager.FlightManager"%>
<%@page import="java.util.ArrayList" %>
<%@page import="objects.Flight" %>
<jsp:useBean id="routerBean" class="bean.Router" scope="session" />
<jsp:useBean id="userBean" class="bean.UserBean" scope="session" />
<section>
<form name="mainForm" id="mainForm" action="adminservlet" method="post">
<input type="hidden" name="action" value="manageFlights" />
<input type="hidden" name="userKey" value="" />
<form method="post" name="addFlight" action="adminservlet">
	<hr/>
	Add new Flight :
	<input type="hidden" name="action" value="addFlight" />
	<input placeholder="Departure Airport" type="text" name="flightDepartureAirport">
	<input placeholder="Departure Time (yyyy/mm/dd HH:MM)" type="text" name="flightDepartureTime">
	<input placeholder="Arrival Airport" type="text" name="flightArrivalAirport">
	<input placeholder="Arrival Time (yyyy/mm/dd HH:MM)" type="datetime" name="flightArrivalTime">
	<input placeholder="Seat Price" type="text" name="flightSeatPrice">
	<input placeholder="Available Seats" type="text" name="flightSeatsAvailable">
	<input type="button" value="Add" onclick="setValue('addFlight', 'action', 'addFlight');submitForm('addFlight')">
	<hr/>
</form>
<%
	ArrayList flights = FlightManager.getFlights();
	
	if(flights.size() > 0)
	{
		for(Object obj : flights)
		{
			Flight flight = (Flight) obj;
			String onClickDeleteContent = "setValue('mainForm','action','deleteFlight');setValue('mainForm','flightKey','" + flight.getKeyAsString() + "');submitForm('mainForm');";
%>
<div class="flightWrapperNoHover">
	<div class="flightNumber"><%= flight.getFlightNumber() %></div>
	<div class="flightInfo">
		<span>Departure: </span><%= flight.getDepartureAirport() %> @ <%= flight.getDepartureTimeFormated() %>
	</div>
	<div class="flightInfo">
		<span>Arrival: </span><%= flight.getArrivalAirport() %> @ <%= flight.getArrivalTimeFormated() %>
	</div>
	<div class="flightInfo">
		<span>Price: </span><%= flight.getSeatPrice() %><span> Seats available: </span><%= flight.getAvailableSeats() %>
	</div>
<%-- 	<input type="button" class="imageButton delete floatRight w40 h40" onclick="<%=onClickDeleteContent%>"/> --%>
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