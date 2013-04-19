package com.schooltrix.actions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.schooltrix.daos.InstitutionMasterDAO;
import com.schooltrix.daos.UploadDocDAO;
import com.schooltrix.daos.UserMasterDAO;
import com.schooltrix.hibernate.InstitutionMaster;
import com.schooltrix.hibernate.UploadDocuments;
import com.schooltrix.managers.ServiceFinder;

public class UploadDocAction extends ActionSupport implements ServletRequestAware,SessionAware {

	public UploadDocAction() {
		// TODO Auto-generated constructor stub
	}
	
	
	 private org.apache.log4j.Logger log = Logger.getLogger(UploadDocAction.class);
	Map session;
	HttpServletRequest request = null;
	private File fileUP;
	private String fileUPContentType;
	private String fileUPFileName;
	
	public String exeString() {
		return null;
	}
	
	public String uploadDoc() {
				System.out.println("kkkkkkkkkkkkk--"+fileUPFileName);
	if (fileUPFileName != null) {
		
		if(fileValidation()){
				
		try {
			String filePath = request.getSession().getServletContext().getRealPath("/")+"UploadDoc/";
;		
			
			 String im_id =	(String)session.get("IM_ID");

			 String sm_id =	request.getParameter("schoolNames");
			 String bm_id =	request.getParameter("branchNames");
			 
			 String institutionName = (String)session.get("IM_SN");

			System.out.println(institutionName+":institutionName:");
			 
			 String selectGrades =	request.getParameter("selectGrades");
			 String selectAll =	request.getParameter("selectAll");
			 String uploadType =	request.getParameter("uploadType");
			 String assignmentType =	request.getParameter("assignmentType");
			 String selectSubject =	request.getParameter("selectSubject");
			 String fileUP =	request.getParameter("fileUP");
			 String nty_email =	request.getParameter("nty_email");
			 String nty_sms =	request.getParameter("nty_sms");
			
			 System.out.println("selectGrades--"+selectGrades+"--"+selectAll+"--"+uploadType+"-assignmentType-"
			 +assignmentType+"--"+selectSubject+"--"+fileUPFileName+"--"+nty_email+"--"+nty_sms);
			 
			 
			 if(assignmentType == null){ 
				 assignmentType = "";
				}
			
			 if(selectSubject == null){ 
				 selectSubject = "";
			 }
			 
			 
			 if(nty_email == null || nty_email == "null"){
				 nty_email = "N";
			 }else{
				 nty_email = "Y";
			 }

			 if(nty_sms == null || nty_sms == "null"){
				 nty_sms = "N";
			 }else{
				 nty_sms = "Y";
			 }

			 String uniqueFileName ="";
			 
			 File fileToCreate = null;
			 UploadDocuments uploadDocData = new UploadDocuments();
			 UploadDocDAO uploadDocDao = null;
			 
			 filePath = filePath+"/"+institutionName+"/"+uploadType+"/";//change ?
				
			 uploadDocData.setImId(im_id);
			 uploadDocData.setSmId(sm_id);
			 uploadDocData.setBmId(bm_id);

			 uploadDocData.setToWhich(selectGrades);
			 uploadDocData.setToWhome(selectAll);
			 uploadDocData.setUploadType(uploadType);
			 
			 uniqueFileName = getFileUniqueName();			 
			 uploadDocData.setFileName(uniqueFileName);

			 uploadDocData.setAssignType(assignmentType);
			 uploadDocData.setSubject(selectSubject);

			 uploadDocData.setNotifyPaEmail(nty_email);
			 uploadDocData.setNotifyPaSms(nty_sms);
			 uploadDocData.setNotifyPaEmailFlag("0");
			 uploadDocData.setNotifyPaSmsFlag("0");

				
			 SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 uploadDocData.setUploadDate(java.sql.Timestamp.valueOf(sdf.format(new Date())));
				
			 
			 try {
				 uploadDocDao = (UploadDocDAO)ServiceFinder.getContext(request).getBean("UploadDocHibernateDao"); 		
				 uploadDocDao.save(uploadDocData);			 
				fileToCreate = new File(filePath,uniqueFileName);// unique file name
					FileUtils.copyFile(this.fileUP, fileToCreate);
					
					session.put("msg","Success");
					
					System.out.println("success");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.put("msg","File Not Uploaded");
				return "success";
				
			}
			 
				return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.put("msg","File Not Uploaded");
			return "success";
		}
		
		
		}else{
			session.put("msg","Please select File");
			return "success";
	}
	
	
	
	
	}else{
		session.put("msg","Please select File");
		return "success";
	}
	}
	
/*	private String getinstitutionName(String im_id) {
		try {
			// TODO Auto-generated method stub
			InstitutionMasterDAO imMasterDao = null;
			InstitutionMaster institutionMasterData = new InstitutionMaster();
			imMasterDao = (InstitutionMasterDAO)ServiceFinder.getContext(request).getBean("InstitutionMasterHibernateDao"); 
			institutionMasterData = imMasterDao.findById(Long.parseLong(im_id));
			
			
			return institutionMasterData.getShortName();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}*/

	private boolean fileValidation() {
		// TODO Auto-generated method stub
		
		try {
			String[] allowed = {"pdf", "doc", "docx", "xls", "xlsx", "txt","ppt","pptx","gif","csv","png","jpg","jpeg","dot","dotx","html","odm","ott","odt","rtf","xps"};
				
				int i = fileUPFileName.lastIndexOf('.');
				
				int count = StringUtils.countMatches(fileUPFileName, ".");
				
				System.out.println("iii--"+i+"ooo"+count);
				if (i > 0 && count<2) {
					String extension = fileUPFileName.substring(i+1);
					System.out.println("extension-->"+extension);
				for (int j = 0; j < allowed.length; j++) {
					if(allowed[j].equalsIgnoreCase(extension)){
						return true;
					}
				}
					
					
				}
			
			
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	private String getFileUniqueName() {
		String extension = "";
		if (getFileUPFileName() != null) {		
		
		int i = getFileUPFileName().lastIndexOf('.');
		if (i > 0) {
		    extension = getFileUPFileName().substring(i+1);
		}else{
			extension = "jpg";
		}		
		return String.format("%s.%s", RandomStringUtils.randomAlphanumeric(10), extension);
		}else{
			return  "nothing";
		}
		
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		System.out.println(session+"------------------------------------");
		this.session = session;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		System.out.println(request+"--------request----------------------------");
		this.request = request;  
	}

	public File getFileUP() {
		return fileUP;
	}

	public void setFileUP(File fileUP) {
		this.fileUP = fileUP;
	}

	public String getFileUPContentType() {
		return fileUPContentType;
	}

	public void setFileUPContentType(String fileUPContentType) {
		this.fileUPContentType = fileUPContentType;
	}

	public String getFileUPFileName() {
		return fileUPFileName;
	}

	public void setFileUPFileName(String fileUPFileName) {
		this.fileUPFileName = fileUPFileName;
	}

	
}
