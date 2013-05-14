package com.schooltrix.dwr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContextFactory;

public class NotificationGetDWR {

	HttpServletResponse response = WebContextFactory.get().getHttpServletResponse();
	HttpServletRequest request = WebContextFactory.get().getHttpServletRequest();
	HttpSession session = WebContextFactory.get().getSession();		
	
	
	public void getNotifications() {
		
		String UM_ID = (String)session.getAttribute("UM_ID");		
		
		
		
	}
	
	
	
	
	
}
