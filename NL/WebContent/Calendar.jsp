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
		
		String currentDateParam=request.getParameter("currentDate");
		Date currentDate=currentDateParam!=null ? DateTimeUtils.toDate(currentDateParam,"00:00") : new Date();
	
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
	
		<input type=text name='currentDate'  style="width:75px" value='<%=DateTimeUtils.toStringDate(currentDate) %>' />
		<input type=button value="Zobrazit" />
	
		<hr/>
		
		<input type=button value='Správa skupin' onclick="submitForm('CalendarC','manageEventGroups')" />
		<input type=button value='Pøidat událost' onclick="submitForm('CalendarC','addEvent')" />
		<input type=button value="Rozcestnik" onclick="submitForm('index.jsp');" />
		
	</div>

	<div id="center" >
	
		<form> 			
			
			<% 				
				Date tempDate=DateTimeUtils.getStartOfWeekDate(currentDate);
				BROEvent broEvent=new BROEvent(getHbSession());

				out.println("<table border=1 width=* >");
				out.println("<tr>");	
				String[] daysArray=new String[] {"Pondìlí","Úterý","Støeda","Ètvrtek","Pátek","Sobota","Nedìle"}; 
				
				for (int i=0; i<7; i++) {
					
					tempDate.setDate(tempDate.getDate()+1);
					
					out.println("<td width=150px><b>");					
					out.println(daysArray[i]);
					out.println("</b><br>");
					out.println(DateTimeUtils.toStringDate(tempDate));
					out.println("</td>");
				}
				
				tempDate=DateTimeUtils.getStartOfWeekDate(currentDate);
				out.println("</tr>");
				
				out.println("<tr>");	
				
				for (int i=0; i<7; i++) {
					
					out.println("<td>");	
					
					tempDate.setDate(tempDate.getDate()+1);
					
					List<Event> events=broEvent.loadEventsForCalendarAndDate(calendarId, tempDate);
					
					for (Event event:events) {
					
						if (event.getEventGroup().getVisible()&&event.getEventGroup().getEnable()) {
						
							out.println("<span style='background: "+event.getEventGroup().getColor()+"'><b>"
									+ DateTimeUtils.toStringTime(event.getDateTimeFrom())
									+ "-"+DateTimeUtils.toStringTime(event.getDateTimeTo()) 
									+ "</b><br/>");
							out.println(event.getTitle()+"</span><p/>");						
						}
					}
					
					out.println("<br></td>");
				}				
				
				out.println("</tr>");	
				out.println("</table>");	
			%>		
										
			
		</form>
	</div>

	</div> 
	
</form>
</div> 
	

</body>
</html>