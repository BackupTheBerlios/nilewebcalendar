<%@ page language="java" contentType="text/html; charset=Windows-1250"
	pageEncoding="Windows-1250"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Index page</title>
</head>
<body>

<h1>Testovaci rozcestnik</h1> 

<table border=1>
<tr>
<td><a href='EventGroupsManageC?calendar_id=1'>Sprava skupin (calendar_id=1)</a></td>
<td></td>
</tr>
<tr>
<td><a href='ShowUsersC'>Uzivatele (seznam, pridani, smazani)</a></td>
<td>ShowUsers.jsp</td>
</tr>
<tr>
<td><a href='ShowUsers_own_conn.jsp'>Uzivatele (seznam) - nezdedeno z DefaultJSPPage</a></td>
<td>ShowUsers_own_conn.jsp</td>
</tr>
<tr>
<td><a href='EditEventGroupC?eventGroup_id=1'>Uprava uzivatelske skupiny</a></td>
<td>EditEventGroup.jsp</td>
</tr>
<tr>
<td><a href='SharedEventGroupC?eventGroup_id=1'>Prideleni prav</a></td>
<td>SharedEventGroup.jsp</td>
</tr>
</table>

 

</body>
</html>