package webcalendar.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webcalendar.DefaultController;
import webcalendar.bdo.User;
import webcalendar.bro.BROUser;


public class LoginC extends DefaultController {
	
	//TODO udelat konstanty pro vsechny kalendare a jspcka (components :)

	public void show(HttpServletRequest request, HttpServletResponse response) throws IOException {
					
		logout(request,response);				
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		
		BROUser broUser = new BROUser(getHbSession());
		boolean authenticated = broUser.checkAuthentication(login,password);
		
		if (authenticated) {			
			
			User user = broUser.getUserByUserName(login);
						
			request.getSession().setAttribute("user_id", user.getOid());
			request.getSession().setAttribute("calendar_id", user.getCalendar().getOid());
			
			redirect(response, "EditEventGroupC", null, null);
		}
		else {
			Map<String,String> params=createParameters(request);
			params.put("mode", "authentication_error");
			showView(response, "Login.jsp", params);
		}
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("user_id");
		request.getSession().removeAttribute("calendar_id");
		showView(response, "Login.jsp", null);
	}
	
	public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String,String> params=createParameters(request);
		redirect(response, "EventGroupsManageC", null, params);
	}	
		
}
