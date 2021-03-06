package webcalendar.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webcalendar.DefaultController;
import webcalendar.bdo.EventGroup;
import webcalendar.bro.BROEventGroup;


public class EventGroupsManageC extends DefaultController {
	

	public void show(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
		Map<String,String> params=createParameters(request);
		showView(response, "EventGroupsManage.jsp", params);						
	}
	
	
	public void addNewEventGroup(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int calendarOid=Integer.parseInt(request.getParameter("calendar_id"));
		String title=request.getParameter("title");		
		String color=request.getParameter("color");
		
		EventGroup eventGroup = new EventGroup();
		eventGroup.setEnable(true);
		eventGroup.setOidCalendar(calendarOid);
		eventGroup.setOidEventGroup(null);
		eventGroup.setTitle(title);
		eventGroup.setVisible(true);
		eventGroup.setColor(color);
		
		BROEventGroup broEventGroup = new BROEventGroup(getHbSession());		
		broEventGroup.saveEventGroup(eventGroup);
		
		Map<String,String> params=createParameters();		
		params.put("calendar_id", String.valueOf(calendarOid));		
		showView(response, "EventGroupsManage.jsp", params);
	}
	
	
	public void editEventGroup(HttpServletRequest request, HttpServletResponse response) throws IOException {
				
		Map<String,String> params=createParameters(request);
		redirect(response, "EditEventGroupC", null, params);		
	}	
	
	
	public void changeActive(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int calendarOid=Integer.parseInt(request.getParameter("calendar_id"));
		int eventGroupOid=Integer.parseInt(request.getParameter("eventgroup_id"));
		
		System.out.println(">>"+request.getParameter("enabled"));
		boolean enabled=new Boolean(request.getParameter("enabled")).booleanValue();
		
		BROEventGroup broEventGroup = new BROEventGroup(getHbSession());	
		broEventGroup.changeEnabled(eventGroupOid, enabled);
		
		
		Map<String,String> params=createParameters();		
		params.put("calendar_id", String.valueOf(calendarOid));					
		showView(response, "EventGroupsManage.jsp", params);		
	}		
	
	public void shareEventGroup(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String,String> params=createParameters(request);
		redirect(response, "SharedEventGroupC", null, params);		
	}	
	
	/*
	public void showDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String,String> params=createParameters(request);
		redirect(response, "DeleteUserC", "show", params);
	}*/
		
}
