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

<script language="javascript" src="js/utils.js"></script>
<script language="javascript" src="js/EditUser.js"></script>


<title>Uzivatel - vytvoreni/editace</title>
</head>
<body>


<h1>Uzivatel - vytvoreni/editace</h1>

<%	
	String userIdParam=request.getParameter("user_id");

	String name="";
	String age="";

	User user;
	if (userIdParam!=null) {
		BROUser broUser = new BROUser(getHbSession());
		user=broUser.loadUser(Integer.parseInt(userIdParam));
		name=user.getName();
		age=String.valueOf(user.getAge());
	}
%>

<form>

	<input type=hidden name='user_id' value='<%=userIdParam!=null ? userIdParam : "" %>' />
	
	<table border=0>
	<tr>
		<td><b>Jmeno</b></td>
		<td><input type=text id="name" name="name" value='<%=name %>'></td>
	</tr>
	<tr>
		<td><b>Vek</b></td>
		<td><input type=text name="age" value='<%=age %>'></td>
	</tr>
	</table>
	
	<p/>
	
	<input type=button value='Ulozit' onclick="submitForm('EditUserC', 'save')">
	<input type=button value='Zpet' onclick="submitForm('EditUserC', 'goBack')">	

</form>	

<script>$("name").focus();</script>

</body>
</html>