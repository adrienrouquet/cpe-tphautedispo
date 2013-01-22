<!DOCTYPE html>
<jsp:useBean id="accountRouterBean" class="Bean.Router" scope="session" />  
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width initial-scale=1.0; maximum-scale=1.0;" />
		<link rel="stylesheet" type="text/css" href="style/style.css" />
		<link rel="stylesheet" type="text/css" href="style/account.css" />
		<title>Super Messenger</title>
		<script type="text/javascript" src="script/jquery-1.8.3.js" ></script>
		<script type="text/javascript" src="script/jquery.validate.min.js"></script>
		<script type="text/javascript" src="script/jquery.defaultvalue.js"></script>
		
		
</head>
	<body>
	<% 
		if( accountRouterBean.getUrl() != "")  
		{
	%>  
		<jsp:include page="<%= accountRouterBean.getUrl() %>" />
	<% 
		}
	%>		
	</body>
</html>
