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
	<meta http-equiv="Content-Type" content="text/html; Windows-1250">
		
	<script language="javascript" src="js/utils.js"></script>
	<link rel="stylesheet" href="css/global.css" type="text/css">
	
	<title>P�ihl�en�</title>	
</head>

<body>
	
<div id="page"> 

<form>
	
	<p/><p/>
	
	
	<table>
		<tr>
			<td>P�ihla�ovac� jm�no</td>
			<td><input type=text name='login'></td>
		</tr>
		<tr>
			<td>Heslo</td>
			<td><input type=password name='password'></td> 
		</tr>
	</table>
	
	<input type=button value="P�ihl�sit" onclick="submitForm('LoginC','login');" />
	
	<p/>
	
	<%	
		String mode=request.getParameter("mode");
		if ("authentication_error".equals(mode)) {
			out.println("<p style='color:red'>Neplatn� p�ihla�ovac� �daje</p>");
		}
	
	%>	
	
	<p/>
	<p/>
	<a href="">Registrace nov�ho u�ivatele</a> 
	<p/>
	<a href='ShowUsersC'>Administrace u�ivatel� (jen pro administr�tora)</a>
	
	
</form>

</div> 
	

</body>
</html>