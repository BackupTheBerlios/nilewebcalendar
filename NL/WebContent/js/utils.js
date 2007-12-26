function $(id) {
  return document.getElementById(id);
}

function submitForm(controller, controllerMethod) {  
  
  	var actionForm = controller + "?" + "$method=" + controllerMethod;
  
	document.forms[0].action = actionForm;
	document.forms[0].method= "post";
	document.forms[0].submit();
}

function navigate(controller, controllerMethod, param1, param2, param3) {  
  
  	var target = controller + "?"; 
  	
  	if (controllerMethod != undefined && controllerMethod != null)
  		target += "$method=" + controllerMethod;
  
  	if (param1 != undefined && param1 != null) target += "&"+param1;
  	if (param2 != undefined && param2 != null) target += "&"+param2;
	if (param3 != undefined && param3 != null) target += "&"+param3;
  
  	window.location = target; 
}
