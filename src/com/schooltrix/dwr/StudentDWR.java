package com.schooltrix.dwr;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContextFactory;

import com.schooltrix.daos.StudentDetailsDAO;
import com.schooltrix.hibernate.StudentxlErrorTemp;
import com.schooltrix.managers.ServiceFinder;

public class StudentDWR {

	HttpServletResponse response = WebContextFactory.get().getHttpServletResponse();
	HttpServletRequest request = WebContextFactory.get().getHttpServletRequest();
	HttpSession session = WebContextFactory.get().getSession();
	
	public List getErrorMsg() {
		
		 StudentDetailsDAO studentDetailsDao = (StudentDetailsDAO)ServiceFinder.getContext(request).getBean("StudentDetailsDAO");
		 String um_id = (String)session.getAttribute("UM_ID");
		 System.out.println("um_id---"+um_id);
		 List errorLog  = null;
		 List<Object[]> errorList= new ArrayList<Object[]>();
		 try {
			errorLog = studentDetailsDao.getStudentErrorLog(um_id);	
		 
			System.out.println("** size"+errorLog.size());
					for (int i = 0; i < errorLog.size(); i++) {
						String[] oioio = new String[2];
						StudentxlErrorTemp ioio = (StudentxlErrorTemp)errorLog.get(i);
						System.out.println("--error line---"+ioio.getErrorline());
						oioio[0] = ioio.getErrorline();
						oioio[1] = ioio.getReason();
						errorList.add(oioio);
					}
		return errorList;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}
	
}
