<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="adminRouterBean" class="bean.Router" scope="session" />
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="style/style.css" />
		<link rel="stylesheet" type="text/css" href="style/admin.css" />
		<script type="text/javascript" src="script/script.js" ></script>
		<script type="text/javascript" src="script/jquery-1.8.3.js" ></script>
		<script type="text/javascript" src="script/jquery.validate.min.js"></script>
		<script type="text/javascript" src="script/jquery.defaultvalue.js"></script>
		
		<title>Souple Airlines - Admin</title>
	</head>
<body>
<% 
	if( adminRouterBean.getUrl() != "")  
	{
%>
	<jsp:include page="<%= adminRouterBean.getUrl() %>" />
<%
	}
%>
</body>
</html>