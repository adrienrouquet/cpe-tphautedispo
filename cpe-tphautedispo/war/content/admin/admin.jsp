<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="adminRouterBean" class="bean.Router" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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