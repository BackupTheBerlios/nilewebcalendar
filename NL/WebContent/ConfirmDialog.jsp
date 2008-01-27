<%@ page language="java" extends="webcalendar.DefaultJSP"
	contentType="text/html; charset=Windows-1250" pageEncoding="Windows-1250"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
 
<title>Potvrzení</title>

<script language="javascript" src="js/utils.js"></script>

</head>
<body>

<h1>Otázka</h1>

<p/>

<b><%=request.getParameter("message") %></b>

<input type=hidden name=url_yes value="<%=request.getParameter("url_yes") %>" />
<input type=hidden name=url_no  value="<%=request.getParameter("url_no") %>" />

<form>

	<input type="button" value="Ano" onclick="submitForm('ConfirmDialogC', 'goYes');">
	<input type="button" value="Ne" onclick="submitForm('ConfirmDialogC', 'goNo');" />

</form>

</body>
</html>