<!DOCTYPE html>
<jsp:useBean id="routerBean" class="bean.Router" scope="session" />  
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="style/style.css" />
		<link rel="stylesheet" type="text/css" href="style/account.css" />
		<script type="text/javascript" src="script/jquery-1.8.3.js" ></script>
		<script type="text/javascript" src="script/jquery.validate.min.js"></script>
		<script type="text/javascript" src="script/jquery.defaultvalue.js"></script>
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
