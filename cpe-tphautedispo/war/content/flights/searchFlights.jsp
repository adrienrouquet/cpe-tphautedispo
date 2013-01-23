<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="manager.FlightManager"%>
<%@page import="objects.Flight"%>
<jsp:useBean id="flightBean" class="bean.FlightBean" scope="session" />
<%-- <jsp:useBean id="searchUserBean" class="bean.UserBean" scope="session" /> --%>
<jsp:useBean id="flightRouterBean" class="bean.Router" scope="session" />

<!-- <script type="text/javascript" src="script/websocketContact.js"></script> -->
<div id="container">
	<header class="black" style="text-align:center;">
		<form method="post" id="backForm" name="backForm" action="flightsservlet">
		<input type="hidden" name="action" value="<%=flightRouterBean.getAction()%>" />
		<input type="button" class="imageButton back h50 w50 floatLeft" value="" onclick="setValue('backForm','action','DefaultView');submitForm('backForm');"/>	
		</form>	
		<h2>
			Search flights
		</h2>
	</header>

	<section id="search" class="searchFlightSection">
		<div class="searchForm">
			<jsp:include page="include/searchFlightForm.jsp" />
		</div>
		
		<div class="searchResult">
			<jsp:include page="include/searchFlightResult.jsp" />
			
		</div>
	</section>
</div>