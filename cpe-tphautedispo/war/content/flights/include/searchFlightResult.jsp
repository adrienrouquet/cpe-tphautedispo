<%@page import="java.util.Vector"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="manager.FlightManager"%>
<%@page import="objects.Flight"%>
<jsp:useBean id="flightBean" class="bean.FlightBean" scope="session" />
<jsp:useBean id="flightRouterBean" class="bean.Router" scope="session" />

<script type="text/javascript" src="script/websocketContact.js"></script>

<h2>Search results</h2>
<form method="post" id="ChooseFlightForm" name="ChooseFlightForm" action="flightsservlet">
	
	<%
		ArrayList<Flight> flights = null;
		
			//On remplit le champ "flightNumber" avec la "searchString" pour effectuer une recherche
			flights = FlightManager.getFlights();
			
			if (flights != null)
			{
				if(flights.size() > 0)
				{
					for(Flight flight : flights)
					{
	%>

					<div id="contactWrapper<%= flight.getKeyAsString()%>" class="contactWrapperNoHover" >
						<div class="selectFlightDisplay">
							Flight #<%= flight.getFlightNumber()%>
							<br />Departure: <%= flight.getDepartureAirport()%> at <%= FlightManager.TimeFormatted(flight.getDepartureTime())%>
							<br />Arrival: <%= flight.getArrivalAirport()%> at <%= FlightManager.TimeFormatted(flight.getArrivalTime())%>
							<br />Available seats: <%= flight.getAvailableSeats().toString()%>
						</div>
<%-- 						<input type="button" class="imageButton add floatRight w40 h40" value="" onclick="setValue('addContactForm','contactId','<%= user.getId() %>');submitForm('addContactForm');"/>	 --%>
					</div>

	<%
					}
				}
			
			}
	%>
</form>