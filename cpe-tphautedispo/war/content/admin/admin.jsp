<%@page import="bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="userBean" class="bean.UserBean" scope="session" />
<jsp:useBean id="adminRouterBean" class="bean.Router" scope="session" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="style/style.css" />
	<link rel="stylesheet" type="text/css" href="style/admin.css" />		
	<script type="text/javascript" src="script/jquery-1.8.3.js" ></script>
	<script type="text/javascript" src="script/script.js"></script>
	
	<title>Souple Airlines - Admin</title>
</head>
<body>
	<div id="container">
	<header>
		<div style="float: left; display: block;">
			<div><h2 style="display:inline;">Souple Airlines</h2></div>
			<div><h3 style="display:inline;">Admin</h3></div>
		</div>
		<div class="floatRight">
			<div class="floatRight">
				<h3 style="display:inline;"><%=userBean.getName() %></h3>
				
				<form action="accountservlet" id="logoutForm" name="logoutForm" method="post">
					<input type="hidden" name="action" value="logout" />
					<input type="button" class="imageButton logout floatRight w40 h40" onclick="submitForm('logoutForm');" />
				</form>
			</div>
		</div>
		<hr style="clear: both;"/>
	</header>
	<% 
		if( adminRouterBean.getUrl() != "")  
		{
	%>
		<jsp:include page="<%= adminRouterBean.getUrl() %>" />
	<%
		}
	%>
	</div>
</body>
</html>