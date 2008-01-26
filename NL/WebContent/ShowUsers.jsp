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
<title>Uzivatele - seznam</title>

<script language="javascript" src="js/utils.js"></script>

</head>
<body>

<h1>Uzivatele - seznam</h1>


<table border=1 cellspacing=0 cellpadding=2>
	<tr bgcolor=lightgray>
		<td><b>Jmeno</b></td>
		<td><b>Prijmeni</b></td>
		<td><b>Uzivatelske jmeno</b></td>
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

<input type="button" value="Rozcestnik" onclick="navigate('index.jsp');" />

<input type="button" value="Pridat uzivatele" onclick="navigate('ShowUsersC', 'showAdd');" />

</body>
</html>