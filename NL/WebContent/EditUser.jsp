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


<title>Insert title here</title>
</head>
<body>


<h1>Uzivatel - editace</h1>

<%	
	String userIdParam=request.getParameter("user_id");

	User user;
	if (userIdParam!=null) {
		BROUser broUser = new BROUser(getHbSession());
		user=broUser.loadUser(Integer.parseInt(userIdParam));
	}
	else {
		user = new User();
	}
%>

<form id="mainform" action='EditUserC' method='get'>

<input type=hidden name='user_id' value='<%=userIdParam %>' />

<table border=1>
<tr>
	<td><b>Jmeno</b></td>
	<td><input type=text name="name" value='<%=user.getName() %>'></td>
</tr>
<tr>
	<td><b>Vek</b></td>
	<td><input type=text name="vek" value='<%=user.getAge() %>'></td>
</tr>
</table>

<p/>

<a href="javascript:if (isFormValid()) submitForm(mainform, 'EditUserC', 'save');" >Ulozit</a>
<a href="javascript:submitForm(mainform, 'EditUserC', 'goBack');" >Zpet</a>
<a href="javascript:mainform.submit()" >Zpetka</a>

<input type=submit name="tlac" value='chacha'>
</form>
	


</body>
</html>