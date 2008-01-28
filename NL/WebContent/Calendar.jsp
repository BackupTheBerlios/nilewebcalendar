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
	
	<title>Kalendáø</title>	
</head>

<body>

	<%		
		int calendarId=Integer.parseInt(request.getParameter("calendar_id"));	
		
		BROCalendar broCalendar=new BROCalendar(getHbSession());
		webcalendar.bdo.Calendar calendar=broCalendar.loadCalendar(calendarId);
			
		User user=calendar.getUser();
	
	%>
	
<div id="page"> 

<form>

	<input type=hidden name='calendar_id' value='<%=calendarId %>' />

	<!-- page header -->
	<div id="pageheader">
		<table width=100% border=0>
		<tr> 
			<td width=*><B>NiLe WebCalendar</B></td>
			<td align=right>
				<a href=''><%=user.getName()+" "+user.getSurname() + "("+ user.getUserName() +")" %></a>
				<a href='LoginC'>Odhlásit</a>			
			</td>
		</tr>
		</table>
	</div> 

	<div id="header" >
	Kalendar
	</div>	
		

	<!-- page content -->
	<div id="pagecontent"> 	
	
	<div id="left" >
	
		<input type=text name='date' value='' style="width:75px" />
		<input type=button name='' value='->' />
	
		<hr/>
		
		<input type=button value='Správa skupin' onclick="submitForm('CalendarC','manageEventGroups')" />
		<input type=button value='Pøidat událost' onclick="submitForm('CalendarC','addEvent')" />
		<input type=button value="Rozcestnik" onclick="submitForm('index.jsp');" />
		
	</div>

	<div id="center" >
	
		<form> 			
		
			
			<table border=1 width=* >
			<tr>
				<td>Pondeli</td>
				<td>Utery</td>
				<td>Streda</td>
				<td>Ctvrtek</td>
				<td>Patek</td>
				<td>Sobota</td>
				<td>Nedela</td>
			</tr>		
			</table>							
			
		</form>
	</div>

	</div> 
	
</form>
</div> 
	

</body>
</html>