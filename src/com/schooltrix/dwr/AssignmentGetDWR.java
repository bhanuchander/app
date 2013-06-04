package com.schooltrix.dwr;

import java.util.ArrayList;
import java.util.Iterator;
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
					
					try {
						uploadDocDAO = (UploadDocDAO)ServiceFinder.getContext(request).getBean("UploadDocHibernateDao");
						List assignDataList = new ArrayList();
						assignDataList =	uploadDocDAO.getAssignemets(BM_ID, classID);
						System.out.println("assignDataList.sizz"+assignDataList.size());
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
	
public List getAcademics() {
	
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
				
				try {
					uploadDocDAO = (UploadDocDAO)ServiceFinder.getContext(request).getBean("UploadDocHibernateDao");
					List assignDataList = new ArrayList();
					assignDataList =	uploadDocDAO.getAcademics(BM_ID, classID);
					System.out.println("assignDataList.sizz"+assignDataList.size());
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

public List getUtilites() {
	
	List utilitiesDataListMain = new ArrayList();
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
		//'Calendar','ExamSchedule','Canteen menu','Time table')
		String[] uploadTypes = new String[]{"ExamSchedule","Calendar","Time table","Canteen menu"};		
				try {
					uploadDocDAO = (UploadDocDAO)ServiceFinder.getContext(request).getBean("UploadDocHibernateDao");
					
					for (int i = 0; i < uploadTypes.length; i++) {
						utilitiesDataListMain.add(uploadDocDAO.getUtilities(BM_ID, classID,uploadTypes[i]));
						}
				System.out.println(utilitiesDataListMain.size()+"-->Main sizee");
				//testing
					for (Iterator iterator = utilitiesDataListMain.iterator(); iterator	.hasNext();) {
						ArrayList eee = (ArrayList) iterator.next();
						if (eee.size()>0) {
						//	System.out.println("***"+eee.get(0));
							Object[] dd =(Object[]) eee.get(0);							
							//System.out.println("@@@@"+dd[0]);								
							
							
						}
						//System.out.println("outside***");
					}
					
					
					System.out.println("assignDataList.sizz"+utilitiesDataListMain.size());
					return utilitiesDataListMain;
					
				} catch (BeansException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return utilitiesDataListMain;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return utilitiesDataListMain;
}
}
