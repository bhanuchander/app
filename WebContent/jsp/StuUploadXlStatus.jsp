<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	
	
	
	<%
String msg			= (String)session.getAttribute("msg"); 
String resultString			= (String)session.getAttribute("result"); 

//String[] resultSplit = resultString.split("~");

String[] resultSplit = {"5","0","1","10"};

if(msg !=null)
session.removeAttribute("msg");
 if(resultString !=null)
session.removeAttribute("result"); 

System.out.println("msg"+msg);
%>
    
	  	<script type="text/javascript">
	function getErrorReport(){
	//dwr for getting error details from DB
	
	alert("Comming SOON");
	
	
	}
	
	
		</script > 



 <div style="height:50px;"></div>
	<div class="reg_mainCon">

     <fieldset>
	    <legend><img src="img/list_add_user.PNG" class="img-circle">&nbsp;&nbsp;Student File Upload Status Report</legend>
	    <div style="padding:20px;">
	          <label style="color:#000;"></label>
	 
	   <table width="100%" border="0" cellspacing="0" cellpadding="0" style="color: #000;">
		           <tr><td><label style="color:#000;"><b><%=resultSplit[0] %></b></td><td></label><label>records Uploaded</label></td></tr>
		           <tr><td><label style="color:#009B00"><b><%=resultSplit[1] %></b></td><td></label><label>new records entered</label></td></tr>
		           <tr><td><label style="color:#CCCC66;"><b><%=resultSplit[2] %></b></td><td></label><label>existing records ignored</label></td></tr>
		           <tr><td><label style="color:#FF0D0D"><b><%=resultSplit[3] %></b></td><td></label><label>records had errors <b><a style="color: #FF0D0D;"  onclick="getErrorReport();">View</a></b></label></td></tr>
	       </table>
	    </div>
	  
    </fieldset>
</div>
    