package webcalendar.controllers;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webcalendar.DefaultController;
import webcalendar.bdo.EventGroup;
import webcalendar.bdo.SharedRights;
import webcalendar.bdo.User;
import webcalendar.bro.BROEventGroup;
import webcalendar.bro.BROUser;

public class SharedEventGroupC extends DefaultController {

	public void show(HttpServletRequest request, HttpServletResponse response)
	throws IOException {

		Map<String,String> params=createParameters(request);
		showView(response, "SharedEventGroup.jsp", params);
	}	
	
	public void addRights(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		
		int eventGroupId=Integer.parseInt(request.getParameter("eventGroup_id"));
		String userName=request.getParameter("userName");
		
		BROEventGroup broEventGroup=new BROEventGroup(getHbSession());
		broEventGroup.addRightsForUser(eventGroupId,userName);	
		
		Map<String,String> params=createParameters();
			
		params.put("eventGroup_id",String.valueOf(eventGroupId));
		showView(response, "SharedEventGroup.jsp", params);
	}	
	
	public void removeUserWithRights (HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		
		//Map<String,String> params2=createParameters(request);
		
		//ziskani parametru
		int userWithRightsId=Integer.parseInt(request.getParameter("userWithRights_id"));
		
		//volani BRO
		BROEventGroup broEventGroup=new BROEventGroup(getHbSession());
		broEventGroup.deleteSharedRights(userWithRightsId);
		
		//presmerovani
		int eventGroupId=Integer.parseInt(request.getParameter("eventGroup_id"));
		
		Map<String,String> params=createParameters();
			
		params.put("eventGroup_id",String.valueOf(eventGroupId));
		showView(response, "SharedEventGroup.jsp", params);
	}
	
	/*public void goBack(HttpServletRequest request, HttpServletResponse response)
	throws IOException {

		redirect(response, "ShowUsersC", null, null);
	}*/	

}
