<%@page import="bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="userBean" class="bean.UserBean" scope="session" />
<jsp:useBean id="adminRouterBean" class="bean.Router" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="script/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="script/script.js"></script>
<title>Souple Airlines - Admin</title>
</head>
<body>
	<header>
		<div style="float: left; display: block;">
			<div>Souple Airlines</div>
			<div>Admin</div>
		</div>
		<div style="float: right; display: block;">
			<div><%=userBean.getName() %></div>
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
</body>
</html>