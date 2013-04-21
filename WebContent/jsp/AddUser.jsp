	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
    	
    	<%
    	String tempShortname =(String) session.getAttribute("shortNameTemp");//this is for auto select of institute from InstitutionAdding
    	   	
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
    </script>
    <script type="text/javascript"
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
		    		function okAlertDialog () {
			$("#idAlertDialog").modal ('hide'); 
		};
		function alertDialog (prompt) {
			document.getElementById ("idAlertDialogPrompt").innerHTML = prompt;
			$("#idAlertDialog").modal ("show");
			}
		
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
      			
    	</script>
	    <script>
	    var userTypes;
   
	   	function uniqueUserIDCheck(){
			var userID = jQuery("#userID").val();
			UserMasterDWR.isUserIDCheck(
													"AD"+userID,
													function(data){								
					                                   if (data =="false") {
					                                  // alert("not found"+data);											
														} else {						                                
						                                   alert("User Id Already Exist::"+data);
						                                   		jQuery("#userID").focus();			                              		                                   													
														}
					                        	 }
					      ); 
					
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
	   
	    function isParentCheck() {
      	
			if(document.getElementById("isParent").checked == true) {
				document.getElementById("parentTypeSel").disabled=false;		
				document.getElementById("parentTypeSel").style.display="block";
			}else {
				document.getElementById("parentTypeSel").style.display="block";						
				document.getElementById("parentTypeSel").disabled=true;	
			}
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
	
	    function getInstitutionMaster(){
				//Process DWR/AJAX request here
				try{
				//alert("in alrttt--getInstitutionMaster");
					var listofInsit = document.getElementById('im_id_list');
					
					    UserTypeMasterDWR.getInstitutionMasterList(function(data){
					                                if (data == null) {														
					                                  alert("error");
					                                 
													} else {				
												//	alert(data+":::"+data.length);	                                 
					                               for(var i = 0; i < data.length; i++) {
														  var opt = document.createElement("option");
														    var temp = data[i];
														    opt.value = temp[0];
														    opt.innerHTML = temp[1];
														    listofInsit.appendChild(opt);
														}		                          
													}
					                         }
					      ) ;  
					
					
					
					 }catch(e){
					 alert("incatch::"+e);
					        jQuery.log.info(e.message);
					        jQuery("#infoError").html("&nbsp;");
	        	     } 		
				 										
				
			}
				    
	
	    function addUserFormSubmit(){
	   // alert(document.getElementById("city").value);
	   // document.getElementById("addform").submit();
	    form = document.forms[addform]; //assuming only form.
		form.submit();
	    }
	    
	   function resultPopUp(){
		    var userID = "<%=session.getAttribute("userIDD")%>";
		    var password =  "<%=session.getAttribute("passwordd")%>";
		    var msg =  "<%=session.getAttribute("msg")%>";
		    if(userID == null || password == null || userID == "null" || password == "null"){
			    if(msg != null && msg != "null"){
			     alertDialog("<div style='padding-left:50px; text-align:center; margin-top: 15px;'> "+msg+".</div>");
			     <%session.removeAttribute("msg"); %> ;
			    }
		    }else{
		    alertDialog("<div style='padding-left:50px; text-align:center; margin-top: 15px;'> "+msg+".<br/> Admin ID : "+userID+"<br/>Password : "+password+"</div>");
		    }
		
		    if(userID != null){
		 		<%session.removeAttribute("userIDD"); %> ;
		 		<%session.removeAttribute("passwordd"); %> ;
		 		 <%session.removeAttribute("msg"); %> ;
		    }
		  
	    }
	
	 function onloadmethods(){
	 //   alert("in onload");
	 	getInstitutionMaster();
		getUserTypeMaster();
		resultPopUp();
	    
	    }
	    function validateAdminUser(addAdminUser){
	    
	    var patEmail	= /^([\w\-\.]+)@((\[([0-9]{1,3}\.){3}[0-9]{1,3}\])|(([\w\-]+\.)+)([a-zA-Z]{2,4}))$/;					
		var patName		=/^[a-zA-Z-. ]{2,25}$/;
		var patUser		=/^[a-zA-Z0-9-. ]{2,25}$/;
		var patAddress		=/^[a-zA-Z_0-9@\!#\$\^%&*()+=\-[]\\\';,\.\/\{\}\|\":<>\? ]{2,25}$/;
		var patNum			= /^[0-9-+ ]{8,15}$/;
		var patBody =/^[A-Za-z0-9 ].+$/;
		var patDob			= /^[0-9- ]{10}$/;
		var patPassword		=/^[a-zA-Z0-9]{8}$/;
  
  
                var im_id_list   		=   jQuery("#im_id_list").val();
                var userID				=	jQuery("#userID").val().match(patUser);	
				var  fname 				= 	jQuery("#fname").val().match(patName);
				var password			=   jQuery("#password").val().match(patPassword);
				var passwordValue =   jQuery("#password").val();
				var cpasswordValue=   jQuery("#cPassword").val();
				var  lname 				= 	jQuery("#lname").val().match(patName);
				var cpassword			=   jQuery("#cPassword").val().match(patPassword);
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
			/* 	var admissionNumber		=   jQuery("#admissionNumber").val().match(patNum);
				var admissionDate		=   jQuery("#admissionDate1").val().match(patDob);
				var classAdmittedIn		=   jQuery("#classAdmittedIn").val().match(patBody); */
				var  isParent 				=	jQuery("#isParent").prop('checked') ? 'Y':'N';
				
				
				if(im_id_list=="-1"){
				alertDialog('please select Institution Name ');
				return false;
				}
				if(!userID){
				alertDialog('please enter valid UserId ');
				return false;
				}
				if(!fname){
				alertDialog('please enter valid First Name ');
				return false;
				}
				if(!password){
				//alertDialog('Password should be 8 charcters and should contain only Alphanumeric characters');
				//return false;
				}
				if(!lname){
				alertDialog('please enter valid Last Name ');
				return false;
				}
				if(!cpassword){
				//alertDialog('Confirm Password should be 8 charcters and should contain only Alphanumeric characters  ');
				//return false;
				}
				if(cpasswordValue != passwordValue){
				alertDialog('Confirm Password and Password didnot matched');
				return false;
				}
				if(userRights=="Select"){
				alertDialog('please select User Rights ');
				return false;
				}
				 if(!dob){
				alertDialog('please enter valid DOB ');
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
				if(isParent=="Y"  && parentTypeSel=="Select"){
				alertDialog('please select Parent Type');
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
				if(country=="Select"){
				alertDialog('please select Country');
				return false;
				}
				if(state=="Select"){
				alertDialog('please select State');
				return false;
				}
				//return false;
				
				    
	    }
	    </script>
	    
<div class="reg_mainCon">
 <form action="addadminuser.action" method="post" enctype="multipart/form-data"  name="addAdminUser"  onsubmit="return validateAdminUser(this)"> 
    <fieldset>
    <legend><img src="img/list_add_user.PNG" class="img-circle">&nbsp;&nbsp;Add ADMIN</legend>
    <div style="padding:20px;">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
       <!--  <tr>
          <td colspan="5" style="text-align:center">
          <label style="color:#000;margin-left: 100px;"><b>Institution Name</b></label>                 
          <select class="span3" name="im_id_list"  id="im_id_list" > onchange="changeCountry(this.value)"
               <option value="-1"  selected="selected">Select</option>
                    </select> 
          </td></tr> -->
          <tr>
	          <td style="text-align:center" colspan="2">
	          <label style="color:#000;margin-left: 100px;"><b>Institution Name</b></label>                 
	          </td>
			<td></td>
			<td colspan="2"><select id="im_id_list" name="im_id_list" class="span3"><!--  onchange="changeCountry(this.value)" -->
               <option selected="selected" value="-1">Select</option>
              </select> </td>
		</tr>
         
        <tr>
          <td width="22%"><label style="color:#000;"><b>User ID</b></label></td>
          <td width="26%"><div align="left">
            <input class="span3" type="text" placeholder="" name="userID"  id="userID" onblur="uniqueUserIDCheck();">
          </div></td>
          <td >&nbsp;</td>
          <td width="18%"><label style="color:#000;"><b>First Name</b></label></td>
          <td width="30%"><input class="span3" type="text" placeholder="" name="fname"  id="fname"></td>
        </tr>  
        <tr>
          <td ><label style="color:#000;"><b>Password</b></label></td>
          <td ><div align="left">
            <input class="span3" type="text" placeholder="" name="password"  id="password">
          </div></td>
          <td width="4%">&nbsp;</td>
          <td ><label style="color:#000;"><b>Last Name</b></label></td>
          <td ><input class="span3" type="text" placeholder="" name="lname"  id="lname"></td>
        </tr><tr>
          <td ><label style="color:#000;"><b>Confirm Password</b></label></td>
          <td ><div align="left">
            <input class="span3" type="text" placeholder="" name="cPassword"  id="cPassword">
          </div></td>
          <td >&nbsp;</td>
          <td ><label style="color:#000;"><b>User Rights</b></label></td>
         
          <td ><select class="span3"  name="userRights"  id="userRights">
              <option>Select</option>
              <option value="admin" selected="selected" >Admin</option>
                </select>             
        </td>
        </tr><tr>
          <td ><label style="color:#000;"><b>Date of Birth</b></label></td>
          <td ><div align="left">
          
            <div id="datetimepicker" class="input-append date">
			      <input class="span3" type="text" data-format="yyyy-MM-dd"  name="dob"  id="dob"></input>
			      <span class="add-on">
			        <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
			      </span>
		    </div>
          </div></td>
          
          <td >&nbsp;</td>
          <td ><label style="color:#000;"><b>Designation</b></label></td>
          <td ><input class="span3" type="text" placeholder="" name="designation"  id="designation"></td>
        </tr><tr>
          <td ><label style="color:#000;"><b>Email</b></label></td>
          <td ><div align="left">
            <input class="span3" type="text" placeholder="" name="email"  id="email" onblur="uniqueEmailCheck();">
          </div></td>
          <td >&nbsp;</td>
          <td ><label style="color:#000;"><b>Mobile</b></label></td>
          <td ><input class="span3" type="text" placeholder="" name="mobile"  id="mobile"></td>
        </tr><tr>
          <td ><label style="color:#000;"><b>Landline</b></label></td>
          <td ><div align="left">
            <input class="span3" type="text" placeholder="" name="landline"  id="landline">
          </div></td>
          <td >&nbsp;</td>
          <td ><label style="color:#000;"><b>Is Parent</b></label></td>
          <td ><input type="checkbox" style="margin-top:-6px;" name="isParent"  id="isParent"  onclick="isParentCheck();"></td>
        </tr><tr>
          <td ><label style="color:#000;"><b>Address 1</b></label></td>
          <td ><div align="left">
            <input class="span3" type="text" placeholder="" name="addr1"  id="addr1">
          </div></td>
          <td >&nbsp;</td>
          <td ><label style="color:#000;"><b>Address 2</b></label></td>
          <td ><input class="span3" type="text" placeholder="" name="addr2"  id="addr2"></td>
        </tr><tr>
          <td ><label style="color:#000;"><b>City</b></label></td>
          <td ><div align="left">
            <input class="span3" type="text" placeholder="" name="city"  id="city">
          </div></td>
          <td >&nbsp;</td>
          <td ><label style="color:#000;"><b>Country</b></label></td>
          <td >            
             <select class="span3" name="country"  id="country" ><!--  onchange="changeCountry(this.value)" -->
               <option value="India"  selected="selected">India</option><option value="Indonesia">Indonesia</option>
                    </select> 
         </td>
        </tr><tr>
  		  <td ><label style="color:#000;"><b>State</b></label></td>
			 <td ><div align="left">	
				<div id="displaySubjects" style="display:show;">
					<!--  <select   class="span3"  id="states" name="states"> -->
					 <select   class="span3"  id="state" name="state">
				   <option value="1">Andhra Pradesh</option>
                   <option value="2">Madya pradesh</option>
				   <option value="3">Bihar</option>
				   </select>
				   </div>
             </div>
          </td>
          <td >&nbsp;</td>
	      <td ><label style="color:#000;"><b>Parent Type</b></label></td>         
	        <td > 
					<select   class="span3"  id="parentTypeSel"   name="parentTypeSel" disabled="disabled">
					     <option selected="selected">Select</option>
				   <option value="1">Father</option>
                   <option value="2">Mother</option>
				   <option value="3">Other</option>
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
          </div></td>
          <td >&nbsp;</td>
          <td >&nbsp;</td>
          <td >&nbsp;</td>
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
</script>



