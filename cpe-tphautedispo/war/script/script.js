$(document).ready(function() {


	function submitForm(pForm)
	{
		document.forms[pForm].submit();
	}
	function setValue(pForm, pElement, pValue)
	{
		document.forms[pForm].elements[pElement].value = pValue;		
	}
	
	function initGlobal() {
		window.setValue = setValue;
		window.submitForm = submitForm;
	}
	
	(function() {
//		init();
		initGlobal();
	})();

});