<%@ page language="java" extends="webcalendar.DefaultJSP" 
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<jsp:directive.page import="org.hibernate.*" />
<jsp:directive.page import="java.util.*" />
<jsp:directive.page import="webcalendar.bro.*" />
<jsp:directive.page import="webcalendar.bdo.*" />
<jsp:directive.page import="webcalendar.common.*" />    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Uzivatelska skupina - uprava</title>

<script language="javascript" src="js/utils.js"></script>

</head>
<body>

<h1>Uzivatelska skupina - uprava</h1>

<%	
	
	String eventGroupIdParam=request.getParameter("eventGroup_id");
	
	String title="";
	String color="";

	EventGroup eventGroup;
	if(eventGroupIdParam!=null) {
		BROEventGroup broEventGroup = new BROEventGroup(getHbSession());
		eventGroup=broEventGroup.loadEventGroup(Integer.parseInt(eventGroupIdParam));		
		title=eventGroup.getTitle();
		color=eventGroup.getColor();
	}	
	
%>

<form>

	<input type=hidden name='eventGroup_id' value='<%=eventGroupIdParam %>' />
	
	<table border=0>
	<tr>
		<td><b>Nazev uzivatelske skupiny</b></td>
		<td><input type=text id="title" name="title" value='<%=title %>'></td>
	</tr>
	<tr>
		<td><b>Barva</b></td>
		<td><input type=text name="color" value='<%=color %>'></td>
	</tr>
	</table>	
	<p/>
	

	<input type=button value='Ulozit' onclick="submitForm('EditEventGroupC', 'update')">
	<input type="button" value="Rozcestnik" onclick="submitForm('index.jsp');" />

</form>	

</body>
</html>