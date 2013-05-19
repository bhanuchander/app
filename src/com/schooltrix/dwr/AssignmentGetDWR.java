package com.schooltrix.dwr;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContextFactory;
import org.springframework.beans.BeansException;

import com.schooltrix.daos.UploadDocDAO;
import com.schooltrix.hibernate.StudentDetails;
import com.schooltrix.managers.ServiceFinder;
import com.schooltrix.utils.StudentDetailsAnalysis;

public class AssignmentGetDWR {

	HttpServletResponse response = WebContextFactory.get().getHttpServletResponse();
	HttpServletRequest request = WebContextFactory.get().getHttpServletRequest();
	HttpSession session = WebContextFactory.get().getSession();		
	
public List getAssignmenet() {
		
		try {
			UploadDocDAO uploadDocDAO = null;
			
			StudentDetails studentDetails = null;
			String classID = null;
			String studentID = null;
			
			String UM_ID = (String)session.getAttribute("UM_ID");
			String pdID = (String)session.getAttribute("pdID");
			
			String IM_ID = (String)session.getAttribute("IM_ID");
			String SM_ID = (String)session.getAttribute("SM_ID");
			String BM_ID = (String)session.getAttribute("BM_ID");

			classID 		= (String)session.getAttribute("ClassID");
			studentID 	= (String)session.getAttribute("StuID");//these two value set by NotificationDWr class....
			
			
/*			if (classID == null || studentID == null) {		//if in notification dwr..session r not dr...here i put it		
				StudentDetailsAnalysis studentDetailsAnalysis = new StudentDetailsAnalysis();
				studentDetails = studentDetailsAnalysis.getStudentDetails(request, pdID, BM_ID);
			
				if (studentDetails != null) {
					studentID = studentDetails.getStuId()+"";	
					classID  =  studentDetailsAnalysis.getCurrentClassID(request,studentID,BM_ID);//return may null
					session.setAttribute("StuID", studentDetails.getStuId()+"");
					session.setAttribute("ClassID", classID);
				}				
			}	*/				
					
					try {
						uploadDocDAO = (UploadDocDAO)ServiceFinder.getContext(request).getBean("UploadDocHibernateDao");
						List assignDataList = new ArrayList();
						assignDataList =	uploadDocDAO.getAssignemets(BM_ID, classID);
						System.out.println("notiDataList.sizz"+assignDataList.size());
						return assignDataList;
						
					} catch (BeansException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
}
