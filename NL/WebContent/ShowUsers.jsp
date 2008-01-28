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

<title>Spr�va u�ivatel�</title>

<script language="javascript" src="js/utils.js"></script>

</head>
<body>

<h1>Spr�va u�ivatel�</h1>


<table border=1 cellspacing=0 cellpadding=2>
	<tr bgcolor=#cccccc>
		<td><b>Jm�no</b></td>
		<td><b>P��jmen�</b></td>
		<td><b>P�ihla�ovac� jm�no</b></td>
		<td colspan=2>&nbsp;</td>
	</tr>

	<%
	
	BROUser broUser = new BROUser(getHbSession());
	
	List<User> users=broUser.loadAllUsers();
	
	for (User user : users) {
		out.println("<tr>");
		out.println("<td>" + user.getName() + "</td>");
		out.println("<td>" + user.getSurname() + "</td>");
		out.println("<td>" + user.getUserName() + "</td>");		
		out.println("<td>");
		out.println("<input type=button value='Upravit' onclick=\"navigate('ShowUsersC', 'showEdit',   'user_id=" + user.getOid() + "');\" >");
		out.println("<input type=button value='Smazat'  onclick=\"navigate('ShowUsersC', 'showDelete', 'user_id=" + user.getOid() + "');\" >");		
		out.println("</td>");
		out.println("</tr>");
	}
		
	%>

</table>

<p/>

<input type="button" value="P�idat u�ivatele" onclick="navigate('ShowUsersC', 'showAdd');" />
<input type="button" value="Zp�t" onclick="navigate('LoginC');" />

</body>
</html>