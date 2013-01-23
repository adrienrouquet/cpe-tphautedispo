<section>
<form action="adminservlet" method="post" name="mainForm" style="text-align: center;margin: 5%;" >
	<input type="hidden" name="action" value="view"/>
	<input type="button" style="height: 25em; width: 40%;" value="Manage Users" onclick="setValue('mainForm', 'action', 'manageUsers');submitForm('mainForm')"/>
	<input type="button" style="height: 25em; width: 40%;" value="Manage Flights" onclick="setValue('mainForm', 'action', 'manageFlights');submitForm('mainForm')"/>
</form>
</section>
