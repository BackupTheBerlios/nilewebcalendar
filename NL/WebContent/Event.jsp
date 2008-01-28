<%@ page language="java" extends="webcalendar.DefaultJSP" 
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<jsp:directive.page import="org.hibernate.*" />
<jsp:directive.page import="java.util.*" />
<jsp:directive.page import="webcalendar.bro.*" />
<jsp:directive.page import="webcalendar.bdo.*" />
<jsp:directive.page import="webcalendar.common.*" />    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="webcalendar.bdo.Calendar"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Udalost</title>

<script language="javascript" src="js/utils.js"></script>

</head>
<body>

<h1>Vytvoreni / uprava udalosti</h1>

<%		
	int calendarId=Integer.parseInt(request.getParameter("calendar_id"));
	String eventIdParam=request.getParameter("event_id");
	String currentDateParam=request.getParameter("currentDate");

	
	Event event;	
	
	if(eventIdParam!=null){
		
		//rezim uprava		
		BROEvent broEvent = new BROEvent (getHbSession());
		event=broEvent.loadEvent(Integer.parseInt(eventIdParam));
	}
	else{
		//rezim noveho zadavani		
		
		Date now=new Date();
		
		Date dateTimeFrom=currentDateParam!=null ? DateTimeUtils.toDate(currentDateParam, "00:00") : now;
		dateTimeFrom.setHours(now.getHours());
		dateTimeFrom.setMinutes(0);
		Date dateTimeTo=new Date(dateTimeFrom.getTime());
		dateTimeTo.setHours(dateTimeTo.getHours()+1);
		
		
		event=new Event();
		event.setTitle("");
		event.setDescription("");
		event.setOidEventGroup(null);
		event.setDateTimeFrom(dateTimeFrom);
		event.setDateTimeTo(dateTimeTo);		
	}
	
%>

<form>

	<input type=hidden name='calendar_id' value='<%=calendarId%>' />
	<input type=hidden name='event_id' value='<%=eventIdParam!=null ? eventIdParam : ""%>' />
		
	<table border=0>
	<tr>
		<td>Skupina udalosti:</td>
		<td>
			<select name='eventGroupId'>
			<%		
			
				BROCalendar broCalendar= new BROCalendar(getHbSession());
				webcalendar.bdo.Calendar calendar=broCalendar.loadCalendar(calendarId);
				
				//ziska vsechny groupy pro kalendar
				List<EventGroup> eventGroups=calendar.getEventGroups();
				
				for (EventGroup eventGroup : eventGroups) {		
					
					if (eventGroup.getOidEventGroup() == null){		
						
						out.println("<option value="+eventGroup.getOid() + " ");
						if (new Integer(eventGroup.getOid()).equals(event.getOidEventGroup())) {
							out.println("selected");
						}							
								
						out.println(">" + eventGroup.getTitle() + "</option>");					
					}
				}
			
			%>				
			</select></td>		
	</tr>	
	<tr>
		<td>Nazev:</td>
		<td><input type=text id="title" name="title" value='<%=event.getTitle()%>'></td>
	</tr>
	<tr>
		<td>Popis:</td>
		<td><textarea id="description" name="description" value='<%=event.getDescription()%>' rows="10" cols="30"></textarea></td>				
	</tr>	
	<tr>
		<td>Datum od:</td>
		<td><input type=text id="dateFrom" name="dateFrom" value='<%=DateTimeUtils.toStringDate(event.getDateTimeFrom())%>'></td>
		<td>Cas od:</td>
		<td><input type=text id="timeFrom" name="timeFrom" value='<%=DateTimeUtils.toStringTime(event.getDateTimeFrom())%>'></td>				
	</tr>
	<tr>
		<td>Datum do:</td>
		<td><input type=text id="dateTo" name="dateTo" value='<%=DateTimeUtils.toStringDate(event.getDateTimeTo())%>'></td>
		<td>Cas do:</td>
		<td><input type=text id="timeTo" name="timeTo" value='<%=DateTimeUtils.toStringTime(event.getDateTimeTo())%>'></td>			
	</tr>
	</table>	
	<p/>
	
	<input type=button value='Uloz'  onclick="submitForm('EventC', 'saveEvent')"/>
	<input type="button" value="Rozcestnik" onclick="submitForm('index.jsp');" />

	</form>	

</body>
</html>