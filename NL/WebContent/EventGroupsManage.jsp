<%@ page language="java" extends="webcalendar.DefaultJSP"
	contentType="text/html; charset=Windows-1250" pageEncoding="Windows-1250"%>

<jsp:directive.page import="org.hibernate.*" />
<jsp:directive.page import="java.util.*" />
<jsp:directive.page import="webcalendar.bro.*" />
<jsp:directive.page import="webcalendar.bdo.*" />
<jsp:directive.page import="webcalendar.common.*" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
 
<title>Nastavení skupin událostí</title>

<script language="javascript" src="js/utils.js"></script>
<script language="javascript" src="js/colorpicker.js"></script>
<link rel="stylesheet" href="css/colorpicker.css" type="text/css">

</head>
<body>

<h1>Nastavení skupin událostí</h1>

<form>

<input type="hidden" name="calendar_id" value="<%=request.getParameter("calendar_id") %>" />

<hr/>

<b>Vlastní skupiny</b>

<table border=0>
<tr>
	<td>Nová skupina</td>
	<td><input type="input" name="title" value=""></td>
	<td>
		<div style="width:43px;width/* */:/**/40px;width: /**/40px;height:20px;border:1px solid #7F9DB9;">		
			<input type="hidden" name="color">
			<input type="button" disabled='true' style="width:23px;font-size:12px;height:20px;float:left;border:0px;padding-top:2px" name="rgb" size="10">
			<img style="float:right;padding-right:1px;padding-top:1px" src="images/select_arrow.gif" 
				onmouseover="this.src='images/select_arrow_over.gif'" 
				onmouseout="this.src='images/select_arrow.gif'" 
				onclick="showColorPicker(this,colorChanged)">
			<script>
				colorChanged('skyblue'); //default color
				function colorChanged(color) {
					$('rgb').style.backgroundColor=color;
					$('color').value=color;
				}
			</script>			
		</div>
	</td>											
	<td><input type="button" value="Pøidat" onclick="submitForm('EventGroupsManageC', 'addNewEventGroup');"></td>
</tr>
</table>



<table border=1 cellspacing=0 cellpadding=2>
	<tr bgcolor=#cccccc>
		<td><b>Název</b></td>
		<td><b>Barva</b></td>
		<td><b>Aktivní</b></td>
		<td colspan=2>&nbsp;</td>
	</tr>

	<%
	
	
	int calendar_id = Integer.parseInt(request.getParameter("calendar_id"));	
	
	BROEventGroup broEventGroup = new BROEventGroup(getHbSession());
	
	List<EventGroup> groups=broEventGroup.loadEventGroupsForCalendar(calendar_id);
	
	for (EventGroup group : groups) {
		
		if (group.getOidEventGroup()==null) {
		
			%>
			
			<tr>
			<td><%=group.getTitle() %></td>
			<td></td>
			<td>
				<input type=checkbox 
				    checked=<%= group.getEnable() %>
					onclick="submitForm('EventGroupsManageC', 'changeActive', 'checked='+this.checked, 'group_id=<%=group.getOid() %>')" />		
			</td>

			<td><input type=button value='Upravit' onclick="navigate('EventGroupsManageC', 'editGroup',   'group_id=<%=group.getOid() %>');" >
			<td><input type=button value='Smazat'  onclick="navigate('EventGroupsManageC', 'deleteGroup', 'group_id=<%=group.getOid() %>');" >		
			<td><input type=button value='Sdílet'  onclick="navigate('EventGroupsManageC', 'shareGroup',  'group_id=<%=group.getOid() %>');" >
			
			</tr>
			<%
		
		}
	}
		
	%>

</table>

<hr/>

<b>Skupiny nasdílené dalšími uživateli</b>

<p/>

<input type="button" value="Zpìt" onclick="navigate('index.jsp');" />


</form>

</body>
</html>