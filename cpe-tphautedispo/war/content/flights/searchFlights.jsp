<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="manager.FlightManager"%>
<%@page import="objects.Flight"%>
<jsp:useBean id="searchFlightBean" class="bean.FlightBean" scope="session" />
<jsp:useBean id="userBean" class="bean.UserBean" scope="session" />
<jsp:useBean id="flightRouterBean" class="bean.Router" scope="session" />

<!-- <script type="text/javascript" src="script/websocketContact.js"></script> -->
<div id="container">
	<section id="search" class="searchFlightSection">
		<h2>SearchFlights</h2>
		<div class="searchForm">
			<jsp:include page="include/searchFlightForm.jsp" />
		</div>
		
		<div class="searchResult">
			<jsp:include page="include/searchFlightResult.jsp" />
			
		</div>
	</section>
</div>