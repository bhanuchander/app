package com.schooltrix.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;

import com.schooltrix.daos.ClassMasterDAO;
import com.schooltrix.daos.SectionMasterDAO;
import com.schooltrix.daos.StudentDetailsDAO;
import com.schooltrix.daos.UserMasterDAO;
import com.schooltrix.hibernate.ClassMaster;
import com.schooltrix.hibernate.ParentDetails;
import com.schooltrix.hibernate.ParentStudentMap;
import com.schooltrix.hibernate.SectionClassMap;
import com.schooltrix.hibernate.StaffDetails;
import com.schooltrix.hibernate.StudentDetails;
import com.schooltrix.hibernate.StudentSectionMap;
import com.schooltrix.hibernate.UserMaster;
import com.schooltrix.managers.ServiceFinder;

public class StudentDetailsAnalysis {

	StudentDetailsDAO studentDetailsDao= null;
	HttpServletRequest request = null;
	
	public StudentDetailsAnalysis() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentDetailsAnalysis(HttpServletRequest request){
		this.request = request;
	}
	
	
	public StudentDetails getStudentDetails(String pd_id,String bm_id){
		
		ParentDetails parentDetails = null;
		StudentDetails studentDetails = null;
		
		ParentStudentMap parentStudentMap = null;
		
		try {
			studentDetailsDao = (StudentDetailsDAO)ServiceFinder.getContext(request).getBean("StudentDetailsHibernateDao");
			
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

	public SectionClassMap getCurrentClassID(String stuId, String bM_ID) {
		// TODO Auto-generated method stub
		StudentSectionMap studentSectionMap 	= null;
		SectionMasterDAO sectionMasterDAO 	= null;
		SectionClassMap sectionClassMap 			= null;
		try {
			studentDetailsDao 	= (StudentDetailsDAO)ServiceFinder.getContext(request).getBean("StudentDetailsHibernateDao");
			studentSectionMap 	= studentDetailsDao.getStudentSectionMap("stuId", stuId);
			
			if(studentSectionMap.getScmId() != null){
			sectionMasterDAO 	= (SectionMasterDAO)ServiceFinder.getContext(request).getBean("SectionMasterHibernateDao");
			
			sectionClassMap = sectionMasterDAO.getSectionClassMap("scmId", Long.parseLong(studentSectionMap.getScmId()));	
			return sectionClassMap;			
			}
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ClassMaster getClassName(String classID) {
		// TODO Auto-generated method stub
		ClassMaster classMaster = null;
		ClassMasterDAO classMasterDAO = null;
		try {
			
			
			if(classID != null){
				classMasterDAO 	= (ClassMasterDAO)ServiceFinder.getContext(request).getBean("ClassMasterHibernateDao");
				
				classMaster = classMasterDAO.findById(Long.parseLong(classID));	
				return classMaster;			
			}
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public UserMaster getUserMaster(String UMID) {
		// TODO Auto-generated method stub
		UserMaster userMaster = null;
		UserMasterDAO userMasterDAO = null;
		try {		
			if(UMID != null){
				userMasterDAO 	= (UserMasterDAO)ServiceFinder.getContext(request).getBean("UserMasterHibernateDao");				
				userMaster = userMasterDAO.getUserMasterFieldData("umId",UMID,1);	
				return userMaster;			
			}
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
