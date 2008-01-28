<%@ page language="java" extends="webcalendar.DefaultJSP" 
	contentType="text/html; charset=windows-1250" pageEncoding="windows-1250"%>
    
<jsp:directive.page import="org.hibernate.*" />
<jsp:directive.page import="java.util.*" />
<jsp:directive.page import="webcalendar.bro.*" />
<jsp:directive.page import="webcalendar.bdo.*" />
<jsp:directive.page import="webcalendar.common.*" />    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<title>Sdíleni skupiny událostí</title>

<script language="javascript" src="js/utils.js"></script>

</head>
<body>

<h1>Sdílení skupiny událostí</h1>

<%		
	int eventGroupId=Integer.parseInt(request.getParameter("eventGroup_id"));	
	int calendarId=Integer.parseInt(request.getParameter("calendar_id"));	
%>

<form>

	<input type=hidden name='eventGroup_id' value='<%=eventGroupId %>' />
	<input type=hidden name='calendar_id' value='<%=calendarId %>' />
	
	<table border=0>
	<tr>
		<td><b>Uživatelské jméno</b></td>
		<td><input type=text id="userName" name="userName" /></td>		
		<td><input type=button value='Pøidat' onclick="submitForm('SharedEventGroupC', 'addRights')" /></td>
	</tr>	
	</table>	
	<p/>
	
	
	<table border=1 cellspacing=0 cellpadding=2>
	<tr bgcolor=lightgray>		
		<td><b>Uživatelské jméno</b></td>
		<td><b>Jméno</b></td>
		<td><b>Pøíjmení</b></td>
		<td colspan=2>&nbsp;</td>
	</tr>
	
<%


	BROEventGroup broEventGroup = new BROEventGroup(getHbSession());
	EventGroup eventGroup = broEventGroup.loadEventGroup(eventGroupId);
	List<SharedRights> sharedRightss = eventGroup.getSharedRightss();		
	
	for (SharedRights sharedRights : sharedRightss) {
		out.println("<tr>");
		out.println("<td>" + sharedRights.getUser().getUserName() + "</td>");
		out.println("<td>" + sharedRights.getUser().getName() + "</td>");
		out.println("<td>" + sharedRights.getUser().getSurname() + "</td>");
		out.println("<td>");
		out.println("<input type=button value='Zrušit sdílení'  onclick=\"submitForm('SharedEventGroupC', 'removeUserWithRights', 'userWithRights_id=" + sharedRights.getOid() + "');\" >");		
		out.println("</td>");
		out.println("</tr>");
	}
		
	%>

</table>
<p/>	
	
	<input type="button" value="Zpìt" onclick="submitForm('SharedEventGroupC','goBack');" />
	
	</form>

</body>
</html>