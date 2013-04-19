<%@page import="org.json.JSONArray"%>
<%@page import="com.schooltrix.dtos.SMSCapmaignDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
<%@page import ="java.util.*" %>   
	    <link href="css/bootstrap.css" rel="stylesheet">
 		<style type="text/css">
	span.mandatory {
		    color: #FF0000;
		    display: inline;
		}

			
.divDemoBody  {
                width: 60%;
                margin-left: auto;
                margin-right: auto;
                margin-top: 100px;
                }
            .divDemoBody p {
                font-size: 18px;
                line-height: 140%;
                padding-top: 12px;
                }
            .divDialogElements input {
                font-size: 18px;
                padding: 3px;
                height: 32px;
                width: 500px;
                }
            .divButton {
                padding-top: 12px;
                }
            .btn {
                /*width: 80px;*/
                margin-left: 5px;
                }
             #idAlertDialog {
                width: 450px;
                height: 225px;
                background-color: whitesmoke;
                }
             #idAlertDialog .btn {
                width: 70px;
                margin-bottom: 8px;
                margin-right: 155px;
                margin-top: 45px;
                float: right;
                }
             #idAlertDialog h3 {
            
                margin-top:15px;
                }
             #idAlertDialog img {
                float: left;
                margin-left: 15px;
                margin-top: 15px;
                }
                #idConfirmDialog {
				width: 450px;
				height: 165px;
				background-color: whitesmoke;
				}
			 #idConfirmDialog .btn {
				width: 70px;
				margin-bottom: 8px;
				margin-right: 15px;
				margin-top: 80px;
				float: right;
				}
			 #idConfirmDialog h3 {
				margin-left: 60px;
				margin-top:15px;
				}
			 #idConfirmDialog img {
				float: left;
				margin-left: 15px;
				margin-top: 15px;
				}
</style>


	<%
	SMSCapmaignDto dto = (SMSCapmaignDto) request.getAttribute("dto");
	System.out.println(dto.getSmsbody()+":::::sms body");
	
	String smsBody = dto.getSmsbody() != null?dto.getSmsbody() : "";
	String totalChars = dto.getLimit() != null?dto.getLimit() : "";
	String smsCredits = dto.getSMSCredit() != null?dto.getSMSCredit() : "0";
	String numberOfSms = dto.getSMSCount() != null?dto.getSMSCount() : "0";
	String balanceSMScredits = null;
		try{
		System.out.println(smsCredits+"::"+numberOfSms);
			balanceSMScredits =( Integer.parseInt(smsCredits)-Integer.parseInt(numberOfSms))+"";
		}catch(Exception e){
			System.out.println(smsCredits+":exxxxxxx:"+numberOfSms);
			balanceSMScredits = "0";
			e.printStackTrace();
		}
	
	 %>
	
	<%JSONArray userdata =null;
	try{
	//request.setAttribute("usersData1",(ArrayList<String[]>) request.getAttribute("usersData"));
		userdata  =(JSONArray) request.getAttribute("usersData");
	}catch(Exception ex){
	}
	
	 %>

	    <script 	src="<%=request.getContextPath()%>/dwr/interface/SentSMSDWR.js"></script>
	    
	<script type="text/javascript">
	
		function okAlertDialog () {
			$("#idAlertDialog").modal ('hide'); 
		};
		function alertDialog (prompt) {
			document.getElementById ("idAlertDialogPrompt").innerHTML = prompt;
			$("#idAlertDialog").modal ("show");
		}
	function previewSMSValidate1(){
	var body =/^[A-Za-z0-9].+$/;
	var subj			=  jQuery("#sms_body").val().match(body);
		if(!subj){
			alertDialog('Please enter valid subject');
			return false;
		}
		alertDialog('All validations cleared');

	}
	
	   function sendSmS(){
		alert('preview');
			
		}
	function tellMeMore(call){
	
		var myWindow = window.open("", "Schooltrix", "height=600,width=800,scrollbars=1,location=no,menubar=no,resizable=1,status=no,toolbar=no");
	
		
		var dtt = '<%=userdata%>';
		var performence_json	=  jQuery.parseJSON(dtt);
	
		var innerHtmlone='<table width="100%" cellspacing="1" cellpadding="0" border="0"><tr><th width="15%" style="font-size:12px;border:1px solid #d7d7d7; background:#d7d7d7;line-height:25px;text-align:left; padding-left:5px"><strong>Name</strong></th><th width="15%" style="font-size:12px;border:1px solid #d7d7d7;background:#d7d7d7;line-height:25px;text-align:left;"><div align="center"><strong>Phone Number</strong></div></th></tr>';
	
	for ( var i = 0; i < performence_json.length; i++) {
 		 	var obj = performence_json[i];
		    var nameU      =  obj.First_Name+" "+obj.Last_Name;
			var numberU	    =	obj.Mobile;	
			innerHtmlone += ' <tr>';
			innerHtmlone +='    <td style="font-size:12px;border:1px solid #d7d7d7;line-height:25px;text-align:left;"><div align="center">'+nameU+'</div></td>';
			innerHtmlone +='    <td style="font-size:12px;border:1px solid #d7d7d7;line-height:25px;text-align:left;"><div align="center">'+numberU+'</div></td>';
			innerHtmlone +='  </tr>';	    
	}
		myWindow.document.write(innerHtmlone);
		}
		

	function limiter(){
	var tex = document.smsSent.sms_body.value;
	var len = tex.length;
/* 	if(len >120){
	        tex = tex.substring(119,count);
	        document.smsSent.comment.value =tex;
	        return false;
	} */
	document.smsSent.limit.value = len;
	}
	
	function sendSMSCall(){
	
		var retrnvalue=previewSMSValidate1();
			if(retrnvalue == "false" || retrnvalue == false)
			{
			return false; 
			}
				var  patName 	= /^[a-zA-Z \']{3,25}$/;
				var  patZipCode	= /^[0-9]{3,6}$/;
				
				var  smsCredits 		= jQuery("#sms_credits").val();
				var  smsBodyText 	= jQuery("#sms_body").val();
				var  sentUsersCount 	= jQuery("#sent_Sms_Count").val();
				var  smsBalcredits 	= jQuery("#sms_Balcredits").val();
				var 	usersList				 = '<%=userdata%>';
				var IM_ID ='<%=session.getAttribute("IM_ID")%>';
				var BM_ID ='<%=dto.getBM_ID()%>';
				var SM_ID ='<%=dto.getSM_ID()%>';
				
				alert(IM_ID+"--"+SM_ID+"--"+BM_ID);
				
				var path='<%=request.getContextPath()%>'+'/'+ 'adduserForm.action';
				
				//after validation--we r asking confirm box..
				
				
			// if (alertDialog('Do you want to send the SMS now. Yes | No'))
			 if (confirm('Do you want to send the SMS now. Yes | No'))
			    {
			        
				//Process DWR/AJAX request here
				try{
				
				        SentSMSDWR.sendSMSCall(
					                                   smsCredits,
					                                   smsBodyText,
					                                   sentUsersCount,
					                                   smsBalcredits,
					                                   usersList,
					                                   IM_ID,
					                                   BM_ID,
					                                   SM_ID,					                                 
					                                   function(data){
					                                   if (data =='success') {
					                                   alert("Success");
													document.location ="Access.action?p1=UserSMS";
												
														} else if (data =='No Users'){
														document.location ="Access.action?p1=UserSMS";
						                                   alert("No Users");
														}else{
						                                   alert("Server Error");
						                                   document.location ="Access.action?p1=UserSMS";
														}
					                                   }
					                              ) ;    
					 }catch(e){
							 alert("incatch::"+e);
					        jQuery.log.info(e.message);
					        jQuery("#infoError").html("&nbsp;");
	        	     } 		
				 	
			    }else{
			    alert("Thanx");
			    document.location ="Access.action?p1=UserSMS";
			    }									
				
			}
	
	
	
	</script>
	
	<div style="height:80px;"></div>
<div class="reg_mainCon">
  <form  method="post"  name="smsSent">
    <fieldset>
    <legend><img src="img/list_add_user.PNG" class="img-circle">&nbsp;&nbsp;SMS Preview</legend>
    <div style="padding:20px;">
      <label style="color:#000;"></label>
   <table width="100%" border="0" cellspacing="0" cellpadding="0">
   
   		<tr>
             <td colspan="2"><label style="color:#000;text-align:right;"><b>SMS Credits:</b>
             <input type="text" placeholder=""  style="width:55px;margin-right:20px;" disabled="disabled" name="sms_credits" id="sms_credits" value="<%=smsCredits%>"	></label></td>
        </tr>
   
        <tr>
                <td><label style="color:#000;"><b>SMS</b></label></td>
                <td><textarea style="width:96%;" rows="3"  name="sms_body" id="sms_body" onkeyup="limiter()" wrap="physical" ><%=smsBody %></textarea></td>
        </tr>
        <tr>
                <td><label style="color:#000;"><b>Total Characters</b></label></td>
                <td>       <script type="text/javascript">
document.write("<input type=text style=width:55px; name=limit size=4 readonly value='<%=totalChars%>'>");
</script></td>
          		
        </tr>
        <tr>
               <td><label style="color:#000;"><b>No.of SMS to be sent</b></label></td>
               <td><input class="span4" type="text" style="width:55px;"  placeholder="" disabled="disabled" name="sent_Sms_Count" id="sent_Sms_Count" value="<%=numberOfSms %>">
                <a style="color:#000000;" href="#" onclick="tellMeMore('audience'); return false">View audience</a></td>
        </tr>
          <tr>
             <td><label style="color:#000;"><b>Current SMS Credits</b></label></td>
                <td><input class="span4" style="width:55px;"  type="text" placeholder="" disabled="disabled"  name="sms_Ccredits" id="sms_Ccredits" value="<%=smsCredits %>"></td>
        </tr>
         <tr>
             <td><label style="color:#000;"><b>Balance SMS Credits</b></label></td>
                <td><input class="span4" style="width:55px;" type="text" placeholder="" disabled="disabled"  name="sms_Balcredits" id="sms_Balcredits" value="<%=balanceSMScredits%>"></td>
        </tr>
        
  <tr>
            <td style="border:none;text-align:center;" colspan="2">
                     <button type="button" class="btn"  onclick="sendSMSCall();return false">Send SMS</button>
                 <!--        <button type="submit" class="btn">Send SMS</button> -->
                    </td>
        </tr>

       </table>

    </div>
    </fieldset>
  </form>
</div>

   <div id="idAlertDialog"    class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="windowTitleLabel" aria-hidden="true">
            <img src="img/alert.gif" width="34" height="28" alt="alert icon">
            <h3 id="idAlertDialogPrompt"></h3>
            <a href="#" class="btn btn-primary" onclick="okAlertDialog ();">OK</a>
            </div>