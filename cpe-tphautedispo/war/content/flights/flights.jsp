
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="flightsRouterBean" class="bean.Router" scope="session" />  
<jsp:useBean id="userBean" class="bean.UserBean" scope="session" />    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Find flights</title>
		<link rel="stylesheet" type="text/css" href="style/style.css" />
		<script type="text/javascript" src="script/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="script/jquery.validate.min.js"></script>
		<script type="text/javascript" src="script/jquery.defaultvalue.js"></script>
		<script type="text/javascript" src="script/script.js"></script>
	</head>
	<body>	
	<header>
		<div class="floatRight">
			<div class="floatRight">
				<h3 style="display:inline;"><%=userBean.getName() %></h3>
				<form action="accountservlet" id="logoutForm" name="logoutForm" method="post">
					<input type="hidden" name="action" value="logout" />
					<input type="button" class="imageButton logout floatRight w40 h40" onclick="submitForm('logoutForm');" />
				</form>
				<form action="accountservlet" id="settingsForm" name="settingsForm" method="post">
					<input type="hidden" name="action" value="changeSettings" />
					<input type="button" class="imageButton settings floatRight w40 h40" onclick="submitForm('settingsForm');" />
				</form>
			</div>
		</div>
	</header>
	<div id="logoBGContainer"></div>	
	<% 
		if( flightsRouterBean.getUrl() != "")  
		{
	%>  
		<jsp:include page="<%= flightsRouterBean.getUrl() %>" />
	<% 
		}
	%>
	</body>
</html>
