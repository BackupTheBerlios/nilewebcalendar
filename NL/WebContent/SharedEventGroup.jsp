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

<title>Sdileni uzivatelske skupiny ...</title>

<script language="javascript" src="js/utils.js"></script>

</head>
<body>

<h1>Sdileni uzivatelske skupiny ...</h1>

<%		
	String eventGroupIdParam=request.getParameter("eventGroup_id");	
	String userName="";	
%>

<form>

	<input type=hidden name='eventGroup_id' value='<%=eventGroupIdParam %>' />
	
	<table border=0>
	<tr>
		<td><b>Uzivatel</b></td>
		<td><input type=text id="userName" name="userName" value='<%=userName%>'></td>
		<td><input type=button value='Pridat' onclick="submitForm('SharedEventGroupC', 'addRights')"></td>
	</tr>	
	</table>	
	<p/>
	
	
	<table border=1 cellspacing=0 cellpadding=2>
	<tr bgcolor=lightgray>		
		<td><b>Uzivatelske jmeno</b></td>
		<td colspan=2>&nbsp;</td>
	</tr>
	
<%
	
	BROEventGroup broEventGroup = new BROEventGroup(getHbSession());
	List<SharedRights> rights = broEventGroup.loadAllUsersWithRights();
	
	for (SharedRights userWithRights : rights) {
		out.println("<tr>");
		out.println("<td>" + userWithRights.getUser().getName() + "</td>");
		out.println("<td>");
		out.println("<input type=button value='Smazat'  onclick=\"submitForm('SharedEventGroupC', 'removeUserWithRights', 'userWithRights_id=" + userWithRights.getOid() + "');\" >");		
		out.println("</td>");
		out.println("</tr>");
	}
		
	%>

</table>
<p/>	
	
	<input type="button" value="Rozcestnik" onclick="submitForm('index.jsp');" />
	
	</form>

</body>
</html>