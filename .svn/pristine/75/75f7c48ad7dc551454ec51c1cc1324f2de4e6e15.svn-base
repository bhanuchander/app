package com.schooltrix.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;

import com.schooltrix.daos.SectionMasterDAO;
import com.schooltrix.daos.StudentDetailsDAO;
import com.schooltrix.hibernate.ParentDetails;
import com.schooltrix.hibernate.ParentStudentMap;
import com.schooltrix.hibernate.SectionClassMap;
import com.schooltrix.hibernate.StaffDetails;
import com.schooltrix.hibernate.StudentDetails;
import com.schooltrix.hibernate.StudentSectionMap;
import com.schooltrix.managers.ServiceFinder;

public class StudentDetailsAnalysis {

	StudentDetailsDAO studentDetailsDao= null;
	
	
	
	
	public StudentDetails getStudentDetails(HttpServletRequest req,String pd_id,String bm_id){
		
		ParentDetails parentDetails = null;
		StudentDetails studentDetails = null;
		
		ParentStudentMap parentStudentMap = null;
		
		try {
			studentDetailsDao = (StudentDetailsDAO)ServiceFinder.getContext(req).getBean("StudentDetailsHibernateDao");
			
			parentStudentMap  = studentDetailsDao.getStudentParentMap("pdId", pd_id);
			String stuID = parentStudentMap.getStuId();
			System.out.println(stuID+"*stuID***************pdID*"+pd_id);
			if (stuID != null || stuID != "") {
				
				studentDetails = studentDetailsDao.findById(Long.parseLong(stuID));
				System.out.println(studentDetails.getUmId()+"*&*&*&");
				return studentDetails;
			}
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getCurrentClassID(HttpServletRequest req,String stuId, String bM_ID) {
		// TODO Auto-generated method stub
		StudentSectionMap studentSectionMap 	= null;
		SectionMasterDAO sectionMasterDAO 	= null;
		SectionClassMap sectionClassMap 			= null;
		try {
			studentDetailsDao 	= (StudentDetailsDAO)ServiceFinder.getContext(req).getBean("StudentDetailsHibernateDao");
			studentSectionMap 	= studentDetailsDao.getStudentSectionMap("stuId", stuId);
			
			if(studentSectionMap.getScmId() != null){
			sectionMasterDAO 	= (SectionMasterDAO)ServiceFinder.getContext(req).getBean("SectionMasterHibernateDao");
			
			sectionClassMap = sectionMasterDAO.getSectionClassMap("scmId", Long.parseLong(studentSectionMap.getScmId()));	
			return sectionClassMap.getCmId();			
			}
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
