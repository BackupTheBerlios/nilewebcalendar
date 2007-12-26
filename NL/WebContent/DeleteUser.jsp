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


<title>Uzivatel - smazani</title>
</head>
<body>


<h1>Uzivatel - smazani</h1>

<%	
	String userIdParam=request.getParameter("user_id");

	BROUser broUser = new BROUser(getHbSession());
	User user=broUser.loadUser(Integer.parseInt(userIdParam));
%>

<form>

	<input type=hidden name='user_id' value='<%=userIdParam %>' />
	
	Opravdu smazat uzivatele <%=user.getName() %> ? 
	
	<p/>
	
	<input type="button" value="Smazat" onclick="submitForm('DeleteUserC', 'delete');" />
	<input type="button" value="Zpet"   onclick="submitForm('DeleteUserC', 'goBack');" />

</form>


</body>
</html>