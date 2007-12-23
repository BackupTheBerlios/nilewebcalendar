package webcalendar.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webcalendar.DefaultController;


public class ShowUsersC extends DefaultController {
	

	public void show(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		showView(response, "ShowUsers.jsp", null);						
	}
	
	public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String,String> params=createResponseParameters(request);
		redirect(response, "EditUserC", null, params);
	}
		
}
