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
<title>Insert title here</title>
</head>
<body>

<h1>Uzivatele - seznam</h1>

<table border=1>
<tr>
	<td><b>Jmeno</b></td>
	<td><b>Vek</b></td>
</tr>

<%
	
	BROUser broUser = new BROUser(getHbSession());
	
	List<User> users=broUser.loadAllUsers();
	for (User user : users) {
		out.println("<tr>");
		out.println("<td>" + user.getName() + "</td>");
		out.println("<td>" + user.getAge() + "</td>");
		out.println("<td><a href='ShowUsersC?$method=edit&user_id=" + user.getId() + "'>Editovat</a></td>");
		out.println("<td><a href='ShowUsersC?$method=delete&user_id=" + user.getId() + "'>Smazat</a></td>");
		out.println("</tr>");
	}
		
%>

</table>

<p/>

<A HREF="index.jsp">Jit na uvodni stranku</A>


</body>
</html>