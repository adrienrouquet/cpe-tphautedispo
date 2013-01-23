<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="manager.UserManager"%>
<%@page import="objects.User"%>
<jsp:useBean id="userBean" class="bean.UserBean" scope="session" />
<%-- <jsp:useBean id="searchUserBean" class="bean.UserBean" scope="session" /> --%>
<jsp:useBean id="flightRouterBean" class="bean.Router" scope="session" />

<!-- <script type="text/javascript" src="script/websocketContact.js"></script> -->
<div id="container">
	<header class="black" style="text-align:center;">
		<form method="post" id="backForm" name="backForm" action="FlightsServlet">
		<input type="hidden" name="action" value="<%=flightRouterBean.getAction()%>" />
		<input type="button" class="imageButton back h50 w50 floatLeft" value="Back" onclick="setValue('backForm','action','backToDefaultView');submitForm('backForm');"/>	
		</form>	
		<h2>
			Search flights
		</h2>
	</header>
	
	<section>
		<h1>Welcome <%= userBean.getFirstName() %> <%= userBean.getLastName() %></h1>
	</section>

<!-- 	<section id="search" class="addContactSection"> -->
<!-- 		<div class="searchForm"> -->
<%-- 			<jsp:include page="include/addContactForm.jsp" /> --%>
<!-- 		</div> -->
		
<!-- 		<div class="searchResult"> -->
<%-- 			<jsp:include page="include/addContactResult.jsp" /> --%>
			
<!-- 		</div> -->
<!-- 	</section> -->
</div>