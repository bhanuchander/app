package com.schooltrix.dwr;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContextFactory;
import org.springframework.beans.BeansException;
import com.schooltrix.daos.SMSCreditsDAO;
import com.schooltrix.hibernate.SmsCredits;
import com.schooltrix.managers.ServiceFinder;

public class SMSCreditsDWR implements Serializable {


	HttpServletResponse response = WebContextFactory.get().getHttpServletResponse();
	HttpServletRequest request = WebContextFactory.get().getHttpServletRequest();
	HttpSession session = WebContextFactory.get().getSession();
	
    
	 public String smsCreditsBalance(String SM_ID,String BM_ID) {

			SMSCreditsDAO smsCreditsDao =null;	
			String smscredits = "";
			try {
				String IM_ID = (String)session.getAttribute("IM_ID");
				smsCreditsDao = (SMSCreditsDAO)ServiceFinder.getContext(request).getBean("SMSCreditsHibernateDao"); 		
				SmsCredits smsInputData = new SmsCredits();
				smsInputData = smsCreditsDao.findByProperty("bmId", BM_ID);
				if (smsInputData != null) {
					 smscredits=smsInputData.getSmsCredits();
				}
					
					System.out.println("smsInputData-------"+smscredits);
					
			return smscredits;
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
