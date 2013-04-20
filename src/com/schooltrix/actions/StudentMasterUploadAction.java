package com.schooltrix.actions;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.StyledEditorKit.BoldAction;

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
import com.schooltrix.daos.SectionMasterDAO;
import com.schooltrix.daos.StateMasterDAO;
import com.schooltrix.daos.StudentDetailsDAO;
import com.schooltrix.daos.UserMasterDAO;
import com.schooltrix.hibernate.ClassMaster;
import com.schooltrix.hibernate.ParentDetails;
import com.schooltrix.hibernate.ParentStudentMap;
import com.schooltrix.hibernate.SectionMaster;
import com.schooltrix.hibernate.StateMaster;
import com.schooltrix.hibernate.StudentDetails;
import com.schooltrix.hibernate.StudentSectionMap;
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
			
			int errorCount = 0;
			int ignoredCount = 0;
			int insertedCount = 0;
			int totalRecords = 0;
			
		while ((inpLine = inpReader.readLine()) != null) {
			if ((inpLine == null || inpLine == "" ) && atWhatline == 1) {
				System.out.println("--File is empty1");
				session.put("msg", "File is empty");
				return INPUT;	
			}
			
			totalRecords++;//for total records uploaded-result
				System.out.println("innnnnnnnnnnn");
			  M:{
					System.out.println("MMMMMMMMMMMMMMMMMMM");
				  try {
					  System.out.println("----------innnnnnnnnnnn");
				String[] fields = inpLine.split(",\\s*");
				  
				  if(fields[0]!=null){
					 
						//for printing juSTTT	
					  for (int j = 0; j < fields.length; j++) {
								System.out.print(fields[j]+"--");
							}
					  System.out.println("88888888888");			 
					//22-Student_First_Name,Student_Last_Name,DOB,Admission_Number,Admission_Date,Class_Admitted_In,Current_Class,Current_Section,Gender,
					//Father_First_Name,Father_Last_Name,DOB,Mother_First_Name,Mother_Last_Name,DOB,Primary_Email,Primary_Mobile,Landline,Address1,Address2,City,State		 
							 
					String[] format = {"Student_First_Name","Student_Last_Name","DOB","Admission_Number","Admission_Date","Class_Admitted_in","Current_Class","Current_Section","Gender",
							"Father_First_Name","Father_Last_Name","DOB","Mother_First_Name","Mother_Last_Name","DOB","Primary_Email","Primary_Mobile","Landline","Address1","Address2","City","State"};
				
					System.out.println(fields.length+"**********"+format.length);
					
					if ((atWhatline==1)) {
						 for (int j = 0; j < fields.length; j++) {//bcz upload txt may have more colums
							if (fields[j].equalsIgnoreCase(format[j])) {
								System.out.print(j+"--");
								atWhatline++;
							}else{
								session.put("msg", "Header Failed");
								//atWhatline = 1;
								return INPUT;
							}
						}
					}else if(atWhatline>1){
						//required every fields(column) validation
						//2nd line onwards here-------------------22 fields
						
						if (fields.length != format.length) {
						//I --reason to fail-error
							//insert into DB--Error
							errorCount++;
							break M;
						}else{
							//II -- reason to fail---if validLine-false ---here count is OK but each field will validate against wt type it's.
							boolean validLine = isValidLine(fields);//main is field validation						
							
							
							if (isValidLine(fields)) {
								//check for admission number already exist or not ---this is for ignored records
							 	if (!isAdmissionNumberExist(IM_ID,fields[3])) {
							 		System.out.println("in admission false--");
							 		boolean check =  doInsertIntoDB(fields,IM_ID,SM_ID,BM_ID);//main operations*********************************************************
							 		if (!check) {
							 			//insert into DB--Error
							 			errorCount++;
										break M;
									}else{
										insertedCount++;
										break M;
									}
							 	}else{
									//insert into DB-------Ignored records
							 		ignoredCount++;
									break M;
								}				 					
								
								//we need a specil method in daoimpl,for save all at once or roll back. 
															
							} else {
								//insert into DB----error
								errorCount++;
								break M;
							}
						
						}
					 	
					}
					 
				}else if (atWhatline > 1) {
					//some line is empty
					System.out.println("line is empty222");
					//session.put("msg", "File is empty");
				//insert into DB----error
					errorCount++;
					break M;	  
				}
			
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//insert into DB----error
				errorCount++;
			}
		}
		}//while############################################3
		
		session.put("msg", "Student File Upload Success");
		session.put("result", errorCount+"~"+ignoredCount+"~"+insertedCount+"~"+totalRecords);
		System.out.println("errorCount**"+errorCount);
		System.out.println("ignoredCount**"+ignoredCount);
		System.out.println("insertedCount**"+insertedCount);
		
	  } catch (Exception e) {
			// TODO Auto-generated catch block
		  session.put("msg", "Invalid File");
			e.printStackTrace();
			return INPUT;
	 }
		return SUCCESS;	
  }

	private boolean isAdmissionNumberExist(String iM_ID, String admissionN) {
		// TODO Auto-generated method stub
		 StudentDetailsDAO studentDetailsDao = (StudentDetailsDAO)ServiceFinder.getContext(request).getBean("StudentDetailsDAO");
		try {
			if (studentDetailsDao.findByProperty("admissionNumber", admissionN) == null) {
				return false;
			}			
		} catch (Exception e) {e.printStackTrace();	}
		return	true;	
	}

	private boolean isValidLine(String[] fields) {
		// TODO Auto-generated method stub---27 fields
		/*String[] format = {"Student_First_Name","Student_Last_Name","DOB","Email","Mobile","Landline","Address1","Address2","City","State","Admission_Number","Admission_Date",
				"Class_Admitted_in","Gender","Active","Parent_First_Name","Parent_Last_Name","DOB","Email","Mobile","Landline","Address1","Address2","City","State","Parent_Type",
				"Active"};*/
		
		
		return true;
	}
	
	
	private boolean doInsertIntoDB(String[] fields,String IM_ID, String SM_ID, String BM_ID){
		 for (int i = 0; i < fields.length; i++) 
		  {System.out.print("%%--"+fields[i]);
			 fields[i] = fields[i].replace("\"", "");	
			 System.out.print("&&--"+fields[i]);
		  }		 
		 
		 
		 StudentDetailsDAO studentDetailsDao = (StudentDetailsDAO)ServiceFinder.getContext(request).getBean("StudentDetailsDAO");
		 UserMasterDAO userMasterDao = (UserMasterDAO)ServiceFinder.getContext(request).getBean("UserMasterHibernateDao");
		 ParentDetailsDAO parentDetailsDao = (ParentDetailsDAO)ServiceFinder.getContext(request).getBean("ParentDetailsHibernateDao");
		 //two usermaster entries ,1 student details and 2 parent details(father,mother) ,2 Parent_Student_Map, 1  student_section entry
			
	 
			try {
				 
				 String[] idPasswordStu =  getIdPassword("Stu",fields[0],fields[1],IM_ID).split("~");
				 String[] idPasswordPar =  getIdPassword("Par",fields[9],fields[10],IM_ID).split("~");
				
				 
				 String autoUserIDStu 					= 	idPasswordStu[0];
				 String autoPasswordStu 					= 	idPasswordStu[1];
				
				 String autoUserIDPar					= 	idPasswordPar[0];
				 String autoPasswordPar 					= 	idPasswordPar[1];
				 System.out.println("");
				 System.out.println(autoUserIDStu+"--stu--"+autoPasswordStu+"--par-"+autoUserIDPar+"--"+autoPasswordPar);
				 
				 UserMaster umaster = new UserMaster();
							umaster.setImId(Long.parseLong(IM_ID));
							umaster.setSmId(Long.parseLong(SM_ID));
							umaster.setBmId(Long.parseLong(BM_ID));
							umaster.setUtId(new Long(5));//5-student
							umaster.setUserId(autoUserIDStu);
							umaster.setPassword(autoPasswordStu);
							umaster.setActive("Y");
						
				
							//Student_First_Name,Student_Last_Name,DOB,Admission_Number,Admission_Date,Class_Admitted_In,Current_Class,Current_Section,Gender,---9
							//Father_First_Name,Father_Last_Name,DOB,Mother_First_Name,Mother_Last_Name,DOB,Primary_Email,Primary_Mobile,Landline,Address1,Address2,City,State		 
							
				StudentDetails studentData =new StudentDetails();
				
				
				int i = 0;
				
				//0									1
				//Student_First_Name,Student_Last_Name,DOB,Email,Mobile,Landline,Address1,Address2,City,State,Admission_Number,Admission_Date,Class_Admitted_in,Gender,Active,
				
				//Student_First_Name,Student_Last_Name,DOB,Admission_Number,Admission_Date,Class_Admitted_In,Current_Class,Current_Section,Gender,---9
				studentData.setFirstName(fields[i++]);
				studentData.setLastName(fields[i++]);
				studentData.setDob(fields[i++]);
				studentData.setAdmissionNumber(fields[i++]);
				studentData.setAdmissionDate(new SimpleDateFormat("yyyy-MM-dd").parse(fields[i++]));
				String classNameO = fields[i++];
				String classID = getClassID(classNameO);
				studentData.setClassAdmittedIn(classID == null?classNameO:classID);//------Class id required,so based on className get the classID...dis is one type validation also
				
				String Current_Class = fields[i++];//section_student_map Table
				String Current_Section = fields[i++];			
				
				studentData.setGender(fields[i++]);
//Father_First_Name (9),Father_Last_Name,DOB,Mother_First_Name(12),Mother_Last_Name,DOB,Primary_Email(15),Primary_Mobile,Landline,Address1(18),Address2,City,State
				studentData.setEmail("NA");
				studentData.setMobile("NA");
				studentData.setLandline("NA");
				studentData.setAddress1(fields[18]);
				studentData.setAddress2(fields[19]);
				studentData.setCity(fields[20]);
				//
				String stateID = getStateID(fields[21]);
				studentData.setState(stateID);
				studentData.setActive("Y");
				
				studentData.setPhoto("noImage.jpg");
				
				
				userMasterDao.save(umaster);
				studentData.setUmId(umaster.getUmId());			
				studentDetailsDao.save(studentData);
				
			//	System.out.println("Student FNmae"+fields[0]+"DOB"+fields[10]+"Parent FNmae"+fields[15]+"DOB"+fields[20]);
				System.out.println(umaster.getUmId()+"--umasterID-");
				
				//father
				 UserMaster umasterPar = new UserMaster();
				 umasterPar.setImId(Long.parseLong(IM_ID));
				 umasterPar.setSmId(Long.parseLong(SM_ID));
				 umasterPar.setBmId(Long.parseLong(BM_ID));
				 umasterPar.setUtId(new Long(2));//2-Parent
				 umasterPar.setUserId(autoUserIDPar);
				 umasterPar.setPassword(autoPasswordPar);
				 umasterPar.setActive("Y");
				 
				 //mother
				 UserMaster umasterMother = new UserMaster();
				 umasterMother.setImId(Long.parseLong(IM_ID));
				 umasterMother.setSmId(Long.parseLong(SM_ID));
				 umasterMother.setBmId(Long.parseLong(BM_ID));
				 umasterMother.setUtId(new Long(2));//2-Parent
				 umasterMother.setUserId(autoUserIDPar);
				 umasterMother.setPassword(autoPasswordPar);
				 umasterMother.setActive("Y");
				
				
				ParentDetails parentData =new ParentDetails();

				ParentDetails motherData =new ParentDetails();
				
				//i start here 9
				parentData.setFirstName(fields[i++]);
				parentData.setLastName(fields[i++]);
				parentData.setDob(fields[i++]);
				
				motherData.setFirstName(fields[i++]);
				motherData.setLastName(fields[i++]);				
				motherData.setDob(fields[i++]);
				
				parentData.setEmail(fields[i]);
				motherData.setEmail(fields[i]);i++;
				parentData.setMobile(fields[i]);
				motherData.setMobile(fields[i]);i++;
				parentData.setLandline(fields[i]);
				motherData.setLandline(fields[i]);i++;
				//Father_First_Name (9),Father_Last_Name,DOB,Mother_First_Name(12),Mother_Last_Name,DOB,Primary_Email(15),Primary_Mobile,Landline,Address1(18),Address2,City,State
				parentData.setAddress1(fields[i]);
				motherData.setAddress1(fields[i]);i++;
				parentData.setAddress2(fields[i]);
				motherData.setAddress2(fields[i]);i++;
				parentData.setCity(fields[i]);
				motherData.setCity(fields[i]);i++;
				parentData.setState(stateID);	
				motherData.setState(stateID);	
				
				parentData.setPtmId("1");
				 parentData.setActive("Y");				
				parentData.setIsDefault("Y");
				parentData.setPhoto("noImage.jpg");
				
				motherData.setPtmId("2");
				motherData.setActive("Y");				
				motherData.setIsDefault("N");
				motherData.setPhoto("noImage.jpg");
				
				userMasterDao.save(umasterPar);
				parentData.setUmId(umasterPar.getUmId());			
				parentDetailsDao.save(parentData);
				//mother
				userMasterDao.save(umasterMother);
				motherData.setUmId(umasterMother.getUmId());			
				parentDetailsDao.save(motherData);
				
				System.out.println(umasterPar.getUmId()+"-umasterParID()"+"$$$$$"+umasterMother.getUmId()+"-umasterMotherID");
				
				ParentStudentMap psm = new ParentStudentMap();
				psm.setActive("Y");
				psm.setPdId(parentData.getPdId()+"");
				psm.setStuId(studentData.getStuId()+"");
				
				//mother
				ParentStudentMap psmM = new ParentStudentMap();
				psmM.setActive("Y");
				psmM.setPdId(motherData.getPdId()+"");
				psmM.setStuId(studentData.getStuId()+"");
				
				
				System.out.println(parentData.getPdId()+"--both--"+studentData.getStuId());
				//Parent_Student Map
				studentDetailsDao.saveStudentParentMap(psm);
				studentDetailsDao.saveStudentParentMap(psmM);
				
				
				//getClassID(Current_Class);
				String secID = getSectionID(Current_Section);
				
				//Student_Section_Map
				StudentSectionMap ssm = new StudentSectionMap();
				ssm.setActive("Y");
				ssm.setSmId(SM_ID);
				ssm.setImId(IM_ID);
				ssm.setBmId(BM_ID);
				ssm.setScmId(secID == null?Current_Section:secID);
				ssm.setStuId(studentData.getStuId()+"");
			
				studentDetailsDao.insertStudentSectionMap(ssm);
				
				
			} catch (Exception e) {
				System.out.println("in exption");
				e.printStackTrace();
				return false;
			}
			return true;
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
	
	private String getSectionID(String sectionName) {
		try {
			// TODO Auto-generated method stub
			SectionMasterDAO sectionMasterdao = (SectionMasterDAO)ServiceFinder.getContext(request).getBean("SectionMasterHibernateDao"); 	
			SectionMaster sectionMasterData = new SectionMaster();
			
			sectionMasterData = 	sectionMasterdao.findByProperty("sectionName", sectionName.trim());
		
		return sectionMasterData.getSeMId()+"";
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
	
	public String getStateID(String StateName) {

		try {
			// TODO Auto-generated method stub
			StateMasterDAO stateMasterdao = (StateMasterDAO)ServiceFinder.getContext(request).getBean("StateMasterHibernateDao"); 	
			StateMaster stateMasterData = new StateMaster();
			
			stateMasterData  = 	stateMasterdao.findByProperty("stateName", StateName.trim());
		
		return stateMasterData.getStateId()+"";
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
				List userlist = userMasterDao.uniqueIDCheck("userId", userID,  "imId", imId);
				
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
		  System.out.println(userID+"~~~~~~~~~~~~"+userPass);
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



