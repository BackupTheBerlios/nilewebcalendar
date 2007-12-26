package webcalendar.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webcalendar.DefaultController;
import webcalendar.bdo.User;
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
		int age=Integer.parseInt(request.getParameter("age"));
		
		//validace
		
		//ulozeni
		BROUser broUser=new BROUser(getHbSession());
		
		if (userIdParam!=null && userIdParam.length()>0) {
			//updating			
			User user=broUser.loadUser(Integer.parseInt(userIdParam));
			user.setName(name);
			user.setAge(age);
			broUser.updateUser(user);			
		}
		else {
			//creating new
			User user=new User();
			user.setName(name);
			user.setAge(age);
			broUser.createUser(user);	
		}		
		
		//presmerovani
		redirect(response, "ShowUsersC", null, null);
	}

	public void goBack(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		redirect(response, "ShowUsersC", null, null);
	}

}
