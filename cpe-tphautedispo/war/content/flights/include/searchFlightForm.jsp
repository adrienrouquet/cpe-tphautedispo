<script>
	
	$.validator.setDefaults({
		success: "valid"
	});
	
	$(document).ready(function() {
		$("#mainForm").validate({
			rules: {
				searchString: {
					minlength: 3
				}				
			}
		});
	});		
</script>

<form name="mainForm" id="mainForm" method="post" action="flightsservlet">
	<div class="flightName">
		<input type="hidden" name="action" value="view"/>
		<input placeholder="Search a flight..." type="text" id="searchString" name="searchString" />
		<input type="button" value="Find Flight" onclick="setValue('mainForm','action','findFlight');submitForm('mainForm');"/>
	</div>
</form>