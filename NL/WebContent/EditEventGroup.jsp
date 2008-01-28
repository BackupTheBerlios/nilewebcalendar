<%@ page language="java" extends="webcalendar.DefaultJSP" 
	contentType="text/html; charset=ISO-8859-1" pageEncoding="windows-1250"%>
    
<jsp:directive.page import="org.hibernate.*" />
<jsp:directive.page import="java.util.*" />
<jsp:directive.page import="webcalendar.bro.*" />
<jsp:directive.page import="webcalendar.bdo.*" />
<jsp:directive.page import="webcalendar.common.*" />    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1250">

<title>Úprava skupiny událostí</title>

<script language="javascript" src="js/utils.js"></script>
<script language="javascript" src="js/colorpicker.js"></script>
<link rel="stylesheet" href="css/colorpicker.css" type="text/css">

</head>
<body>

<h1>Úprava skupiny událostí</h1>

<%	
	
	int eventGroupId=Integer.parseInt(request.getParameter("eventGroup_id"));	
	int calendarId=Integer.parseInt(request.getParameter("calendar_id"));

	BROEventGroup broEventGroup = new BROEventGroup(getHbSession());
	EventGroup eventGroup=broEventGroup.loadEventGroup(eventGroupId);		
	String title=eventGroup.getTitle();
	String color=eventGroup.getColor();
	
%>

<form>

	<input type=hidden name='eventGroup_id' value='<%=eventGroupId %>' />
	<input type=hidden name='calendar_id' value='<%=calendarId %>' />
	
	<table border=0>
	<tr>
		<td><b>Nazev uzivatelske skupiny</b></td>
		<td><input type=text id="title" name="title" value='<%=title %>'></td>
	</tr>
	<tr>
		<td><b>Barva</b></td>
		<td>		
			<div style="width:43px;width/* */:/**/40px;width: /**/40px;height:20px;border:1px solid #7F9DB9;">		
				<input type="hidden" name="color" />
				<input type="button" disabled='true' style="float:left;width:23px;height:20px;" name="rgb" size="10" />
				<img style="float:right;padding-right:1px;padding-top:1px" src="images/select_arrow.gif" 
					onmouseover="this.src='images/select_arrow_over.gif'" 
					onmouseout="this.src='images/select_arrow.gif'" 
					onclick="showColorPicker(this,colorChanged)" />
				<script>
					colorChanged('<%=color %>'); //default color
					function colorChanged(color) {
						$('rgb').style.backgroundColor=color;
						$('color').value=color;
					}
				</script>			
			</div>				
		</td>
	</tr>
	</table>	
	<p/>
	

	<input type=button value='Ulozit' onclick="submitForm('EditEventGroupC', 'update')">
	<input type="button" value="Rozcestnik" onclick="submitForm('EditEventGroupC', 'goBack');" />

</form>	

</body>
</html>