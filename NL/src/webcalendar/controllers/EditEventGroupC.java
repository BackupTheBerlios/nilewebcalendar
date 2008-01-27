package webcalendar.controllers;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webcalendar.DefaultController;
import webcalendar.bdo.EventGroup;
import webcalendar.bro.BROEventGroup;

public class EditEventGroupC extends DefaultController {

	public void show(HttpServletRequest request, HttpServletResponse response)
	throws IOException {

		Map<String,String> params=createParameters(request);
		showView(response, "EditEventGroup.jsp", params);
	}	
	
	public void update(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		
		String eventGroupIdParam=request.getParameter("eventGroup_id");
		String title=request.getParameter("title");
		String color=request.getParameter("color");

		//validace

		//update
		BROEventGroup broEventGroup=new BROEventGroup(getHbSession());
		

		EventGroup eventGroup=broEventGroup.loadEventGroup(Integer.parseInt(eventGroupIdParam));
		eventGroup.setTitle(title);
		eventGroup.setColor(color);
		broEventGroup.updateEventGroup(eventGroup);		
			
		//presmerovani
		//redirect(response, "ShowUsersC", null, null);
	}
	
	/*public void goBack(HttpServletRequest request, HttpServletResponse response)
	throws IOException {

		redirect(response, "ShowUsersC", null, null);
	}*/	

}
