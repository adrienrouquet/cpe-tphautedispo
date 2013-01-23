<script>
	
	$.validator.setDefaults({
		success: "valid"
	});
	
	$(document).ready(function() {
		$("#accountSubscribeForm").validate({
			rules: {
				newPassword: {
					required: true,
					minlength: 4
				},
				confirmNewPassword: {
					required: true,
					equalTo: "#newPassword"
				}
			}
		})
	});	
</script>
<div id="container">		
	<header class="noAbsolute">
		<br /><br /><h2>Change your settings</h2>
	</header>
	<section class="noAbsolute">
		<form method="post" action="accountservlet" id="accountSettingsForm">
			<input type="hidden" name="action" value="submitChangeSettings" />
			<% 
			if(request.getParameter("error") != null && request.getParameter("error").contains("wrongOldPassword"))
			{
			%>
			<input type="password" name="oldPassword" placeholder="Enter old password" class="error" />
			<label for="oldPassword" generated="true" class="error">Wrong password, please try again</label>		
			<%
			}
			else
			{
			%>
			<input type="password" name="oldPassword" placeholder="Enter old password" value="<% if(request.getParameter("oldPassword") != null){ out.print(request.getParameter("oldPassword")); } %>"/>
			<%
			}
			%>
			
			<input type="text" id="newPassword" name="newPassword" placeholder="Enter new password" value="<% if(request.getParameter("newPassword") != null){ out.print(request.getParameter("newPassword")); } %>"/>
			<input type="text" id="confirmNewPassword" name="confirmNewPassword" placeholder="Confirm new password" value="<% if(request.getParameter("confirmNewPassword") != null){ out.print(request.getParameter("confirmNewPassword")); } %>"/>
			
			<br />
			<input type="submit" class="button" value="Change Password" />
			<br /><a href="accountservlet?action=redirect"> Back </a>

		</form>
	</section>
</div>
