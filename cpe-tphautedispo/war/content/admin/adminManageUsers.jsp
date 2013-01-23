<%@page import="java.util.ArrayList" %>
<%@page import="objects.User" %>
<jsp:useBean id="routerBean" class="bean.Router" scope="session" />
<jsp:useBean id="userBean" class="bean.UserBean" scope="session" />

Souple Airlines
<br />
<br />

<%
	ArrayList<User> users = userBean.getUsers();
	
	if(users.size() > 0)
	{
		for(User user : users)
		{
%>
<div class="userWrapper">
	<div class="userName"><%= user.getName() %></div>
	<div class="userCreationDate"><%= user.getCreationDateFormatted() %></div>
</div>

<%

		}
	}
	else
	{
		out.print("No user to display");
	}
%>