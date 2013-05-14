package com.schooltrix.dwr;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.directwebremoting.WebContextFactory;
import org.springframework.beans.BeansException;
import com.schooltrix.daos.ClassMasterDAO;
import com.schooltrix.hibernate.ClassMaster;
import com.schooltrix.managers.ServiceFinder;

public class ClassMasterDWR {
	HttpServletResponse response = WebContextFactory.get().getHttpServletResponse();
	HttpServletRequest request = WebContextFactory.get().getHttpServletRequest();
	HttpSession session = WebContextFactory.get().getSession();
	
	 public List<Object[]> getClassMasterList(String SM_ID, String BM_ID) {

			ClassMasterDAO classMasterdao =null;
			List<Object[]> userList= new ArrayList<Object[]>();
			try {
				String IM_ID =(String)session.getAttribute("IM_ID");
				
				System.out.println("in getClassMasterList DWR --"+SM_ID+"---"+BM_ID);
				
		/*		need im_id based on condti...allschools ..and all branches..get list of classs....im_id from session
				SM_ID=0
				BM_ID=0*/
				
				classMasterdao = (ClassMasterDAO)ServiceFinder.getContext(request).getBean("ClassMasterHibernateDao"); 		
				
				if (SM_ID.equalsIgnoreCase("0")) {
					if (BM_ID.equalsIgnoreCase("0")) {
						//all classes under institution
						userList = classMasterdao.getClassMasterList(IM_ID,SM_ID,BM_ID,1);
						
					}else if (Long.parseLong(BM_ID)>=0){
						//here based on branch id only we get classes list....
						userList = classMasterdao.getClassMasterList(IM_ID,SM_ID,BM_ID,2);
					}					
				} else  if (Long.parseLong(SM_ID)>=0){
					//under one school...
					if (BM_ID.equalsIgnoreCase("0")) {
						//all classes under school
						userList = classMasterdao.getClassMasterList(IM_ID,SM_ID,BM_ID,3);
						
					}else if (Long.parseLong(BM_ID)>=0){
						//here based on branch id only we get classes list....
						userList = classMasterdao.getClassMasterList(IM_ID,SM_ID,BM_ID,2);
					}		
				}
				
					
					
					return userList;
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
	 
	 public List<Object[]> getClassMasterList(String BM_ID) {

			ClassMasterDAO classMasterdao =null;
			List<Object[]> userList= new ArrayList<Object[]>();
			try {
							
				System.out.println("in getClassMasterList DWR ");
				classMasterdao = (ClassMasterDAO)ServiceFinder.getContext(request).getBean("ClassMasterHibernateDao"); 		
					userList = classMasterdao.getClassMasterList(BM_ID);					
					return userList;
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
	 
	 
	 public List<Object[]> getMultiClassMasterList(String[] bmIDString) {

			ClassMasterDAO classMasterdao =null;
			List<Object[]> userList= new ArrayList<Object[]>();
			try {
				
				
				StringBuffer inString =new StringBuffer();
				//in('2','3')
				
				for (int i = 0; i < bmIDString.length; i++) {
			/*		if(bmIDString[i].equalsIgnoreCase("0")){
						inString = new StringBuffer("0");
						break;
					}			*/			
					inString.append(bmIDString[i]);
					if(i<bmIDString.length-1)
					inString.append(",");
					
				}
				//System.out.println("inString**********"+inString);
				
				String inQuery = inString+"";
				System.out.println("in getMultiClassMasterList DWR ******"+bmIDString.length);
				classMasterdao = (ClassMasterDAO)ServiceFinder.getContext(request).getBean("ClassMasterHibernateDao"); 		
					userList = classMasterdao.getMultiClassMasterList(inQuery);					
					return userList;
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
	 
	 public List<Object[]> getSubjectMasterList(String SM_ID, String BM_ID,String CM_ID) {//may only one cm_id req..

		 if (CM_ID != null) {
			ClassMasterDAO classMasterdao =null;
			List<Object[]> subList= new ArrayList<Object[]>();
			try {
				String IM_ID =(String)session.getAttribute("IM_ID");
				System.out.println("in getSubjectMasterList DWR "+CM_ID);
				classMasterdao = (ClassMasterDAO)ServiceFinder.getContext(request).getBean("ClassMasterHibernateDao"); 		
						subList = classMasterdao.getSubjectMasterList(IM_ID,BM_ID,SM_ID,CM_ID);		
				return subList;
			} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		 }
		 return null;
	 }	 
	 
	 public List<Object[]> getMultiSubjectMasterList(String SM_IDs[], String[] BM_IDs,String CM_IDs[]) {

		 if (CM_IDs != null || BM_IDs!=null) {
			 
			 	StringBuffer inSM_IDs =new StringBuffer();
				StringBuffer inBM_IDs =new StringBuffer();
				StringBuffer inCM_IDs =new StringBuffer();
				
				
				//in('2','3')//single colon not req..
				for (int i = 0; i < SM_IDs.length; i++) {									
					inSM_IDs.append(SM_IDs[i]);
					if(i<SM_IDs.length-1)
						inSM_IDs.append(",");
				}
				
				
				for (int i = 0; i < BM_IDs.length; i++) {									
					inBM_IDs.append(BM_IDs[i]);
					if(i<BM_IDs.length-1)
						inBM_IDs.append(",");
				}
			 
				for (int i = 0; i < CM_IDs.length; i++) {									
					inCM_IDs.append(CM_IDs[i]);
					if(i<CM_IDs.length-1)
						inCM_IDs.append(",");
				}
			 
				System.out.println(inSM_IDs+"--"+inBM_IDs+"---"+inCM_IDs);
				
			ClassMasterDAO classMasterdao =null;
			List<Object[]> subList= new ArrayList<Object[]>();
			try {
				String IM_ID =(String)session.getAttribute("IM_ID");
				classMasterdao = (ClassMasterDAO)ServiceFinder.getContext(request).getBean("ClassMasterHibernateDao"); 		
						subList = classMasterdao.getMultiSubjectMasterList(IM_ID,inSM_IDs+"",inBM_IDs+"",inCM_IDs+"");		
				return subList;
			} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		 }
		 return null;
	 }	 
	 
	 

	 
/*	 public List getClassMasterList(String  IM_ID,String SM_ID, String BM_ID) {
		 
		 ClassMasterDAO classMasterdao =null;
		 List<String> userList= new ArrayList<String>();
		 try {
			 System.out.println("in getClassMasterList DWR ");
			 classMasterdao = (ClassMasterDAO)ServiceFinder.getContext(request).getBean("ClassMasterHibernateDao"); 		
			 ClassMaster classInputData = new ClassMaster();
			 userList = classMasterdao.getClassMasterList(IM_ID,BM_ID,SM_ID);					
			 return userList;
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
*/	  
}

