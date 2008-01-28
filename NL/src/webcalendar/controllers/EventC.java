package webcalendar.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.net.ns.RedirectPacket;

import webcalendar.DefaultController;
import webcalendar.bdo.Event;
import webcalendar.bro.BROEvent;
import webcalendar.common.DateTimeUtils;


public class EventC extends DefaultController {
	
	public void show(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		Map<String,String> params=createParameters(request);
		showView(response, "Event.jsp", params);
	}
	
	public void saveEvent(HttpServletRequest request, HttpServletResponse response)
		throws IOException {
		
		//ziskani parametru		
		String calendarIdParam=request.getParameter("calendar_id");
		
		String eventIdParam=request.getParameter("event_id");
		Event event=new Event();
		if (eventIdParam!=null && !eventIdParam.equals("") ) event.setOid(new Integer(eventIdParam));
		event.setTitle(request.getParameter("title"));
		event.setDescription(request.getParameter("description"));
		
		event.setDateTimeFrom(DateTimeUtils.toDate(request.getParameter("dateFrom"), request.getParameter("timeFrom")));
		event.setDateTimeTo(DateTimeUtils.toDate(request.getParameter("dateTo"), request.getParameter("timeTo")));
			
		event.setOidEventGroup(Integer.parseInt(request.getParameter("eventGroupId")));
		
		BROEvent broEvent=new BROEvent(getHbSession());
		broEvent.saveEvent(event);							

		Map<String,String> params=createParameters();
		params.put("calendar_id", calendarIdParam);
		redirect(response, "CalendarC", null, params);
				
	}
	/*
	public void goBack(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		redirect(response, "ShowUsersC", null, null);
	}*/

}

