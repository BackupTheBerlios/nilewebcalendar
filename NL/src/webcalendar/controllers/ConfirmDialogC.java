package webcalendar.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webcalendar.DefaultController;
import webcalendar.bdo.EventGroup;
import webcalendar.bro.BROEventGroup;


public class ConfirmDialogC extends DefaultController {
	

	public void show(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
		Map<String,String> params=createParameters(request);
		showView(response, "ConfirmDialog.jsp", params);						
	}
	
	
	public void goYes(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String url = request.getParameter("url_yes");		
		
		redirect(response, url, "", null);
	}
	
	/*
	public void showAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
				
		redirect(response, "EditUserC", "show", null);
	}	
	
	public void showDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String,String> params=createParameters(request);
		redirect(response, "DeleteUserC", "show", params);
	}*/
		
}
