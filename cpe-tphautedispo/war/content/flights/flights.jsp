
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="flightRouterBean" class="bean.Router" scope="session" />    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Find flights</title>
	</head>
	<body>	
	<div id="logoBGContainer"></div>	
	<% 
		if( flightRouterBean.getUrl() != "")  
		{
	%>  
		<jsp:include page="<%= flightRouterBean.getUrl() %>" />
	<% 
		}
	%>
	</body>
</html>
