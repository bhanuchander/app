	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	
<script 	src="<%=request.getContextPath()%>/dwr/interface/InstitutionMasterDWR.js"></script>
<%-- <script 	src="<%=request.getContextPath()%>/dwr/interface/InstitutionMasterDWR.js"></script> --%>
<%-- <script 	src="<%=request.getContextPath()%>/dwr/interface/HomePageDWR.js"></script> --%>

<%
	if(session.getAttribute("superadmin") != null){
			try{
					String superadmin =(String) session.getAttribute("superadmin");
					 String userType = (String)session.getAttribute("userType");
					 
				/*	String UM_ID = (String)session.get("UM_ID");
					String UT_ID = (String)session.get("UT_ID");
					String fName = (String)session.get("fName");
					String lName = (String)session.get("lName");
					String active = (String)session.get("active"); */
					
					if(superadmin.equalsIgnoreCase("Y") && userType.equalsIgnoreCase("SA")){
					}else{
					response.sendRedirect("BeforeLogin.action");	
					///jsp/HomePage.jsp				
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		}else{
					response.sendRedirect("BeforeLogin.action");					
		
		}

 %>

		
	<script type="text/javascript">
		function validateInstitutionMaster(){
		var patEmail	= /^([\w\-\.]+)@((\[([0-9]{1,3}\.){3}[0-9]{1,3}\])|(([\w\-]+\.)+)([a-zA-Z]{2,4}))$/;					
		var patName		=/^[a-zA-Z-. ]{2,25}$/;
		var patAddress		=/^[a-zA-Z0-9-.,~!@#$%^&*()_+:"?]{2,25}$/;
		var num			= /^[0-9]{8,15}$/;	
		
		var insName			= document.getElementById("insName").value.match(patName);
		var insSName			= document.getElementById("insSName").value.match(patName);
		var insAddr			= document.getElementById("insAddr").value.match(patAddress);
		var insCity				= document.getElementById("insCity").value.match(patName);
		var insCountry			= document.getElementById("insCountry").value.match(patName);
		var insState			= '';
		if(insCountry=="India"){
		insState				= jQuery("#insStates").val();
		}else{
		insState				= jQuery("#insStatei").val();	
		}
		var insContPerson			= document.getElementById("insContPerson").value.match(patName);
		var insEmailID			= document.getElementById("insEmailID").value.match(patEmail);
		var insMobile			= document.getElementById("insMobile").value.match(num);
		var insLandLine			= document.getElementById("insLandLine").value.match(num);
			if(!insName){
				alertDialog('Please enter valid  name');
				return false;
			}if(!insSName){
				alertDialog('Please enter valid institution short name');
				return false;
			}if(!insAddr){
				alertDialog('Please enter valid address');
				return false;
			}if(!insCity){
				alertDialog('Please enter valid city');
				return false;
			}if(!insCountry){
				alertDialog('Please enter valid country');
				return false;
			}if(!insState){
				alertDialog('Please enter valid state');
				return false;
			}if(!insContPerson){
				alertDialog('Please enter valid contact name');
				return false;
			}if(!insEmailID){
				alertDialog('Please enter valid email id');
				return false;
			}if(!insMobile){
				alertDialog('Please enter valid mobile number');
				return false;
			}if(!insLandLine){
				alertDialog('Please enter valid landline number');
				return false;
			}	
		}
		function okAlertDialog () {
			jQuery("#idAlertDialog").modal ('hide'); 
		};
		function alertDialog (prompt) {
			document.getElementById ("idAlertDialogPrompt").innerHTML = prompt;
			jQuery("#idAlertDialog").modal ("show");
		}
		
		function saveInstitutionMasterAndGo(flag){
			//var retrnvalue=validateInstitutionMaster();
			
			var retrnvalue=true;
			
			if(retrnvalue == "false" || retrnvalue == false)
			{
			return false; 
			}
			var  patName 	= /^[a-zA-Z \']{3,25}$/;
			var  patZipCode	= /^[0-9]{3,6}$/;
			var  insName 	= jQuery("#insName").val();
			var  insSName 	= jQuery("#insSName").val();
			var  insAddr 	= jQuery("#insAddr").val();
			var  insCity 	= jQuery("#insCity").val();
			var  insCountry 	= jQuery("#insCountry").val();
			//var  insState 	= jQuery("#insState").val();
			var  insState;
			var  insContPerson 	= jQuery("#insContPerson").val();
			var  insEmailID 	= jQuery("#insEmailID").val();
			var  insMobile 		= jQuery("#insMobile").val();
			var  insLandLine 	= jQuery("#insLandLine").val();
			//var  insActive 	= jQuery("#insActive").val();
		//	var  insActive 	=jQuery('#insActive').prop('checked') ? 'Y':'N';
			var  insActive;
			 if ($('#insActive').is(":checked"))
						{insActive='Y';
						  // it is checked
			} else{insActive='N';}
	
		if(insCountry == "India"){
			insState						=	jQuery("#insStates").val();
			}else{
			insState						=	jQuery("#insStatei").val();
			}
			//Process DWR/AJAX request here
			try{
			alert("in alrttt--saveIns-----"+insState+"-----"+insLandLine+"--flag--"+flag);
			        InstitutionMasterDWR.saveInstitution(
				                                   insName,
				                                   insSName,
				                                   insAddr,
				                                   insCity,
				                                   insCountry,
				                                 	insState,
				                                   insContPerson,
				                                   insEmailID,
				                                   insMobile,
				                                   insLandLine,
				                                   insActive,
				                                   function(data){
				                                   if (data =='saved') {
				                                   //alertDialog("save");
													if(flag == 2){
				                                       document.location ="Access.action?p1=AddAdminUser";
				                                       }else if(flag ==1){
				                                       alertDialog("Instituiton Added.Instituiton Name:"+insName)
				                                       alert("wr to go");
				                                     }
				                                       
													}else {
					                                   alert("exception::"+data);	
													}
					       						}
				                              ) ;    
				 }catch(e){
				 alert("incatch::"+e);
				        jQuery.log.info(e.message);
				        jQuery("#infoError").html("&nbsp;");
        	     } 		
		}
			
				function changeCountry(value){
					document.getElementById("displaySubjecti").style.display="none";
					document.getElementById("displaySubjects").style.display="none";
						if(value == "India"){
							document.getElementById("displaySubjects").style.display="block";
							}
						else{
							document.getElementById("displaySubjecti").style.display="block";
							
						}
				}
			

	/* function saveInstitutionMasterTest(){
			
				var  patName 	= /^[a-zA-Z \']{3,25}$/;
				var  patZipCode	= /^[0-9]{3,6}$/;
				
				var  insName 	= jQuery("#insName").val();
				var  insSName 	= jQuery("#insSName").val();
				var  insAddr 	= jQuery("#insAddr").val();
				var  insCity 	= jQuery("#insCity").val();
				var  insCountry 	= jQuery("#insCountry").val();
				var  insState 	= jQuery("#insState").val();
				var  insContPerson 	= jQuery("#insContPerson").val();
				var  insEmailID 	= jQuery("#insEmailID").val();
				var  insMobile 		= jQuery("#insMobile").val();
				var  insLandLine 	= jQuery("#insLandLine").val();
				var  insActive 	= jQuery("#insActive").val();
				var  action 	= "UI";
				//Process DWR/AJAX request here
				try{
				alert("in alrttt--saveInstitutionMaster::::"+insName+"--::::insSName"+insSName+"88888:::");
				
				
					 InstitutionMasterAction.Test3(
					 														"fortest",
					 														"seccc",
					 														"thirddd",
					 														function(data){alert("in fiffefefefefefrst"+data);
					 
				     });
			/* 	       InstitutionMasterAction.Test1(insName,function(data){
					                                   alert("dattta::"+data);
							                                  /*  if(data=='1'){				                                   
								                        jQuery("#infoError").html("Succesfully saved").animate({ opacity: 0
																																													}, 3000, function() {
															jQuery("#infoSaveBtn").show();
																																													 });							
								                                }else{
								                                      //jQuery("#infoError").html("Please enter valid details");	
								                                      jQuery("#infoSaveBtn").show();
								                                      setError("uzCode",'Please enter valid details');
								                                      
								                                     } *//*
			                                   		                                   
					                                   }
					                              ) ;   
					                                  *//*
					                             InstitutionMasterAction.Test1(function(data){alert("in first"+data);
				     });   
					 }catch(e){
					 alert("incatch");
					       // jQuery.log.info(e.message);
					       // jQuery("#infoError").html("&nbsp;");
	        	     } 		
				 										
				
			}
 */




</script>
	
<div style="height:40px;"></div>
<div class="reg_mainCon">
  <form>
    <fieldset>
    <legend><img src="img/list_add_user.PNG" class="img-circle">&nbsp;&nbsp;Create Institution</legend>
    <div style="padding:20px;">
      <label style="color:#000;"></label>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <label style="color:#000;"><b>Institution Name</b></label>
                  <input class="span3" type="text" placeholder=""  name="insName" id="insName">                </td>
          <td>
                    <label style="color:#000;"><b>Institution Short Name</b></label>
                    <input class="span3" type="text" placeholder=""  name="insSName" id="insSName">              </td>
        </tr>
            <tr>
                <td colspan="2">
                <label style="color:#000;"><b>Address</b></label>     
                <textarea style="width:82%;" rows="3"  name="insAddr" id="insAddr"></textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <label style="color:#000;"><b>City</b></label>
                    <input class="span3" type="text" placeholder=""  name="insCity" id="insCity">                </td>
           <!--    
                <td>
                    <label style="color:#000;"><b>Country</b></label>
                    <input class="span3" type="text" placeholder=""  name="insCountry" id="insCountry">                </td>
            </tr>
            <tr>
               <td>
                    <label style="color:#000;"><b>State</b></label>
                    <input class="span3" type="text" placeholder=""  name="insState" id="insState">                </td>
        -->
            <td ><label style="color:#000;"><b>Country</b></label>            
             <select  class="span3"  name="select" name="insCountry"  id="insCountry"><!--  onchange="changeCountry(this.value)"  -->
				   <option value="India"  selected="selected">India</option><option value="Indonesia">Indonesia</option>
             </select> 
           </td>
        </tr><tr>
      <!--     <td ><label style="color:#000;"><b>State</b></label></td>
       
          <td ><div align="left">
            <input class="span3" type="text" placeholder="" name="state"  id="state">
          </div>
           -->
          		  <td ><label style="color:#000;"><b>State</b></label>			    
			    <div id="displaySubjecti" style="display:none;">
					    <input  class="span3" type="text"  id="insStatei" name="insStatei"  />
				</div>
				<div id="displaySubjects" style="display:show;">
					 <select   class="span3" id="insStates" name="insStates">
				   <option value="1">Andhra Pradesh</option>
                   <option value="2">Madya pradesh</option>
				   <option value="3">Bihar</option>
				   </select>				
             </div>
          </td>
                <td>
                    <label style="color:#000;"><b>Contact Person</b></label>
                    <input class="span3" type="text" placeholder=""  name="insContPerson" id="insContPerson"></td>
            </tr>
            <tr>
                <td>
                    <label style="color:#000;"><b>Email ID</b></label>
                    <input class="span3" type="text" placeholder=""  name="insEmailID" id="insEmailID"></td>
                <td>
                    <label style="color:#000;"><b>Mobile</b></label>
                    <input class="span3" type="text" placeholder=""  name="insMobile" id="insMobile"></td>
            </tr>
            <tr>
                <td>
                    <label style="color:#000;"><b>Landline</b></label>
                    <input class="span3" type="text" placeholder=""  name="insLandLine" id="insLandLine"></td>
                <td>
                    <label style="color:#000;"><b>Active</b></label>   
                    <input type="checkbox"  name="insActive" id="insActive" checked="checked">
                    </td>
            </tr>
            <tr>
             <td style="border:none;">
                <button type="button" class="btn" onclick="saveInstitutionMasterAndGo(1);">Save</button> 
                <button type="button" class="btn"  onclick="saveInstitutionMasterAndGo(2);">Save and Add User</button></td>
            <td style="border:none;">&nbsp;</td>
        </tr>
        </table>
    </div>
    </fieldset>
  </form>
</div>
<div style="height:20px;"></div>

<!-- /container -->
 <div id="idAlertDialog" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="windowTitleLabel" aria-hidden="true">
            <img src="img/alert.gif" width="34" height="28" alt="alert icon">
            <h3 id="idAlertDialogPrompt"></h3>
            <a href="#" class="btn btn-primary" onclick="okAlertDialog ();">OK</a>
            </div>

