package com.schooltrix.dwr;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContextFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import com.schooltrix.daos.StudentDetailsDAO;
import com.schooltrix.hibernate.ClassMaster;
import com.schooltrix.hibernate.StudentDetails;
import com.schooltrix.hibernate.StudentxlErrorTemp;
import com.schooltrix.hibernate.UserMaster;
import com.schooltrix.managers.ServiceFinder;
import com.schooltrix.utils.StudentDetailsAnalysis;

public class StudentDWR {

	HttpServletResponse response = WebContextFactory.get().getHttpServletResponse();
	HttpServletRequest request = WebContextFactory.get().getHttpServletRequest();
	HttpSession session = WebContextFactory.get().getSession();
	
	public List getErrorMsg() {
		
		 StudentDetailsDAO studentDetailsDao = (StudentDetailsDAO)ServiceFinder.getContext(request).getBean("StudentDetailsDAO");
		 String um_id = (String)session.getAttribute("UM_ID");
		 System.out.println("um_id---"+um_id);
		 List errorLog  = null;
		 List<Object[]> errorList= new ArrayList<Object[]>();
		 try {
			errorLog = studentDetailsDao.getStudentErrorLog(um_id);	
		 
			System.out.println("** size"+errorLog.size());
					for (int i = 0; i < errorLog.size(); i++) {
						String[] oioio = new String[2];
						StudentxlErrorTemp ioio = (StudentxlErrorTemp)errorLog.get(i);
						System.out.println("--error line---"+ioio.getErrorline());
						oioio[0] = ioio.getErrorline();
						oioio[1] = ioio.getReason();
						errorList.add(oioio);
					}
		return errorList;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}
	
	
	public String getStudentData() {
		
		try {
			StudentDetails studentDetails = null;
			String classID = null;
			String studentID = null;
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			
			JSONObject jsonObject = new JSONObject();
			
			String UM_ID = (String)session.getAttribute("UM_ID");
			String pdID = (String)session.getAttribute("pdID");
			
			String IM_ID = (String)session.getAttribute("IM_ID");
			String SM_ID = (String)session.getAttribute("SM_ID");
			String BM_ID = (String)session.getAttribute("BM_ID");
			String shortName =(String) session.getAttribute("IM_SN");

			classID 		= (String)session.getAttribute("ClassID");
			studentID 	= (String)session.getAttribute("StuID");//these two value set by NotificationDWr class....
			
			StudentDetailsAnalysis studentDetailsAnalysis = new StudentDetailsAnalysis(request);
			studentDetails = studentDetailsAnalysis.getStudentDetails( pdID, BM_ID);

			if (studentDetails != null) {
				UserMaster userMaster =studentDetailsAnalysis.getUserMaster(studentDetails.getUmId());
				jsonObject.put("StuUserID", userMaster == null ? "" : userMaster.getUserId());
				jsonObject.put("StuName", studentDetails.getFirstName()+studentDetails.getLastName());
				jsonObject.put("DOB", sdf.format(sdf1.parse(studentDetails.getDob())));
				
				System.out.println(studentDetails.getDob()+"****"+sdf.parse(studentDetails.getDob())+"****"+sdf.format(sdf1.parse(studentDetails.getDob())));
				
				ClassMaster classMaster = studentDetailsAnalysis.getClassName(classID);
				jsonObject.put("className", classMaster == null ? "" : classMaster.getClassName() );
				jsonObject.put("joinDate",  sdf.format(sdf1.parse(studentDetails.getAdmissionDate())));
				//	String path			= request.getSession().getServletContext().getRealPath("/")+"UploadDoc/"+shortName+"/"+assignType;
				//return new FileInputStream(new File(path+"/"+assignFileName));
				System.out.println("Photo Loc-->"+session.getServletContext().getRealPath("/")+"uploaded/"+shortName+"/ST/"+studentDetails.getPhoto());
				jsonObject.put("photoID", "/uploaded/"+shortName+"/ST/"+studentDetails.getPhoto());		
				System.out.println("json-->"+jsonObject);
			}
			return jsonObject.toString();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
