package com.schooltrix.dwr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContextFactory;
import org.springframework.beans.BeansException;

import com.schooltrix.daos.BranchMasterDAO;
import com.schooltrix.daos.ClassMasterDAO;
import com.schooltrix.daos.CountryMasterDAO;
import com.schooltrix.daos.InstitutionMasterDAO;
import com.schooltrix.daos.SchoolMasterDAO;
import com.schooltrix.daos.StateMasterDAO;
import com.schooltrix.hibernate.BranchMaster;
import com.schooltrix.hibernate.CountryMaster;
import com.schooltrix.hibernate.InstitutionMaster;
import com.schooltrix.hibernate.SchoolMaster;
import com.schooltrix.hibernate.StateMaster;
import com.schooltrix.managers.ServiceFinder;

public class BranchMasterDWR {

	HttpServletResponse response = WebContextFactory.get().getHttpServletResponse();
	HttpServletRequest request = WebContextFactory.get().getHttpServletRequest();
	HttpSession session = WebContextFactory.get().getSession();
	
    public String saveBranchMaster(String schoolID,String  sname,  String shortName,   String  address,  String  city,  String   country,  String 	br_state,  String br_cperson, 
			
			String bemail,String  br_mobile,  String br_landline,   String  isactive) {
    	
    	BranchMasterDAO bMasterDao = null;
    	
    	try {
    		bMasterDao = (BranchMasterDAO)ServiceFinder.getContext(request).getBean("BranchMasterHibernateDao"); 		
    		BranchMaster br = new BranchMaster();
    		System.out.println(isactive+"--isactive");
				isactive=isactive.equalsIgnoreCase("true")?"Y":"N";
				br.setActive(isactive);
				br.setLandline(br_landline);
				br.setMobile(br_mobile);
				br.setStateId(Long.parseLong(br_state));
				br.setImId((String)session.getAttribute("IM_ID"));
				br.setSmId(Long.parseLong(schoolID));
				br.setBranchName(sname);
				br.setShortName(shortName);
				br.setAddress(address);
				br.setCity(city);
				br.setStateId(new Long(br_state));
				br.setContactPerson(br_cperson);
				br.setEmailId(bemail);
			
				bMasterDao.save(br);
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
    
    
	 //bhanu
	 public String copyfromSchool(String  school_id) {
	    	
	    	SchoolMasterDAO scMasterDao = null;
	    	SchoolMaster schoolDetails = null;
	    	String country = null;
	    	long state = 0;
	    	try {
	    		scMasterDao = (SchoolMasterDAO)ServiceFinder.getContext(request).getBean("SchoolMasterHibernateDao"); 		
	    		 schoolDetails = (SchoolMaster)scMasterDao.findById(Long.parseLong(school_id));
	    		
	    		 StateMasterDAO sStateMasterDAO = null;
	    		if (schoolDetails.getStateId() >0) {
	    			state = schoolDetails.getStateId();
	    			try {
					/*	sStateMasterDAO = (StateMasterDAO)ServiceFinder.getContext(request).getBean("StateMasterHibernateDao"); 		
						StateMaster stateMaster = sStateMasterDAO.findById((schoolDetails.getStateId()));
							state = stateMaster.getStateId();*/
	    		
					CountryMasterDAO countryMasterDAO = (CountryMasterDAO)ServiceFinder.getContext(request).getBean("CountryMasterHibernateDao"); 
	    			CountryMaster countryMaster = countryMasterDAO.findById(state);
	    					country = countryMaster.getCountryName();
	    			
	    			} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	    		
	    		System.out.println(schoolDetails.getAddress()+"~"+schoolDetails.getCity()+"~"+(country == null ? "India" : country)+"~"+ state+"~"+schoolDetails.getContactPerson()+"~"+schoolDetails.getEmailId()+"~"+schoolDetails.getMobile()+"~"+schoolDetails.getLandline());
	    		return schoolDetails.getAddress()+"~"+schoolDetails.getCity()+"~"+(country == null ? "India" : country)+"~"+ state+"~"+schoolDetails.getContactPerson()+"~"+schoolDetails.getEmailId()+"~"+schoolDetails.getMobile()+"~"+schoolDetails.getLandline();
			} catch (BeansException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println("in exceptionnn2");
				return "error";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("in exceptionnn1");
				//e.printStackTrace();
				return "error";
			}
			
	    	
		}
	 
	 
	    //bhanu
	 public List getBranchMasterList(String schoolID) {
		 
			BranchMasterDAO branchMasterDao =null;
			List instList= new ArrayList();
			List branchList = new ArrayList();
			try {
				
				
				String im_id =(String)session.getAttribute("IM_ID");
				Long sm_id = Long.parseLong(schoolID);
				
				branchMasterDao = (BranchMasterDAO)ServiceFinder.getContext(request).getBean("BranchMasterHibernateDao"); 		

				if (sm_id == 0) {
					instList = 	branchMasterDao.findByPropertyList("imId",im_id);
					
				} else if (sm_id > 0){
					instList = 	branchMasterDao.getBranchList("imId",im_id,"smId",sm_id);
				}
				
						System.out.println("in getInstitutionMasterList"+im_id);
						
							
							System.out.println("in dwr ut--"+instList.size());
	
							for (int i = 0; i < instList.size(); i++) {
								String[] oioio = new String[2];
								BranchMaster ioio = (BranchMaster)instList.get(i);
								System.out.println("--90---"+ioio.getBranchName());
								oioio[0] = ioio.getBmId()+"";
								oioio[1] = ioio.getBranchName();
								branchList.add(oioio);
							}
					return branchList;
		
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

	    //bhanu
		 public List getMultiBranchMasterList(String[] schoolID) {
			 
				BranchMasterDAO branchMasterDao =null;
				List instList= new ArrayList();
				List branchList = new ArrayList();
				try {
					StringBuffer inString =new StringBuffer();
					//in('2','3')
					
					for (int i = 0; i < schoolID.length; i++) {
						if(schoolID[i].equalsIgnoreCase("0")){
							inString = new StringBuffer("0");
							break;
						}						
						inString.append(schoolID[i]);
						if(i<schoolID.length-1)
						inString.append(",");
						
					}
					//System.out.println("inString**********"+inString);
					
					String inQuery = inString+"";
		
					String im_id =(String)session.getAttribute("IM_ID");
					
					Long sm_id = Long.parseLong(schoolID[0]);
					
					branchMasterDao = (BranchMasterDAO)ServiceFinder.getContext(request).getBean("BranchMasterHibernateDao"); 		

					if (inQuery.equalsIgnoreCase("0")) {
						instList = 	branchMasterDao.findByPropertyList("imId",im_id);						
						for (int i = 0; i < instList.size(); i++) {
							String[] oioio = new String[2];
							BranchMaster ioio = (BranchMaster)instList.get(i);
							System.out.println("--90---"+ioio.getBranchName());
							oioio[0] = ioio.getBmId()+"";
							oioio[1] = ioio.getBranchName();
							System.out.println(oioio[0]+"*************"+oioio[1]);
							branchList.add(oioio);
						}
					} else{
						instList = 	branchMasterDao.getMultiBranchList(im_id,inQuery);
						for (int i = 0; i < instList.size(); i++) {
							String[] oioio = new String[2];
							System.out.println(instList.size()+"^^^^^^^^^^^^^");
						    Object[] uu = (Object[])instList.get(i) ;
						    oioio[0] =(String) uu[0];
							oioio[1] = (String)uu[1];
							System.out.println(instList.size()+"@@"+oioio[0]+"**"+oioio[1]);
							branchList.add(oioio);							
						}
					}
							//System.out.println("in getInstitutionMasterList"+im_id);
							//	System.out.println("in dwr ut--"+instList.size());
		
						return branchList;
			
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
