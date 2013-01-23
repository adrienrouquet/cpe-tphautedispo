
<script>
	
	$.validator.setDefaults({
		success: "valid"
	});
	
	$(document).ready(function() {
		$("#accountLoginForm").validate({
			rules: {
				login: {
					required: true,
					minlength: 4
				},
				password: {
					required: true,
					minlength: 4
				}
			}
		})
	});	

	
</script>
<div id="container">
	<header>
		<div id="bigLogoLabel"></div>
	</header>
	<section class="login">
		<% 
			if(request.getParameter("valid") != null && request.getParameter("valid").contains("subscribe"))
			{
		%>
		<div class="valid" style="display: inline-block;">Account created Successfully</div>		
		<%
			}
		%>
		<form method="post" id="accountLoginForm" action="accountservlet">
			<input type="hidden" name="action" value="login"/>
			<input placeholder="Enter Login..." type="text" id="login" name="login"/>
			<input placeholder="Enter Password..." type="password" id="password" name="password"/>
			<input type="submit" class="button" value="Login" />
			<br /><a href="accountservlet?action=subscribe"> Sign up </a>
			<br /><br /><br />
		</form>
	</section>
</div>