<%@page import="java.util.ArrayList" %>
<%@page import="objects.User" %>
<jsp:useBean id="routerBean" class="bean.Router" scope="session" />
<jsp:useBean id="userBean" class="bean.UserBean" scope="session" />

Souple Airlines
<br />
<br />
<form name="mainForm" id="mainForm" action="adminservlet" method="post">
<input type="hidden" name="action" value="manageUsers" />
<input type="hidden" name="userKey" value="" />
<%
	ArrayList<User> users = userBean.getUsers();
	
	if(users.size() > 0)
	{
		for(User user : users)
		{
			String onClickDeleteContent = "setValue('mainForm','action','deleteUser');setValue('mainForm','userKey','" + user.getKeyAsString() + "');submitForm('mainForm');";
%>
<div class="userWrapper">
	<div class="userName"><%= user.getName() %></div>
	<div class="userCreationDate"><%= user.getCreationDateFormated() %></div>
	<input type="button" class="imageButton delete floatRight w30 h30" onclick="<%=onClickDeleteContent%>"/>
</div>

<%

		}
	}
	else
	{
		out.print("No user to display");
	}
%>
</form>
