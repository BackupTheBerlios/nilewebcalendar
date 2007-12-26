package webcalendar.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webcalendar.DefaultController;
import webcalendar.bdo.User;
import webcalendar.bro.BROUser;


public class DeleteUserC extends DefaultController {
	
	public void show(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		Map<String,String> params=createParameters(request);
		showView(response, "DeleteUser.jsp", params);
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
				
		//ziskani parametru
		int userId=Integer.parseInt(request.getParameter("user_id"));
		
		//volani BRO
		BROUser broUser=new BROUser(getHbSession());
		User user=broUser.loadUser(userId);
		broUser.deleteUser(user);		
		
		//presmerovani
		redirect(response, "ShowUsersC", null, null);
	}

	public void goBack(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		redirect(response, "ShowUsersC", null, null);
	}

}
