package com.schooltrix.actions;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;


public class DownloadAction extends ActionSupport {  
	   private String path="C://stock//"; 
	   private String fileName;
	   public String getFileName() {
		return fileName;
	}
	   
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public InputStream getInputStream(){  
	      try{  
	             return new FileInputStream(new File(path+fileName));  
	      }catch(Exception e){
	    	  System.out.println(e);
	    	  return null;    
	      }  
	   }  
	   public String execute(){ 
		   System.out.println("fileName"+fileName);
	      return SUCCESS;  
	    }  
	   
	   
	  

/*	@Action(value = "downloadFile", results = { @Result(name = "success", type = "stream", params = { "contentType", "application/octet-stream", "inputName", "fileInputStream", "contentDisposition", "attachment; filename=\"${fileName}.txt\"", "bufferSize", "1024" }) })
	public String downloadFile() throws Exception {
	fileName = "license.txt";
	fileInputStream = new FileInputStream(new File("C:\\", fileName));
	return SUCCESS;
	}
	private InputStream       fileInputStream;
	private String      fileName;
	public InputStream getFileInputStream() {
	return fileInputStream;
	}	*/


}

