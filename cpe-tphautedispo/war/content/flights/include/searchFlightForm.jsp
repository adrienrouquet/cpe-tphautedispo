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
		<input placeholder="Leaving from..." type="text" id="searchFrom" name="searchFrom" />
		<input placeholder="Going to..." type="text" id="searchTo" name="searchTo" />
		<input type="button" value="Find Flight" onclick="setValue('mainForm','action','findFlight');submitForm('mainForm');"/>
	</div>
</form>