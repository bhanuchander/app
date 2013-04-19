package com.schooltrix.TestTemp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang.RandomStringUtils;


import com.sun.org.apache.bcel.internal.generic.FNEG;

public class TestRandom {

	/**
	 * @param args
	 */
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 1000; i++) {
		
			String name = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(10), "jpg");
			System.out.println("name--"+name);
			
		}
	}*/


	    public  String generateUniqueId() {      
	        UUID idOne = UUID.randomUUID();
	        System.out.println("id---"+idOne);
	        String str=""+idOne;        
	        String[] components = str.split("-");
	        if (components.length>4) {
	        	System.out.println("555---------"+components[4]);
				
			} else {

				System.out.println("1111----"+components[0]);
			}
			
	        
	        
	        
	        int uid=str.hashCode();
	        String filterStr="TH"+uid;
	        str=filterStr.replaceAll("-", "");//chances are dr for coming start -number with "-"
	       // System.out.println("--"+filterStr);
	       // return Integer.parseInt(str);
	         return (str);
	    }

	    // XXX: replace with java.util.UUID
	    
	    public void testtt() {
	    	String fname = "ab";
	    	String lname = "efgh";
	    	
	    	System.out.println(fname.length());
	    	System.out.println(lname.length());
	    	String gg = null;
	    	if (fname.length()>2) {
	    		 gg = fname.substring(0, 3);
			}else{
				gg = fname;
			}
			
			String ttt = lname.substring(0, 2);
	    	
			System.out.println(gg+"--------"+ttt);
			
		}
	    
	    public void ytyty() {
	    	//code to shuffle password
			List<String> list=new ArrayList<String>();
   		   	list.add("t");
  		   	list.add("r");
  		   	list.add("i");
  		   	list.add("x");
for (int i = 0; i < 10; i++) {
	StringBuffer stringBuffer=new StringBuffer();
	

  		   	Collections.shuffle(list);
  	
  		   	java.util.Iterator<String> iterator		= list.iterator();
	   		
  		   	while(iterator.hasNext()){
	   			stringBuffer.append(iterator.next());
	   		}
	   		
  		   	String pass	= stringBuffer.toString();
  		   	System.out.println(pass+"1234");
}
		}

	    public void yttttttt() {
			
	    	String domainName = "www.rs.schooltrix.com";
	    	
	    	if(domainName.toLowerCase().startsWith("www.")){
				System.out.println("www.--adding");
				
				int i = domainName.toLowerCase().indexOf("www.");
				System.out.println(i+"=====");
				if(i != -1) {								
				System.out.println("--->"+domainName.substring(i+4));
				
			}
		}
	    }
	    
	    public void Ifcond() {
			int i =0;
			if(i++ == 1 || i++ ==1){
				System.out.println("in if"+i);
			}else{
				System.out.println("in else"+i);
			}
	    	
	    	
	    	
		}
	    
	    
	    public static void main(String[] args) {
	    	
	    	TestRandom tr = new TestRandom();
//	    	tr.testtt();
	    //	tr.ytyty();
	    	//	tr.yttttttt();
	    	tr.Ifcond();
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	   /*     for (int i = 0; i <102; i++) {
	            System.out.println(tr.generateUniqueId());
	            //generateUniqueId();
	        }
	   */     
	        
	    }

	}
	

