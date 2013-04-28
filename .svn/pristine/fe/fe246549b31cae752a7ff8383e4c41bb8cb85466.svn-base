	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
    	
    	<% 
    	
    	
    		if(session.getAttribute("short_name") != null  && ((String)session.getAttribute("userType")).equalsIgnoreCase("AD")&& session.getAttribute("superadmin") == null ){
    			if(session.getAttribute("IM_ID")!= null &&session.getAttribute("SM_ID")!= null &&session.getAttribute("BM_ID")!= null &&session.getAttribute("UM_ID")!= null){
    			}else{response.sendRedirect("BeforeLogin.action");	
    			}
    		}else{
    		response.sendRedirect("BeforeLogin.action");	
    		}
    	
    	%>
    	
    	
    	<!-- css -->
	    <link href="css/bootstrap-fileupload.css" rel="stylesheet" media="screen">	   
    	<link href="css/datepicker.css"  rel="stylesheet" type="text/css" media="screen"  >
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
    	
    	
    	
    <!-- 	 <script type="text/javascript"
     src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
    </script> -->
<!--     <script type="text/javascript"
     src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
    </script> -->
  
 	  <!-- 
      <script type="text/javascript"
     src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
     </script>
         --><!--  <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
    </script> -->
    
	    <!-- javascripts -->
	    <script src="js/bootstrap-datetimepicker.min.js"> </script>
    	<script  src="js/bootstrap-datetimepicker.pt-BR.js"> </script>
    	
	    <script src="js/bootstrap-fileupload.js" type="text/javascript"></script>
    	
    	<!-- DWR calls -->
	    <script 	src="<%=request.getContextPath()%>/dwr/interface/UserTypeMasterDWR.js"></script>
	    <script 	src="<%=request.getContextPath()%>/dwr/interface/UserMasterDWR.js"></script>
	    <script 	src="<%=request.getContextPath()%>/dwr/interface/EmailDomainDWR.js"></script>
	    
		<script type="text/javascript">
		    
/*       			
      			function changeCountry(value){
					document.getElementById("displaySubjecti").style.display="none";
					document.getElementById("displaySubjects").style.display="none";
						if(value == "India"){
							document.getElementById("displaySubjects").style.display="block";
							}
						else{
							document.getElementById("displaySubjecti").style.display="block";
							
						}
				} */
				
		function okAlertDialog () {
			$("#idAlertDialog").modal ('hide'); 
		};
		function alertDialog (prompt) {
			document.getElementById ("idAlertDialogPrompt").innerHTML = prompt;
			$("#idAlertDialog").modal ("show");
		}
      		
      	function	changeUserRights(value){
      			document.getElementById("designation").style.display="none";

						if(value == "TC" || value == "NTS" ||value == "Admin"){	
					
							document.getElementById("designation").disabled=false;		
						document.getElementById("designation").style.display="block";
						
						document.getElementById("isParent").disabled=false;		
						document.getElementById("isParent").style.display="block";
						
						document.getElementById("parentTypeSel").style.display="block";						
						document.getElementById("parentTypeSel").disabled=true;	
						
						document.getElementById("admissionOne").style.display='none';
						document.getElementById("admissionTwo").style.display='none';
							}
						else{
						//	document.getElementById("designation").style.display="none";	
						document.getElementById("designation").style.display="block";						
						document.getElementById("designation").disabled=true;	
							
						document.getElementById("isParent").style.display="block";						
						document.getElementById("isParent").disabled=true;	

						document.getElementById("parentTypeSel").disabled=false;		
						document.getElementById("parentTypeSel").style.display="block";
					
						document.getElementById("admissionOne").style.display='none';
						document.getElementById("admissionTwo").style.display='none';
						if(value == "ST"){ 
							 document.getElementById("admissionOne").style.display='';
						    document.getElementById("admissionTwo").style.display='';
						    
						    document.getElementById("parentTypeSel").disabled=false;		
							document.getElementById("parentTypeSel").style.display="block";
						
						    }			
					
						}
      	}
      	
      	function isParentCheck() {
      	
			if(document.getElementById("isParent").checked == true) {
				document.getElementById("parentTypeSel").disabled=false;		
				document.getElementById("parentTypeSel").style.display="block";
			}else {
				document.getElementById("parentTypeSel").style.display="block";						
				document.getElementById("parentTypeSel").disabled=true;	
			}
		} 	
      			
    	</script>
	    <script>
	    var userTypes;
	    function addUser(){
	    
	    		var  patName 	= /^[a-zA-Z \']{3,25}$/;
				var  patZipCode	= /^[0-9]{3,6}$/;
				
				var  userID 				= 	jQuery("#userID").val();
				var  fname 				= 	jQuery("#fname").val();
				var  password 			= 	jQuery("#password").val();
				var  lname 				= 	jQuery("#lname").val();
				var  cPassword 		= 	jQuery("#cPassword").val();
				var  userRights 		= 	jQuery("#userRights").val();
				var  dob 					=	 jQuery("#dob").val();
				var  designation 		=	jQuery("#designation").val();
				var  email 					= 	jQuery("#email").val();
				var  mobile 				= 	jQuery("#mobile").val();
				var  landline 			= 	jQuery("#landline").val();
				var  isParent 			= 	jQuery("#isParent").val();				
				var  addr1 				= 	jQuery("#addr1").val();
				var  addr2 				= 	jQuery("#addr2").val();				
				var  city 						= 	jQuery("#city").val();
				var  country 				= 	jQuery("#country").val();
				var  state;
				if(country == "India"){
				state						=	jQuery("#states").val();
				alert("state1::"+state);
				}else{
				state						=	jQuery("#statei").val();
				alert("state2::"+state);
				}
				//var  state				 	= 	jQuery("#state").val();
				var  fileUP 				= 	jQuery("#fileUP").val();
				var  active 				=	jQuery("#active").prop('checked') ? 'Y':'N';

				//var image = dwr.util.getValue("fileUP");
				//dwr.util.setValue("fileUP", null);
	//image upload using dwr
	

				//Process DWR/AJAX request here
				try{
				alert("in alrttt--save user---------"+active+"-----"+fileUP);
				       UserMasterDWR.addUser(//19 params
					                                   userID,
					                                   password,
					                                   fname,
					                                   lname,
					                                   userRights,
					                                   dob,
					                                 	designation,
					                                   email,
					                                   mobile,
					                                   	landline,
					                                   	isParent,
					                                   addr1,
					                                   addr2,
					                                   city,
					                                   country,
					                                   state,
					                                   fileUP,
					                                   active,
					                                   function(data){
					                                   if (data =='saved') {
														
					                                   alert("save::"+data);
													} else {
					                                   alert("exception::"+data);

													}
					                                   
					                                   
					                                   alert("data::"+data);
					                                   }
					                              ) ;    
					 }catch(e){
					 alert("incatch::"+e);
					        jQuery.log.info(e.message);
					        jQuery("#infoError").html("&nbsp;");
	        	     } 		
				 							
	    
	
	    alert("hiii");
	   }
	    function getUserTypeMaster(){
				//Process DWR/AJAX request here
				try{
				//alert("in alrttt--getUserTypeMaster");
					var dd = document.getElementById('userRights');
				     /*    UserTypeMasterDWR.userTypeMaster(function(data){
					                                   if (data ==null) {														
					                                   alert("exception::"+data);
													} else {
						                                 userTypes=data;
						                                   alert("save::"+data);
						                                   
														for(var i = 0; i < data.length; i++) {
														    var opt = document.createElement('option');
														    opt.innerHTML = data[i];
														    opt.value = data[i];
														    dd.appendChild(opt);
														}
													}
					                         }
					      ) ;     */
					 }catch(e){
					 alert("incatch::"+e);
					        jQuery.log.info(e.message);
					        jQuery("#infoError").html("&nbsp;");
	        	     }
				 										
				
			}
				    
		function uniqueEmailCheck(){
			var emailID = jQuery("#email").val();
			var userType = jQuery("#userRights").val();
			EmailDomainDWR.isEmailCheck(
													emailID,
													userType,
													function(data){								
					                                   if (data =="false") {
					                                  // alert("not found"+data);											
														} else {						                                
						                                   alert("Email Id Already Exist::"+data);
						                                   		jQuery("#email").focus();			                              		                                   													
														}
					                        	 }
					      ); 
					
		}		    
		
		function emailCheck(){
		
				var value1=jQuery("#userRights").val();
		//alert("valll--"+value1);
		if(value1 == "TC" || value1 == "NTS" ||value1 == "PA"||value1 == "admin"){
			//	alert("in ifff");					
				uniqueEmailCheck();			
	    	}else{
	    	//alert("jijij");
	    	}
		
		}
				    
	    function onloadmethods(){
	 //   alert("in onload");
		getUserTypeMaster();
		resultPopUp();

	    }
	    function addUserFormSubmit(){
	   // alert(document.getElementById("city").value);
	   // document.getElementById("addform").submit();
	    form = document.forms[addform]; //assuming only form.
		form.submit();
	    }
	    function resultPopUp(){
	    	var nonadminmsg = "<%=session.getAttribute("nonadminMsg")%>";
	    	var userID = "<%=session.getAttribute("userIDD")%>";
		    var password =  "<%=session.getAttribute("passwordd")%>";
		    if(userID == null || password == null || userID == "null" || password == "null"){
		     if(nonadminmsg != null && nonadminmsg != "null" ){
		    alertDialog("<div style='padding-left:50px; text-align:center; margin-top: 15px;'> "+nonadminmsg+".</div>");		
		    <%session.removeAttribute("nonadminMsg"); %> ;     
		     }
		    // alertDialog("<div style='padding-left:50px; text-align:center; margin-top: 15px;'> Success.<br/> Your ID : "+"TH676767676"+"<br/>Password : "+"yu76767hhgh6"+"</div>");
		    }else{
		    alertDialog("<div style='padding-left:50px; text-align:center; margin-top: 15px;'> "+nonadminmsg+".<br/> Your ID : "+userID+"<br/>Password : "+password+"</div>");
		    }
		     if(userID != null){
		 		<%session.removeAttribute("userIDD"); %> ;
		 		<%session.removeAttribute("passwordd"); %> ;
		 		<%session.removeAttribute("nonadminMsg"); %> ;
		     }
	    }
	    
	 function validateNonAdminUser(addNonAdminUser){
	    
	    var patEmail	= /^([\w\-\.]+)@((\[([0-9]{1,3}\.){3}[0-9]{1,3}\])|(([\w\-]+\.)+)([a-zA-Z]{2,4}))$/;					
		var patName		=/^[a-zA-Z-. ]{2,25}$/;
		var patAddress		=/^[a-zA-Z_0-9@\!#\$\^%&*()+=\-[]\\\';,\.\/\{\}\|\":<>\? ]{2,25}$/;
		var patNum			= /^[0-9-+ ]{8,15}$/;
		var patBody =/^[A-Za-z0-9 ].+$/;
		var patDob			= /^[0-9- ]{10}$/;

				var  fname 				= 	jQuery("#fname").val().match(patName);
				var  lname 				= 	jQuery("#lname").val().match(patName);
				var  dob 				= 	jQuery("#dob").val().match(patDob);
				var  userRights 		= 	jQuery("#userRights").val();
				var  email 				= 	jQuery("#email").val().match(patEmail);
				var  mobile 				= 	jQuery("#mobile").val().match(patNum);
				var  landline 			= 	jQuery("#landline").val().match(patNum);
				var  addr1 				= 	jQuery("#addr1").val().match(patBody);
				var  addr2 				= 	jQuery("#addr2").val().match(patBody);				
				var  city 				= 	jQuery("#city").val().match(patName);
				var state				= 	jQuery("#state").val();
				var country=jQuery("#country").val();
				var parentTypeSel		=	jQuery("#parentTypeSel").val();
				var admissionNumber		=   jQuery("#admissionNumber").val().match(patNum);
				var admissionDate		=   jQuery("#admissionDate").val().match(patDob);
				var classAdmittedIn		=   jQuery("#classAdmittedIn").val().match(patBody);
				/* var  cPassword 			= 	jQuery("#cPassword").val();
				var  userRights 		= 	jQuery("#userRights").val();
				var  dob 					=	 jQuery("#dob").val();
				var  designation 		=	jQuery("#designation").val();
				var  email 					= 	jQuery("#email").val();
				var  isParent 			= 	jQuery("#isParent").val();				
				var  country 				= 	jQuery("#country").val();
				var  state;
				if(country == "India"){
				state						=	jQuery("#states").val();
				}else{
				state						=	jQuery("#statei").val();
				}
				//var  state				 	= 	jQuery("#state").val();
				var  fileUP 				= 	jQuery("#fileUP").val();
				var  active 				=	jQuery("#active").prop('checked') ? 'Y':'N';	
				 */
				if(!fname){
				alertDialog('please enter valid First Name ');
				return false;
				}
				if(!lname){
				alertDialog('please enter valid Last Name ');
				return false;
				}
				 if(!dob){
				alertDialog('please enter valid DOB ');
				return false;
				} 
				if(userRights=="Select"){
				alertDialog('please select User Rights ');
				return false;
				}
				if(!email){
				alertDialog('please enter valid Email ');
				return false;
				}
				if(!mobile){
				alertDialog('please enter valid Mobile ');
				return false;
				}
				if(!landline){
				alertDialog('please enter valid Landline ');
				return false;
				}
				if(!addr1){
				alertDialog('please enter valid Address 1 ');
				return false;
				}
				if(!addr2){
				alertDialog('please enter valid Address 2 ');
				return false;
				}
				if(!city){
				alertDialog('please enter valid City ');
				return false;
				}
				if(state=="Select"){
				alertDialog('please select State');
				return false;
				}
				if(country=="Select"){
				alertDialog('please select Country');
				return false;
				}
				if(userRights !="ST"){
				if(parentTypeSel=="Select"){
				alertDialog('please select Parent Type');
				return false;
				
				}
				}
				if(userRights=="ST"){
					if(!admissionNumber){
					alertDialog('please enter valid AdmissionNumber ');
					return false;
					}
					if(!admissionDate){
					alertDialog('please enter valid Admission Date ');
					return false;
					}
					if(!classAdmittedIn){
					alertDialog('please enter valid ClassAdmittedIn ');
					return false;
					}
				}
				if(isParent=="Y"  && parentTypeSel=="Select"){
				alertDialog('please select Parent Type');
				return false;
				}
		return true;
				    
	    }
	    
	    </script>
	    
	    
<div class="reg_mainCon">
 <form  action="addnonadminuser.action" method="post" enctype="multipart/form-data" name="addNonAdminUser"   > <!-- onsubmit="return validateNonAdminUser(this)" -->
<!-- <form name="addform.action"  method="post"> -->
    <fieldset>
    <legend><img src="img/list_add_user.PNG" class="img-circle">&nbsp;&nbsp;Add User</legend>
    <div style="padding:20px;">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
	         	  <td width="18%"><label style="color:#000;"><b>First Name</b></label></td>
	        	 <td width="30%"><div align="left"><input class="span3" type="text" placeholder="" name="fname"  id="fname"></div></td>
	        	  <td >&nbsp;</td>
	        	 <td ><label style="color:#000;"><b>Last Name</b></label></td>
	         	<td ><input class="span3" type="text" placeholder="" name="lname"  id="lname"> </td>
        </tr>  
        <tr>
         <td ><label style="color:#000;"><b>Date of Birth</b></label></td>
          <td ><div align="left">
          
            <div id="datetimepicker"    class="input-append date"   >
			      <input style="width:85%;" class="span3" type="text" data-format="yyyy-MM-dd"  name="dob"  id="dob"></input>
			      <span class="add-on">
			        <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
			      </span>
		    </div>
          </div></td>
            <td >&nbsp;</td>
          <td ><label style="color:#000;"><b>User Rights</b></label></td>
         
          <td ><select  class="span3"   name="userRights"  id="userRights"    onchange=  "changeUserRights(this.value)">
              <option selected="selected">Select</option>
              <option value="PA">Parent</option>
              <option value="TC">Teacher</option>
              <option value="NTS">Non Teaching Staff</option>
              <option value="ST">Student</option>
                </select>             
        </td>
        </tr>        
        <tr>
            <td ><label style="color:#000;"><b>Email</b></label></td>
          <td ><div align="left">
            <input class="span3" type="text" placeholder="" name="email"  id="email" onblur="emailCheck();">
          </div></td>          
          <td >&nbsp;</td>
          <td ><label style="color:#000;"><b>Designation</b></label></td>
          <td ><input class="span3" type="text" placeholder="" name="designation"  id="designation"></td>
        </tr>
        <tr>
     	 <td ><label style="color:#000;"><b>Mobile</b></label></td>
          <td ><div align="left"><input class="span3" type="text" placeholder="" name="mobile"  id="mobile">  </div></td>
    	    <td >&nbsp;</td>
    	    <td >
	     <label style="color:#000;"><b>Landline</b></label></td>
          <td ><input class="span3" type="text" placeholder="" name="landline"  id="landline"></td>
       
        </tr>
        <tr>
          <td ><label style="color:#000;"><b>Address 1</b></label></td>
          <td ><div align="left">
            <input class="span3" type="text" placeholder="" name="addr1"  id="addr1">
          </div></td>
          <td >&nbsp;</td>
          <td ><label style="color:#000;"><b>Address 2</b></label></td>
          <td ><input class="span3" type="text" placeholder="" name="addr2"  id="addr2"></td>
        </tr>
        
          <tr>
          <td ><label style="color:#000;"><b>City</b></label></td>
          <td ><div align="left">
            <input class="span3" type="text" placeholder="" name="city"  id="city">
          </div></td>
          <td >&nbsp;</td>
          <td ><label style="color:#000;"><b>Country</b></label></td>
          <td >            
             <select  class="span3"   name="country"  id="country" ><!--  onchange="changeCountry(this.value)" -->
                 <option>Select</option>
            	 <option value="India"  selected="selected">India</option><option value="Indonesia">Indonesia</option>
              </select> 
           </td>
        </tr>
        <tr>
      		  <td ><label style="color:#000;"><b>State</b></label></td>         
			 <td > <div align="left"><div id="displaySubjects" style="display:show;">
					 <select   class="span3"  id="state" name="state">
					     <option>Select</option>
				   <option value="1"	selected="selected"	>Andhra Pradesh</option>
                   <option value="2">Madya pradesh</option>
				   <option value="3">Bihar</option>
				   </select>
				   </div>
             </div>
          </td>        
      <td >&nbsp;</td>
      <td ><label style="color:#000;"><b>Parent Type</b></label></td>         
        <td > 
					 <select   class="span3"  id="parentTypeSel"   name="parentTypeSel">
					     <option selected="selected">Select</option>
				   <option value="1">Father</option>
                   <option value="2">Mother</option>
				   <option value="3">Other</option>
				   </select>
				   
          </td>       
        <tr> 
        
        <tr name="admissionOne"  id="admissionOne" style="display:none;">
          <td ><label style="color:#000;"><b>Admission Number  </b></label></td>
          <td ><div align="left">
            <input class="span3" type="text" placeholder="" name="admissionNumber"  id="admissionNumber">
          </div></td>
          <td >&nbsp;</td>
          <td ><label style="color:#000;"><b>Admission Date</b></label></td>
         <td ><div align="left">
      	 <div id="admissionDate1"    class="input-append date"   >
			      <input style="width:85%;" class="span3" type="text" data-format="yyyy-MM-dd"  name="admissionDate"  id="admissionDate"></input>
			      <span class="add-on">
			        <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
			      </span>
		    </div>
          </div></td>
   
        </tr>
        <tr  name="admissionTwo"  id="admissionTwo" style="display:none;">
          <td ><label style="color:#000;"><b>Class Admitted In</b></label></td>
          <td ><div align="left">
            <input class="span3" type="text" placeholder="" name="classAdmittedIn"  id="classAdmittedIn">
          </div></td>
         <td >&nbsp;</td>
          <td ><label style="color:#000;"><b>Gender</b></label></td>
          <td >            
             <select  class="span3"   name="gender"  id="gender" ><!--  onchange="changeCountry(this.value)" -->
                  <option value="male">Male</option>
                  <option value="female">Female</option>
       </select> 
       </td>
        </tr>
  
        <tr>
          <td width="20%" ><label style="color:#000;"><b>Photo</b></label></td>
          <td>
          	<div class="fileupload fileupload-new" data-provides="fileupload">
				  <div class="input-append">
				    <div class="uneditable-input span2"><i class="icon-file fileupload-exists"></i> <span class="fileupload-preview"></span></div><span class="btn btn-file">
				    <span class="fileupload-new">Select file</span><span class="fileupload-exists">Change</span>
				    <input type="file" name="fileUP" id ="fileUP"/></span><a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Remove</a>
				  </div>
</div>
          </td>
          <td></td>
          <td></td>
          <td></td>
          </tr>
    
     <tr>
          <td ><label style="color:#000;"><b>Active</b></label></td>
          <td ><div align="left">
            <input type="checkbox" name="active" id="active"  checked="checked">
          </div></td>        <td >&nbsp;</td>  
          <td ><label style="color:#000;"><b>Is Parent</b></label></td>
          <td ><input type="checkbox" style="margin-top:-6px;" name="isParent"  id="isParent" onclick="isParentCheck();" disabled="disabled"></td>
        </tr>
		<tr>
          <td colspan="5" >&nbsp;</td>          
        </tr>
              
        <tr>         
          	<td >&nbsp;</td>   
            <td colspan="4">       	
      <!--   <button type="button" class="btn" onclick="addUser();">Save changes</button> -->
   <!--      <button type="button" class="btn" onclick="addUserFormSubmit();">Save changes</button> -->
        <button type="submit" class="btn" >Save changes</button>
            <button type="reset" class="btn">Cancel</button></td>
        </tr>
      </table>
    </div>
    </fieldset>
  </form>
</div>
<div style="height:20px;"></div>

<!-- /container -->
   <div id="idAlertDialog"    class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="windowTitleLabel" aria-hidden="true">
            <img src="img/alert.gif" width="34" height="28" alt="alert icon">
            <h3 id="idAlertDialogPrompt"></h3>
            <a href="#" class="btn btn-primary" onclick="okAlertDialog ();">OK</a>
            </div>
<script type="text/javascript">
 onloadmethods();
    $('#datetimepicker').datetimepicker({
      		  pickTime: false
      			}); 
    $('#admissionDate1').datetimepicker({
      		  pickTime: false
      			}); 
</script>



