package com.schooltrix.actions;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.BeansException;

import com.opensymphony.xwork2.ActionSupport;
import com.schooltrix.daos.ClassMasterDAO;
import com.schooltrix.daos.ParentDetailsDAO;
import com.schooltrix.daos.StudentDetailsDAO;
import com.schooltrix.daos.UserMasterDAO;
import com.schooltrix.hibernate.ClassMaster;
import com.schooltrix.hibernate.ParentDetails;
import com.schooltrix.hibernate.ParentStudentMap;
import com.schooltrix.hibernate.StudentDetails;
import com.schooltrix.hibernate.UserMaster;
import com.schooltrix.managers.ServiceFinder;

public class StudentMasterUploadAction extends ActionSupport implements ServletRequestAware,SessionAware{
	

	Map session;
	private File fileUP;
	private String fileUPContentType;
	private String fileUPFileName;
	public HttpServletRequest request ;
	

	public String execute() {		

		if(fileUPFileName==null){
			session.put("msg", "please upload csv/txt files");
			return INPUT;
		}
		else if(!fileUPFileName.substring(Math.max(0, fileUPFileName.length() - 3)).equalsIgnoreCase("txt") && !fileUPFileName.substring(Math.max(0, fileUPFileName.length() - 3)).equalsIgnoreCase("csv")){
			session.put("msg", "please upload only csv file or txt files");
			return INPUT;			
		}
		
		String SM_ID = request.getParameter("schoolNames");
		String BM_ID = request.getParameter("branchNames");
		
		String institutionName = (String)session.get("IM_SN");
		String IM_ID = (String)session.get("IM_ID");
		
		System.out.println(SM_ID+"-BM_ID-"+BM_ID+"--IM_ID-"+IM_ID+"-institutionName-"+institutionName);
		
		try {
			FileReader inpFile = new FileReader(fileUP);
			BufferedReader inpReader = new BufferedReader(inpFile);
			String inpLine = null; 
			int atWhatline=1;
			
			while ((inpLine = inpReader.readLine()) != null) 
			{
			  String[] Fields = inpLine.split(",\\s*");
			  if(Fields[0]!=null){
				  //Student_First_Name,Student_Last_Name,DOB,Email,Mobile,Landline,Address1,Address2,City,State,Admission_Number,Admission_Date,Class_Admitted_in,Gender,Active,
				  //Parent_First_Name,Parent_Last_Name,DOB,Email,Mobile,Landline,Address1,Address2,City,State,Parent_Type, Active
				 int i=0;
						 for (int j = 0; j < Fields.length; j++) {
							System.out.print(Fields[j]+"--");
						}
				 //Student_First_Name--Student_Last_Name--DOB--Email--Mobile--Landline--Address1--Address2--City--State--Admission_Number--Admission_Date--Class_Admitted_in--Gender--Active--
				 //Parent_First_Name--Parent_Last_Name--DOB--Email--Mobile--Landline--Address1--Address2--City--State--Parent_Type--Active--
				 
				String[] format = {"Student_First_Name","Student_Last_Name","DOB","Email","Mobile","Landline","Address1","Address2","City","State","Admission_Number","Admission_Date","Class_Admitted_in","Gender","Active","Parent_First_Name","Parent_Last_Name","DOB","Email","Mobile","Landline","Address1","Address2","City","State","Parent_Type","Active"};
			
				System.out.println(Fields.length+"**********"+format.length);
				
				if ((atWhatline==1)) {
					 for (int j = 0; j < format.length; j++) {
						if (Fields[j].equalsIgnoreCase(format[j])) {
							System.out.print(j+"--");
							atWhatline++;
						}else{
							atWhatline = 1;
							break;
						}
					}
				}else if(atWhatline>1){			
					//required every fields(column) validation
					
					if (Fields.length<27) {
						session.put("msg", "Invalid File");
						return INPUT;							
					}else{
						String check =  doInsertIntoDB(Fields,IM_ID,SM_ID,BM_ID);//main operations*********************************************************
						String validLine = isValidLine(Fields);						
					
						if(check.equalsIgnoreCase("fail")){
							session.put("msg", "Invalid File");
							return INPUT;						
						}
					}
					
				 	
			  }else{
					session.put("msg", "Invalid File");
					  return INPUT;
			  }				  
				 
			}
			  
		}
		
	  } catch (Exception e) {
			// TODO Auto-generated catch block
		  session.put("msg", "Invalid File");
			e.printStackTrace();
			return INPUT;
	 }
		session.put("msg","Your file name:  " + fileUPFileName+ "<br>Success !");
		return SUCCESS;	
  }

	private String isValidLine(String[] fields) {
		// TODO Auto-generated method stub---27 fields
		/*String[] format = {"Student_First_Name","Student_Last_Name","DOB","Email","Mobile","Landline","Address1","Address2","City","State","Admission_Number","Admission_Date",
				"Class_Admitted_in","Gender","Active","Parent_First_Name","Parent_Last_Name","DOB","Email","Mobile","Landline","Address1","Address2","City","State","Parent_Type",
				"Active"};*/
		
		
		return null;
	}
	
	
	private String doInsertIntoDB(String[] Fields,String IM_ID, String SM_ID, String BM_ID){
		 for (int i = 0; i < Fields.length; i++) 
		  {
			 Fields[i] = Fields[i].replace("\"", "");		    
		  }		 
		 
		 
		 StudentDetailsDAO studentDetailsDao = (StudentDetailsDAO)ServiceFinder.getContext(request).getBean("StudentDetailsDAO");
		 UserMasterDAO userMasterDao = (UserMasterDAO)ServiceFinder.getContext(request).getBean("UserMasterHibernateDao");
		 ParentDetailsDAO parentDetailsDao = (ParentDetailsDAO)ServiceFinder.getContext(request).getBean("ParentDetailsHibernateDao");
			try {
				 
				 String[] idPasswordStu =  getIdPassword("Stu",Fields[2],Fields[2],IM_ID).split("~");
				 String[] idPasswordPar =  getIdPassword("Par",Fields[2],Fields[2],IM_ID).split("~");
				
				 
				 String autoUserIDStu 					= 	idPasswordStu[0];
				 String autoPasswordStu 					= 	idPasswordStu[1];
				
				 String autoUserIDPar					= 	idPasswordPar[0];
				 String autoPasswordPar 					= 	idPasswordPar[1];
				 
				 System.out.println(autoUserIDStu+"stu--"+autoPasswordStu+"--par-"+autoUserIDPar+"--"+autoPasswordPar);
				 
				 UserMaster umaster = new UserMaster();
							umaster.setImId(Long.parseLong(IM_ID));
							umaster.setSmId(Long.parseLong(SM_ID));
							umaster.setBmId(Long.parseLong(IM_ID));
							umaster.setUtId(new Long(5));//5-student
							umaster.setUserId(autoUserIDStu);
							umaster.setPassword(autoPasswordStu);
							umaster.setActive("Y");
						
				
				StudentDetails studentData =new StudentDetails();
				
				int i = 0;
				
				//0									1
				//Student_First_Name,Student_Last_Name,DOB,Email,Mobile,Landline,Address1,Address2,City,State,Admission_Number,Admission_Date,Class_Admitted_in,Gender,Active,
				studentData.setFirstName(Fields[i++]);
				studentData.setLastName(Fields[i++]);
				studentData.setDob(Fields[i++]);
				studentData.setEmail(Fields[i++]);
				studentData.setMobile(Fields[i++]);
				studentData.setLandline(Fields[i++]);
				studentData.setAddress1(Fields[i++]);
				studentData.setAddress2(Fields[i++]);
				studentData.setCity(Fields[i++]);
				studentData.setState(Fields[i++]);
				studentData.setAdmissionNumber(Fields[i++]);
				studentData.setAdmissionDate(new SimpleDateFormat("yyyy-MM-dd").parse(Fields[i++]));
				String classNameO = Fields[i++];
				String classID = getClassID(classNameO);
				studentData.setClassAdmittedIn(classID == null?classNameO:classID);//------Class id required,so based on className get the classID...dis is one type validation also
				studentData.setGender(Fields[i++]);
				 String isactive=Fields[i++];
				 if(isactive.equalsIgnoreCase("yes") || isactive.equalsIgnoreCase("y") ){
					 isactive="Y"; 
				 }
				studentData.setActive(isactive.equalsIgnoreCase("Y")?isactive:"N");
				
				studentData.setPhoto("noImage.jpg");
				
				
				userMasterDao.save(umaster);
				studentData.setUmId(umaster.getUmId());			
				studentDetailsDao.save(studentData);
				
				System.out.println("Student FNmae"+Fields[0]+"DOB"+Fields[10]+"Parent FNmae"+Fields[15]+"DOB"+Fields[20]);
				System.out.println(umaster.getUmId()+"---");
				
				
				 UserMaster umasterPar = new UserMaster();
				 umasterPar.setImId(Long.parseLong(IM_ID));
				 umasterPar.setSmId(Long.parseLong(SM_ID));
				 umasterPar.setBmId(Long.parseLong(IM_ID));
				 umasterPar.setUtId(new Long(2));//2-Parent
				 umasterPar.setUserId(autoUserIDPar);
				 umasterPar.setPassword(autoPasswordPar);
				 umasterPar.setActive("Y");
				
				
				ParentDetails parentData =new ParentDetails();
				
				parentData.setFirstName(Fields[i++]);
				parentData.setLastName(Fields[i++]);
				parentData.setDob(Fields[i++]);
				parentData.setEmail(Fields[i++]);
				parentData.setMobile(Fields[i++]);
				parentData.setLandline(Fields[i++]);
				//Parent_First_Name,Parent_Last_Name,DOB,Email,Mobile,Landline,Address1,Address2,City,State,Parent_Type, Active
				
				parentData.setAddress1(Fields[i++]);
				parentData.setAddress2(Fields[i++]);
				parentData.setCity(Fields[i++]);
				parentData.setState(Fields[i++]);//state ID
				parentData.setPtmId(Fields[i++]);
				 String isactivePar=Fields[i++];
				 if(isactivePar.equalsIgnoreCase("yes") || isactivePar.equalsIgnoreCase("y") ){
					 isactivePar="Y"; 
				 }
				 parentData.setActive(isactivePar.equalsIgnoreCase("Y")?isactivePar:"N");				
				parentData.setIsDefault("Y");
				parentData.setPhoto("noImage.jpg");
				
				userMasterDao.save(umasterPar);
				parentData.setUmId(umasterPar.getUmId());			
				parentDetailsDao.save(parentData);
				
				System.out.println(umasterPar.getUmId()+"-umasterPar.getUmId()");
				
				ParentStudentMap psm = new ParentStudentMap();
				psm.setActive("Y");
				psm.setPdId(parentData.getPdId()+"");
				psm.setStuId(studentData.getStuId()+"");
				
				System.out.println(parentData.getPdId()+"--both--"+studentData.getStuId());
				
				studentDetailsDao.saveStudentParentMap(psm);
				
				
			
			} catch (Exception e) {
				System.out.println("in exption");
				e.printStackTrace();
				return "fail";
			}
			return "";
	}
	
	

	private String getClassID(String className) {
		try {
			// TODO Auto-generated method stub
			ClassMasterDAO classMasterdao = (ClassMasterDAO)ServiceFinder.getContext(request).getBean("ClassMasterHibernateDao"); 	
			ClassMaster classMasterData = new ClassMaster();
			
			classMasterData = 	classMasterdao.findByProperty("className", className.trim());
		
		return classMasterData.getCmId()+"";
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

	@Override
	public void setSession(Map session) {
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

	private String getIdPassword(String userType,String fName,String lName,String imId) {
		
		if(userType != null){
			try {
				String userPass = "";
				String userID = null;
				
				StringBuffer uu = new StringBuffer();
				uu.append(userType);
				
				
				if (fName.length()>2) {
					uu.append(fName.substring(0, 3));
				}else{
					uu.append(fName);
				}
				
				if (lName.length()>2) {
					uu.append(lName.substring(0, 3));
				}else{
					uu.append(lName);
				}
				
				userID = uu+"";			
				
				UserMasterDAO userMasterDao = (UserMasterDAO)ServiceFinder.getContext(request).getBean("UserMasterHibernateDao"); 	
				System.out.println("userID--"+userID+"-imId-"+imId);
				List userlist = userMasterDao.findByPropertyList2("userId", userID,  "imId", imId);
				
				p:if (userlist.size()>0) {
					for (int k = 1; k < 100; k++) {
						 String modUserId = userID+k;
						int count =0;
						for (int i = 0; i < userlist.size(); i++) {
							UserMaster um = (UserMaster)userlist.get(i);
							if (modUserId.equalsIgnoreCase(um.getUserId())) {
								count++;
							}
						}
					if (count == 0) {
						userID = modUserId;
						break p;
					}
					
					}
				}
				
				//code to shuffle password
				StringBuffer stringBuffer=new StringBuffer();
				List<String> list=new ArrayList<String>();
				list.add("t");
				list.add("r");
				list.add("i");
				list.add("x");
	
				Collections.shuffle(list);  			  	
				Iterator<String> iterator		= list.iterator();	   		
				while(iterator.hasNext()){
					stringBuffer.append(iterator.next());
				}	   		
		  userPass							= stringBuffer.toString()+"1234";
		  return userID+"~"+userPass;
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}	
		}else{
		return null;
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
		return  "noImage.jpg";
	}
	
	}

	
}



