package webcalendar.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webcalendar.DefaultController;
import webcalendar.bdo.Calendar;
import webcalendar.bdo.User;
import webcalendar.bro.BROCalendar;
import webcalendar.bro.BROUser;


public class EditUserC extends DefaultController {
	
	public void show(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		Map<String,String> params=createParameters(request);
		showView(response, "EditUser.jsp", params);
	}
	
	public void save(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
				
		//ziskani parametru		
		String userIdParam=request.getParameter("user_id");
		String name=request.getParameter("name");
		String surname=request.getParameter("surname");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		//validace
		
		//ulozeni
		BROUser broUser=new BROUser(getHbSession());
		BROCalendar broCalendar=new BROCalendar(getHbSession());
		
		if (userIdParam!=null && userIdParam.length()>0) {
			//updating			
			User user=broUser.loadUser(Integer.parseInt(userIdParam));
			user.setName(name);
			user.setSurname(surname);
			user.setUserName(username);
			user.setPassword(password);
			broUser.updateUser(user);			
		}
		else {
			//creating new
			User user=new User();						
			user.setName(name);
			user.setSurname(surname);
			user.setUserName(username);
			user.setPassword(password);
			broUser.createUser(user);
			
			Calendar calendar=new Calendar();
			calendar.setVisibilityType(1);
			calendar.setOidUser(user.getOid());
			broCalendar.createCalendar(calendar);
			
		}		
		
		//presmerovani
		redirect(response, "ShowUsersC", null, null);
	}

	public void goBack(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		redirect(response, "ShowUsersC", null, null);
	}

}

