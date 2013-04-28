package com.schooltrix.dwr;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContextFactory;
import org.springframework.beans.BeansException;

import com.schooltrix.daos.BranchMasterDAO;
import com.schooltrix.daos.ClassMasterDAO;
import com.schooltrix.daos.InstitutionMasterDAO;
import com.schooltrix.daos.SchoolMasterDAO;
import com.schooltrix.hibernate.InstitutionMaster;
import com.schooltrix.hibernate.SchoolMaster;
import com.schooltrix.managers.ServiceFinder;

public class SchoolMasterDWR {

	HttpServletResponse response = WebContextFactory.get().getHttpServletResponse();
	HttpServletRequest request = WebContextFactory.get().getHttpServletRequest();
	HttpSession session = WebContextFactory.get().getSession();
	
    public String saveSchoolMaster(String  sName,  String ssName,   String  sAddress,  String  sCity,  Long   sState,  String 	sCountry,  String sContPerson, 
    								
    								String sEmail,String  sMobile,  String sLandline,   String  sIsActive) {
    	
    	SchoolMasterDAO sMasterDao = null;
    	System.out.println("i am here SchoolMasterDWR");
    	
    	try {
    		String im_id =(String) session.getAttribute("IM_ID");
    		//min validation..
    		if (im_id != null && im_id != "null" && ((String) session.getAttribute("userType")).equalsIgnoreCase("AD")) {
				
			
    		sMasterDao = (SchoolMasterDAO)ServiceFinder.getContext(request).getBean("SchoolMasterHibernateDao"); 		
				SchoolMaster sm = new SchoolMaster();
				sIsActive=sIsActive.equalsIgnoreCase("Y")?"Y":"N";
				sm.setActive(sIsActive);
				sm.setAddress(sAddress);
				sm.setCity(sCity);
				sm.setContactPerson(sContPerson);
				sm.setEmailId(sEmail);
				sm.setLandline(sLandline);
				sm.setMobile(sMobile);
				sm.setName(sName);
				sm.setImId(Long.parseLong(im_id));
				sm.setStateId(sState);//modify
				sm.setSchoolName(ssName);
			//	sm.setCountry(sCountry);
				sMasterDao.save(sm);
			return "saved";
    		}
    		
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return "error";
		
    	
	}
    
    //using in uploadDoc,branchadd...
    public List getSchoolMasterList() {
    	
		SchoolMasterDAO schoolMasterdao =null;
		List<Object[]> schoolList= new ArrayList<Object[]>();
		List instList= new ArrayList();
		try {
			String IM_ID = (String)session.getAttribute("IM_ID");
			System.out.println("in getSchoolMasterList DWR "+IM_ID);
			schoolMasterdao = (SchoolMasterDAO)ServiceFinder.getContext(request).getBean("SchoolMasterHibernateDao"); 		
			instList = schoolMasterdao.getSchoolList("imId",Long.parseLong(IM_ID));					

			for (int i = 0; i < instList.size(); i++) {
				String[] oioio = new String[2];
				SchoolMaster ioio = (SchoolMaster)instList.get(i);
				System.out.println("--90---"+ioio.getName());
				oioio[0] = ioio.getSmId()+"";
				oioio[1] = ioio.getName();
				schoolList.add(oioio);
			}
			
				return schoolList;
		} catch (BeansException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
		}

 }	 




}
