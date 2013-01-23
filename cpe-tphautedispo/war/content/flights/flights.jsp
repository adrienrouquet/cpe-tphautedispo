
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="flightsRouterBean" class="bean.Router" scope="session" />    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Find flights</title>
		<link rel="stylesheet" type="text/css" href="style/style.css" />
		<link rel="stylesheet" type="text/css" href="style/contact.css" />
		<link rel="stylesheet" type="text/css" href="style/chat.css" />
		<script type="text/javascript" src="script/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="script/jquery.validate.min.js"></script>
		<script type="text/javascript" src="script/jquery.defaultvalue.js"></script>
		<script type="text/javascript" src="script/script.js"></script>
		<script type="text/javascript" src="script/websocket.js"></script>
	</head>
	<body>	
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
