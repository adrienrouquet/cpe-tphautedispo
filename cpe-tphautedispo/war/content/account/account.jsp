<!DOCTYPE html>
<jsp:useBean id="routerBean" class="bean.Router" scope="session" />  
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="style/style.css" />
		<link rel="stylesheet" type="text/css" href="style/account.css" />
		<title>Souple Airlines</title>
		
</head>
	<body>
	<% 
		if( routerBean.getUrl() != "")  
		{
	%>  
		<jsp:include page="<%= routerBean.getUrl() %>" />
	<% 
		}
	%>		
	</body>
</html>
