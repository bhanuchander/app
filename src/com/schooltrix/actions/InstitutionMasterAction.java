/**
 * 
 */
package com.schooltrix.actions;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.directwebremoting.WebContextFactory;
import org.springframework.beans.BeansException;

import com.schooltrix.daos.InstitutionMasterDAO;
import com.schooltrix.hibernate.InstitutionMaster;
import com.schooltrix.managers.ServiceFinder;

// extends ActionSupport 
public class InstitutionMasterAction{
	HttpServletResponse response = WebContextFactory.get().getHttpServletResponse();
	HttpServletRequest request = WebContextFactory.get().getHttpServletRequest();
	HttpSession session = WebContextFactory.get().getSession();
	
    public String saveInstitution(String  insName,  String insSName,   String  insAddr,  String  insCity,  String   insCountry,  String 	insState,  String insContPerson,  String insEmailID,   
    													String  insMobile,  String insLandLine,   String  insActive) {
    	
    	System.out.println("ac--"+insActive+"--"+insName+"---"+insAddr+"..."+insCity+"8888"+session);   	
    	InstitutionMasterDAO imMasterDao =null;    	
    	try {
			imMasterDao = (InstitutionMasterDAO)ServiceFinder.getContext(request).getBean("InstitutionMasterHibernateDao"); 		
				InstitutionMaster imInputData = new InstitutionMaster();
				imInputData.setActive(insActive);
				imInputData.setAddress(insAddr);
				imInputData.setCity(insCity);
				imInputData.setContactPerson(insContPerson);
				imInputData.setEmailId(insEmailID);
				imInputData.setLandline(insLandLine);
				imInputData.setMobile(insMobile);
				imInputData.setName(insName);
				imInputData.setShortName(insSName);
				imInputData.setStateId(new Long(insState));//modify
			imMasterDao.save(imInputData);
			session.setAttribute("shortNameTemp", insSName);
			
			return "saved";
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
