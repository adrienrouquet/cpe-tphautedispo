<%@page import="java.util.Vector"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="manager.FlightManager"%>
<%@page import="objects.Flight"%>
<%@page import="java.util.Date"%>
<jsp:useBean id="flightBean" class="bean.FlightBean" scope="session" />
<jsp:useBean id="flightRouterBean" class="bean.Router" scope="session" />

<script type="text/javascript" src="script/websocketContact.js"></script>

<h2>Search results</h2>
<form method="post" id="ChooseFlightForm" name="ChooseFlightForm" action="flightsservlet">
	
	<%
		ArrayList flights = null;
		
			//On remplit (pas encore) le champ "flightNumber" avec la "searchString" pour effectuer une recherche
			flights = FlightManager.getFlights();
			
			if(flights.size() > 0)
			{
	%>
		<table>
			<tr>
				<td>Date</td>
				<td>Departure time</td>
				<td>Arrival time</td>
				<td>Flight duration</td>
				<td>Available seats</td>
				<td>Price</td>
			</tr>
	<%
				for(Object obj : flights)
				{
					Flight flight = (Flight) obj;
					Date departureTime = flight.getDepartureTime();
					Date arrivalTime = flight.getArrivalTime();
	%>
			<tr>
				<td><%= FlightManager.getDay(departureTime)%></td>
				<td><%= FlightManager.getTime(departureTime)%></td>
				<td><%= FlightManager.getDayAndTime(arrivalTime)%></td>
				<td></td>
				<td><%= flight.getAvailableSeats().toString()%></td>
				<td><%= flight.getSeatPrice().toString()%> Euros</td>
			</tr>

	<%
				}
	%>
		</table>
	<%
			}
			else
			{
				out.print("No flight matches your search");
			}
	%>
</form>