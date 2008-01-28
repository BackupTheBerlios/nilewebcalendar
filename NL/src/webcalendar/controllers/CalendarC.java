package webcalendar.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.NavigationFilter;

import webcalendar.DefaultController;
import webcalendar.bdo.EventGroup;
import webcalendar.bro.BROEventGroup;


public class CalendarC extends DefaultController {
	
	//TODO udelat konstanty pro vsechny kalendare a jspcka (components :)

	public void show(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
		Map<String,String> params=createParameters(request);
		showView(response, "Calendar.jsp", params);						
	}
	
	public void addEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String,String> params=createParameters(request);
		redirect(response, "EventC", null, params);
	}
	
	public void manageEventGroups(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String,String> params=createParameters(request);
		redirect(response, "EventGroupsManageC", null, params);
	}	
	
	
	/*
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
	}*/
	
	/*
	public void showAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
				
		redirect(response, "EditUserC", "show", null);
	}	
	
	public void showDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String,String> params=createParameters(request);
		redirect(response, "DeleteUserC", "show", params);
	}*/
		
}
