	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
    	
    	<% 
    	
    	
    		if(session.getAttribute("short_name") != null  && ((String)session.getAttribute("userType")).equalsIgnoreCase("AD")&& session.getAttribute("superadmin") == null ){
    			if(session.getAttribute("IM_ID")!= null &&session.getAttribute("SM_ID")!= null &&session.getAttribute("BM_ID")!= null &&session.getAttribute("UM_ID")!= null && session.getAttribute("pageTO")!=null){
    		
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
    	
	    <!-- javascripts -->
	    <script src="js/bootstrap-datetimepicker.min.js"> </script>
    	<script  src="js/bootstrap-datetimepicker.pt-BR.js"> </script>
    	
	    <script src="js/bootstrap-fileupload.js" type="text/javascript"></script>
    	
    	<!-- DWR calls -->
	    <script 	src="<%=request.getContextPath()%>/dwr/interface/UserTypeMasterDWR.js"></script>
	    <script 	src="<%=request.getContextPath()%>/dwr/interface/UserMasterDWR.js"></script>
	    <script 	src="<%=request.getContextPath()%>/dwr/interface/EmailDomainDWR.js"></script>
	    <script 	src="<%=request.getContextPath()%>/dwr/interface/SchoolMasterDWR.js"></script>
	    <script 	src="<%=request.getContextPath()%>/dwr/interface/BranchMasterDWR.js"></script>
	     <script 	src="<%=request.getContextPath()%>/dwr/interface/ClassMasterDWR.js"></script>
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
		
		function selectBranchesforClasses(){
		   var branchID = jQuery("#branchNames").val();
		if(branchID != '-1'){
		   var schoolID = jQuery("#schoolNames").val();
			if (branchID == "-1" || schoolID =="-1") {
					/* setError("branchNames","Please select Branch Name ");
               jQuery("#branchNames").focus(); */
			}else if(jQuery("#userRights").val() == "ST"){
			removeAllOptions("classAdmittedIn");
								  
		   try{
						var listofclasses = document.getElementById('classAdmittedIn');					
						    ClassMasterDWR.getClassMasterList(schoolID,branchID,function(data){
						                                if (data == null) {													
						                                  alert("error");
														} else {				
														//alert(data+":::"+data.length+data[1]);	                                 
						                               for(var i = 0; i < data.length; i++) {
															  var opt = document.createElement("option");
															    var temp = data[i];
															    opt.value = temp[0];
															    opt.innerHTML = temp[1];
															    listofclasses.appendChild(opt);
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
		  }
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
						//get Class Master List
						selectBranchesforClasses();//may not req in future
							 document.getElementById("admissionOne").style.display='';
						    document.getElementById("admissionTwo").style.display='';
						    
						    document.getElementById("parentTypeSel").disabled=true;		
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
	    function getUserTypeMaster(){
				//Process DWR/AJAX request here
				try{
				var pageTO = '<%=(String)session.getAttribute("pageTO")%>';
				//alert(pageTO+"<--");
				if (pageTO == "uts") {
					jQuery("#userRights").val('ST');
					changeUserRights("ST");
					//$('#userRights').attr("disabled", true); 
					//read only is not there for selection box
				} else if (pageTO == "ffats") {
					jQuery("#userRights").val("TC");
					changeUserRights("TC");
				}else if (pageTO == "rap") {
					jQuery("#userRights").val("PA");
					changeUserRights("PA");
					//$('#userRights').attr("disabled", true); 
				}
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
														  setError("email","Email Id Already Exist");			                                
						                                //   alert("Email Id Already Exist::"+data);
						                                   		jQuery("#email").focus();			                              		                                   													
														}
					                        	 }
					      ); 
					
		}		    
		
		function emailCheck(){
		
				var value1=jQuery("#userRights").val();
		//alert("valll--"+value1);
		if(value1 == "TC" || value1 == "NTS" ||value1 == "admin"){
			//	alert("in ifff");					
				uniqueEmailCheck();			
	    	}else{
	    	//alert("jijij");
	    	}
		
		}
				    
	    function onloadmethods(){
	 //   alert("in onload");
	 schoolMasterList();
		getUserTypeMaster();
		resultPopUp();

	    }
	    function addUserFormSubmit(){
	   // alert(document.getElementById("city").value);
	   // document.getElementById("addform").submit();
	    form = document.forms[addform]; //assuming only form.
		form.submit();
	    }
	    
	    	 function removeAllOptions(whichOption)
		{
	//	var listofSubjects =  document.getElementById("selectSubject");
		var listofSubjects =  document.getElementById(whichOption);
		
			var i;
			for(i=listofSubjects.options.length-1;i>=0;i--)
			{
			listofSubjects.remove(i);
			}
			
			 var opt = document.createElement("option");
		    opt.value = "-1";
		    opt.innerHTML = "Select";
		    listofSubjects.appendChild(opt);
			
		/* 	 var opt = document.createElement("option");
		    opt.value = "0";
		    opt.innerHTML = "All";
		    listofSubjects.appendChild(opt); */
			
		}
	    
	    function resultPopUp(){
	    	var nonadminmsg = "<%=session.getAttribute("nonadminMsg")%>";
	    	var userID = "<%=session.getAttribute("userIDD")%>";
		    var password =  "<%=session.getAttribute("passwordd")%>";
		    if(userID == null || password == null || userID == "null" || password == "null"){
			   //  alertDialog("<div style='padding-left:50px; text-align:center; margin-top: 15px;'> Success.<br/> Your ID : "+"TH676767676"+"<br/>Password : "+"yu76767hhgh6"+"</div>");
			   //  resetForm($('#addNonAdminUser')); // by id, recommended
				     if(nonadminmsg != null && nonadminmsg != "null" ){
					    alertDialog("<div style='padding-left:50px; text-align:center; margin-top: 15px;'> "+nonadminmsg+".</div>");		
					    <%session.removeAttribute("nonadminMsg"); %> ;     
				     }
		    }else{
		    	alertDialog("<div style='padding-left:50px; text-align:center; margin-top: 15px;'> "+nonadminmsg+".<br/> Your ID : "+userID+"<br/>Password : "+password+"</div>");
		 	   //  resetForm($('#addNonAdminUser')); // by id, recommended
		    }
		     if(userID != null){
		 		<%session.removeAttribute("userIDD"); %> ;
		 		<%session.removeAttribute("passwordd"); %> ;
		 		<%session.removeAttribute("nonadminMsg"); %> ;
		     }
	    }
	    
	    	 function schoolMasterList(){
	    
		   try{
						var listofschools = document.getElementById('schoolNames');					
						    SchoolMasterDWR.getSchoolMasterList(function(data){
						                                if (data == null) {				
						                                  alert("error");						                                 
														} else {				
														//alert(data+":::"+data.length+data[1]);	                                 
						                               for(var i = 0; i < data.length; i++) {
															  var opt = document.createElement("option");
															    var temp = data[i];
															    opt.value = temp[0];
															    opt.innerHTML = temp[1];
															    listofschools.appendChild(opt);
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
	
	
	function selectSchoolforBranches(val){
	   
	   if(val != '-1'){	   
	   var schoolID = jQuery("#schoolNames").val();

		removeAllOptions("branchNames");
					  
		if(val != '-1'){	   
		   try{
		   	var im_id = "<%=session.getAttribute("IM_ID")%>";	
		   	
					//alert("based school master getting branch master list--"+schoolID);
						var listofbranchs = document.getElementById('branchNames');					
	
						    BranchMasterDWR.getBranchMasterList(schoolID,function(data){
						                                if (data == null) {													
						                                  alert("error");						                                 
														} else {				
														//alert(data+":::"+data.length+data[1]);	                                 
						                               for(var i = 0; i < data.length; i++) {
															  var opt = document.createElement("option");
															    var temp = data[i];
															    opt.value = temp[0];
															    opt.innerHTML = temp[1];
															    listofbranchs.appendChild(opt);
															}		                          
														}
						                         }
						      ) ;  
						
		   		 }catch(e){
						 alert("incatch::"+e);
						        jQuery("#infoError").html("&nbsp;");
		         } 	
	   
				
				
					
				}else{			 	 }
			  }
	 }
	    
	    
	 function validateNonAdminUser(addNonAdminUser){
	    
	    var patEmail	= /^([\w\-\.]+)@((\[([0-9]{1,3}\.){3}[0-9]{1,3}\])|(([\w\-]+\.)+)([a-zA-Z]{2,4}))$/;					
		var patName		=/^[a-zA-Z-. ]{2,25}$/;
		var patAddress		=/^[a-zA-Z_0-9@\!#\$\^%&*()+=\-[]\\\';,\.\/\{\}\|\":<>\? ]{2,25}$/;
		var patNum			= /^[0-9-+ ]{8,15}$/;
		var patBody =/^[A-Za-z0-9 ].+$/;
		var patDob			= /^[0-9- ]{10}$/;

				var  schoolNames 				= 	jQuery("#schoolNames").val();
				var  branchNames 				= 	jQuery("#branchNames").val();
				var  fname 				= 	jQuery("#fname").val().match(patName);
				var  lname 				= 	jQuery("#lname").val().match(patName);
				var  dob 				= 	jQuery("#dob").val().match(patDob);
				var  userRights 		= 	jQuery("#userRights").val();
				var  email 				= 	jQuery("#email").val().match(patEmail);
				var  designation 		= 	$.trim(jQuery("#designation").val()).match(patName);
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
				var classAdmittedIn		=   jQuery("#classAdmittedIn").val();
		
			var  isParent 				=	jQuery("#isParent").prop('checked') ? 'Y':'N';
			var  active				=	jQuery("#active").prop('checked') ? 'Y':'N';
			
				if(schoolNames=="-1"){
				setError("schoolNames","Please select School Name ");
               jQuery("#schoolNames").focus();
				return false;
				}
			if(branchNames=="-1"){
				setError("branchNames","Please select Branch Name ");
               jQuery("#branchNames").focus();
				return false;
				}
			//alert(  jQuery("#fname").val().length);
				if(!fname){
					  setError("fname","Please enter valid First Name ");
               jQuery("#fname").focus();
				return false;
				}
				if(!lname){
					  setError("lname","Please enter valid Last Name");
               jQuery("#lname").focus();
				return false;
				}
				 if(!dob){
				 	  setError("dob","Please enter valid DOB");
               jQuery("#dob").focus();
				return false;
				} 
				if(userRights=="-1"){
					  setError("userRights","Please select User Rights ");
               jQuery("#userRights").focus();
				return false;
				}
				if(!email){
					  setError("email","Please enter valid Email");
               jQuery("#email").focus();
				return false;
				}
				
			if(userRights=="NTS" ||userRights=="TC"){
					if(!designation){
						  setError("designation","Please enter valid Designation");
		               jQuery("#designation").focus();
						return false;
						}
				}
				 
				if(!mobile){
					  setError("mobile","Please enter valid Mobile ");
               jQuery("#mobile").focus();
				return false;
				}
				if(!landline){
					  setError("landline","Please enter valid Landline");
               jQuery("#landline").focus();
				return false;
				}
				if(!addr1){
					  setError("addr1","Please enter valid Address 1");
               jQuery("#addr1").focus();
				return false;
				}
				if(!addr2){
					  setError("addr2","Please enter valid Address 2");
               jQuery("#addr2").focus();
				return false;
				}
				if(!city){
					  setError("city","Please enter valid City");
               jQuery("#city").focus();
				return false;
				}
				if(state=="-1"){
					  setError("state","Please select State");
               jQuery("#state").focus();
				return false;
				}
				if(country=="-1"){
					  setError("country","Please select Country");
               jQuery("#country").focus();
				return false;
				}
		/* 		if(userRights !="ST"){
				
				if(parentTypeSel=="Select"){
				alertDialog('Please select Parent Type');
				return false;
				
				}
				} */
				if(userRights=="ST"){
					if(!admissionNumber){
						setError("admissionNumber","Please enter valid AdmissionNumber");
	               		jQuery("#admissionNumber").focus();
					return false;
					}
					if(!admissionDate){
						setError("admissionDate","'Please enter valid Admission Date");
	               		jQuery("#admissionDate").focus();
					return false;
					}
					if(classAdmittedIn == "-1"){
						  setError("classAdmittedIn","Please select Class to Admit");
               jQuery("#classAdmittedIn").focus();
				return false;
					return false;
					}
				}
				if(isParent=="Y"  && parentTypeSel=="-1"){
					  setError("parentTypeSel","Please select Parent Type");
               jQuery("#parentTypeSel").focus();
				return false;
				}
				if(!validateForm()){
				return false;				
				}
				
			if(active=="N"){
              //alert("Please select check box");
              setError("active","Please select check box");
              jQuery("#active").focus();
              return false;
           }
		
				    
	    }
	    
	   function validateForm() {
			var file1  = jQuery("#fileUP").val();
			if(file1 != ""){
				var extension = file1.split('.').pop().toLowerCase();
				var allowed = ['gif','jpeg','pjpeg','png','jpg'];
				if(allowed.indexOf(extension) === -1) {
					//alertDialog("Your selected "+ file1+"  extension wrong"); previous
					  setError("fileUP","Only gif / jpeg /jpg / pjpeg / png formats are allowed");
	               jQuery("#fileUP").focus();
					return false;
				}else{
	    			return true;
				}
			}else{
	    			return true;
				}
	    }
	    
	var errorDisp=null;
       function setError(errElement, msg){
			if(errorDisp != null){
				errorDisp.stop(true, true).animate({opacity: 1}, 0);
				errorDisp.hide();
			}

			var feild 		= jQuery("#"+errElement);
				errorDisp 	= jQuery("#errorspan");
			
			errorDisp.show();											
			jQuery("#errorspan").html(msg);

			errorDisp.position({
				of:feild,
				my:"left" 	+ " " + "top",
				at:"right" 	+ " " + "top",
				offset:'0 0',
				collision : 'none none'
				
				
			});
			errorDisp.animate({opacity: 0}, 6000);
	  }
	    
	 function resetForm($form) {
		    $form.find('input:text, input:password, input:file, textarea').val('');
		       jQuery("#country").val('India');
		       jQuery("#state").val('Andhra Pradesh');
		 /*    
		    $form.find('input:radio, input:checkbox')
		         .removeAttr('checked').removeAttr('selected'); */
		}
	    
	    </script>
	    
	    
<div class="reg_mainCon"><!-- addnonadminuser.action -->
 <form  action="addnonadminuser.action" method="post" enctype="multipart/form-data" name="addNonAdminUser" onsubmit="return validateNonAdminUser(this)"   > <!-- onsubmit="return validateNonAdminUser(this)" -->
<!-- <form name="addform.action"  method="post"> -->
    <fieldset>
    <legend><img src="img/list_add_user.PNG" class="img-circle">&nbsp;&nbsp;Add User</legend>
    <div style="padding:20px;">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
       <tr><td colspan="5" style="text-align: center;"><span id ="errorspan" style="color:red;font-size: 14px;" ></span>&nbsp;</td></tr>
           <tr><td width="18%"><label style="color:#000;"><b>School </b></label></td>
	                <td width="30%"><div align="left"><select class="span3"  name="schoolNames" id="schoolNames" onchange="selectSchoolforBranches(this.value);">
	                        <option value="-1" selected="selected">Select</option>
	                       <!--  <option value="0">ALL</option> -->
	                       </select></div>
	                 </td> <td >&nbsp;</td><td><label style="color:#000;"><b>Branch </b></label></td>
	                <td><select class="span3" name="branchNames" id="branchNames"  onchange="selectBranchesforClasses() "><!-- -->
	                        <option value="-1" selected="selected">Select</option>
	                      <!--   <option value="0">All</option> -->
	                       </select>    
	             </td>
        </tr>         
        <tr> <td >&nbsp;</td></tr>
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
              <option value="-1"  selected="selected">Select</option>
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
                 <option value="-1">Select</option>
            	 <option value="India"  selected="selected">India</option><option value="Indonesia">Indonesia</option>
              </select> 
           </td>
        </tr>
        <tr>
      		  <td ><label style="color:#000;"><b>State</b></label></td>         
			 <td > <div align="left"><div id="displaySubjects" style="display:show;">
					 <select   class="span3"  id="state" name="state">
					     <option value="-1">Select</option>
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
					     <option selected="selected" value="-1">Select</option>
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
          <td >
           <div align="left">
					 <select   class="span3"  id="classAdmittedIn" name="classAdmittedIn">
					     <option value="-1">Select</option>
				   </select>
			</div>
          </td>
         <td >&nbsp;</td>
          <td ><label style="color:#000;"><b>Gender</b></label></td>
          <td >            
             <select  class="span3"   name="gender"  id="gender" ><!--  onchange="changeCountry(this.value)" -->
                  <option value="M">Male</option>
                  <option value="F">Female</option>
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



