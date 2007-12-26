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
	
	public void showEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String,String> params=createParameters(request);
		redirect(response, "EditUserC", "show", params);
	}
	
	public void showAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
				
		redirect(response, "EditUserC", "show", null);
	}	
	
	public void showDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String,String> params=createParameters(request);
		redirect(response, "DeleteUserC", "show", params);
	}	
		
}
