<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="manager.UserManager"%>
<%@page import="AppCore.User"%>
<jsp:useBean id="userBean" class="bean.UserBean" scope="session" />
<jsp:useBean id="searchUserBean" class="bean.UserBean" scope="session" />
<jsp:useBean id="chatRouterBean" class="bean.Router" scope="session" />

<script type="text/javascript" src="script/websocketContact.js"></script>
<div id="container">
	<header class="black" style="text-align:center;">
		<form method="post" id="backForm" name="backForm" action="ChatServlet">
		<input type="hidden" name="action" value="<%=chatRouterBean.getAction()%>" />
		<input type="button" class="imageButton back h50 w50 floatLeft" value="" onclick="setValue('backForm','action','backToContactView');submitForm('backForm');"/>	
		</form>	
		<h2>
			Find Contact
		</h2>
	</header>

	<section id="search" class="addContactSection">
		<div class="searchForm">
			<jsp:include page="include/addContactForm.jsp" />
		</div>
		
		<div class="searchResult">
			<jsp:include page="include/addContactResult.jsp" />
			
		</div>
	</section>
</div>