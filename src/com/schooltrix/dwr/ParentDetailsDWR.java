package com.schooltrix.dwr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContextFactory;
import org.springframework.beans.BeansException;

import com.schooltrix.daos.NotificationMasterDAO;
import com.schooltrix.daos.ParentDetailsDAO;
import com.schooltrix.hibernate.ParentDetails;
import com.schooltrix.managers.ServiceFinder;

public class ParentDetailsDWR {
	HttpServletResponse response = WebContextFactory.get().getHttpServletResponse();
	HttpServletRequest request = WebContextFactory.get().getHttpServletRequest();
	HttpSession session = WebContextFactory.get().getSession();
	
	public List getParentDetails() {
		
		try {
			ParentDetailsDAO parentDetailsDAO = null;
			
			
			String UM_ID = (String)session.getAttribute("UM_ID");
			String pdID = (String)session.getAttribute("pdID");
			
			String IM_ID = (String)session.getAttribute("IM_ID");
			String SM_ID = (String)session.getAttribute("SM_ID");
			String BM_ID = (String)session.getAttribute("BM_ID");
			
					try {
						parentDetailsDAO = (ParentDetailsDAO)ServiceFinder.getContext(request).getBean("ParentDetailsHibernateDao");
						List parentDataList = new ArrayList();
						List parentDataListSplit = new ArrayList();
						parentDataList =	parentDetailsDAO.findByPropertyListLong("umId", Long.parseLong(UM_ID));

						System.out.println("parentDataList.sizz"+parentDataList.size());
						
						for (Iterator iterator = parentDataList.iterator(); iterator.hasNext();) {
							ParentDetails pd = new ParentDetails();
							pd = (ParentDetails) iterator.next();
							List<String> yy = new ArrayList<String>();
							yy.add(pd.getMobile());
							yy.add(pd.getEmail());
							yy.add(pd.getIsDefault());
							yy.add(pd.getPtmId());
							yy.add(pd.getPdId()+"");
							
							System.out.println(pd.getFirstName()+"****"+pd.getPtmId()+"**"+pd.getIsDefault()+"**"+pd.getPtmId()+"**"+pd.getPdId());
							parentDataListSplit.add(yy);
						}
						
						return parentDataListSplit;
						
					} catch (BeansException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//getParentDetails(fMobile,mMobile,fMail,mMail,checkReq, fpdid, mpdid,
	public  boolean saveParentDetails(String fMobile,String mMobile,String fMail,String mMail,String checkReq,String fpdid,String mpdid) {
		String UM_ID = (String)session.getAttribute("UM_ID");
		String pdID = (String)session.getAttribute("pdID");
		
		String IM_ID = (String)session.getAttribute("IM_ID");
		String SM_ID = (String)session.getAttribute("SM_ID");
		String BM_ID = (String)session.getAttribute("BM_ID");
		ParentDetailsDAO parentDetailsDAO = null;
		
		String radioDefalut1= checkReq.equalsIgnoreCase("1")?"Y":"N";
		String radioDefalut2= checkReq.equalsIgnoreCase("2")?"Y":"N";
		boolean isModified = false;
		
		try {
			parentDetailsDAO = (ParentDetailsDAO)ServiceFinder.getContext(request).getBean("ParentDetailsHibernateDao");
			List parentDataList = new ArrayList();
			List parentDataListSplit = new ArrayList();
			parentDataList =	parentDetailsDAO.findByPropertyListLong("umId", Long.parseLong(UM_ID));

			System.out.println("saveParentDetails.sizz"+parentDataList.size());
			
			for (Iterator iterator = parentDataList.iterator(); iterator.hasNext();) {
				ParentDetails pd = new ParentDetails();
				pd = (ParentDetails) iterator.next();
			int i =0;
				//checkReq--1 father and 2 mother
				System.out.println(pd.getPdId()+"------"+fpdid+"***"+mpdid);
				if (pd.getPdId().toString().equalsIgnoreCase(fpdid)) {
					if (pd.getMobile().equalsIgnoreCase(fMobile)) {							
					}else{
						pd.setMobile(fMobile);
						i++;
					}
					if (pd.getEmail().equalsIgnoreCase(fMail)) {
					}else{
					pd.setEmail(fMail);
					i++;
					}
					if (pd.getIsDefault().equalsIgnoreCase(radioDefalut1)) {
					}else{
							pd.setIsDefault(radioDefalut1);						
						i++;
					}
					
				}
				if (pd.getPdId().toString().equalsIgnoreCase(mpdid)) {
					if (pd.getMobile().equalsIgnoreCase(mMobile)) {							
					}else{
						pd.setMobile(mMobile);
						i++;
					}
					if (pd.getEmail().equalsIgnoreCase(mMail)) {
					}else{
						pd.setEmail(mMail);
						i++;
					}
					if (pd.getIsDefault().equalsIgnoreCase(radioDefalut2)) {
					}else{
						pd.setIsDefault(radioDefalut2);						
						i++;
					}
					
				}
				System.out.println("i******"+i);
				if (i>0) {
					parentDetailsDAO.save(pd);
					isModified = true;
				}
				
				System.out.println(pd.getFirstName()+"****"+pd.getPtmId()+"**"+pd.getIsDefault()+"**"+pd.getPtmId()+"**"+pd.getPdId());
			}
			return isModified;
			
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isModified;
	}
	
	
	
}
