<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
        <link href="css/bootstrap.css" rel="stylesheet">
            <link href="css/bootstrap-fileupload.css" rel="stylesheet" media="screen">	
        	    <script src="js/bootstrap-jquery.js"></script>
        	<script type="text/javascript" src="js/bootstrap-radio.js"></script>
            <script src="js/bootstrap-fileupload.js" type="text/javascript"></script>
        
         <script 	src="<%=request.getContextPath()%>/dwr/interface/SchoolMasterDWR.js"></script>
         <script 	src="<%=request.getContextPath()%>/dwr/interface/BranchMasterDWR.js"></script>
         <script 	src="<%=request.getContextPath()%>/dwr/interface/ClassMasterDWR.js"></script>
        
        <script type="text/javascript">
         $(function(){
            $('input:checkbox').screwDefaultButtons({
                image: 'url("img/checkboxSmall.jpg")',
                width: 20,
                height: 20
            });
            }); 
       
	    function editPreviousUploads(){
	      		alert('editPreviousUploads');
	      }
	      
	       function selectType1(val){
			    if(val=='Assignments'){
					document.getElementById('assignmentType').disabled = false;
					document.getElementById('selectSubject').disabled = false;
					  subjectMaster();
				}else{
					    document.getElementById('assignmentType').disabled = true;
					    document.getElementById('selectSubject').disabled = true;
			  }
			  
		 }
		 
	
	function schoolMasterList(){
	    
		   try{
		 		  	var im_id = "<%=session.getAttribute("IM_ID")%>";			//not req			
					var sm_id = "<%=session.getAttribute("SM_ID")%>";		//not req		
					var bm_id = "<%=session.getAttribute("BM_ID")%>";	//not req
		   
				//	alert("onload school master"+im_id);
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
	   
		removeAllOptions("branchNames");
		removeAllOptions("selectClass");
	   if(val != '-1'){	   
	   var schoolID = jQuery("#schoolNames").val();

					  
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
						        jQuery.log.info(e.message);
						        jQuery("#infoError").html("&nbsp;");
		         } 	
	   
				
				
					
				}else{			 	 }
			  }
	 
	   
	   
	 }
		 
	function selectBranchesforClasses(val){
	   
	   var schoolID = jQuery("#schoolNames").val();
	   
		removeAllOptions("selectClass");
		 if(val != '-1'){
		 
		    if (schoolID == "-1") {		
		     setError("schoolNames","Please select School name");
	               jQuery("#schoolNames").focus();
					return false;	   
		}
	 
	   var branchID = jQuery("#branchNames").val();

					  
		if(val != '-1'){	   
		   try{
		   	var im_id = "<%=session.getAttribute("IM_ID")%>";	
		   	
				//	alert("based school master getting branch master list--"+branchID+"--"+schoolID);
						var listofclasses = document.getElementById('selectClass');					
	
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
	   
				
				
					
				}else{			 	 }
			  }
	 		  
		 }
		 
		function selectGradeSubject(val){
	   
		   if(val != '-1'){	   
		   var upload = jQuery("#uploadType").val();
		   
				    if(upload =='Assignments'){
				    removeAllOptions("selectSubject");
						  subjectMaster();
						
					}else{			 	 }
				  }
		 }
	
		function subjectMaster(){
			//Process DWR/AJAX request here
				try{
				//alert("in alrttt--SMSCredits");	jQuery("#addr2").val();	
					
					var im_id = "<%=session.getAttribute("IM_ID")%>";					
				
				  var branchID = jQuery("#branchNames").val();
	   			var schoolID = jQuery("#schoolNames").val();
	   			
				var listofSubjects =  document.getElementById("selectSubject");
			
				var classID = jQuery("#selectClass").val();
				
					//	alert(listofSubjects+":::"+im_id+"--"+schoolID+"--"+branchID);
				     ClassMasterDWR.getSubjectMasterList(schoolID,branchID,classID,function(data){
					                                if (data == null) {												
					                                  alert("error");
					                                 
													} else {		
												//	alert(data+":::")	;	
													//   removeAllOptions();   
					                           for(var i = 0; i < data.length; i++) {
														    var opt = document.createElement("option");
														    var temp = data[i];
														    opt.value = temp[0];
														    opt.innerHTML = temp[1];
														    listofSubjects.appendChild(opt);
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
	
	
		function onloadmethods(){
		
		resultPopUp();
		schoolMasterList();
		}
		
	   function resultPopUp(){
	    	var msg = "<%=session.getAttribute("msg")%>";
	    	
		    if(msg == null || msg == "null"){
		    // alertDialog("<div style='padding-left:50px; text-align:center; margin-top: 15px;'> Success.<br/> Your ID : "+"TH676767676"+"<br/>Password : "+"yu76767hhgh6"+"</div>");
		    }else{
		     setError("schoolNames",msg);
		      jQuery("#schoolNames").focus();
		        resetForm($('#uploaddocForm')); // by id, recommended
		  	  //  alert(msg);
/* 		    alertDialog("<div style='padding-left:50px; text-align:center; margin-top: 15px;'> "+msg+".<br/></div>"); */
		    }
		     if(msg != null){
		 		<%session.removeAttribute("msg"); %> ;
		     }
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
		    if (whichOption == "branchNames") {
		    opt.innerHTML = "Select Branch";
			}else if (whichOption == "selectClass") {
		    opt.innerHTML = "Select Class";
			}else if (whichOption == "selectSubject") {
		    opt.innerHTML = "Select Subject";
			}
		    
		    listofSubjects.appendChild(opt);
			
			 var opt = document.createElement("option");
		    opt.value = "0";
		    opt.innerHTML = "All";
		    listofSubjects.appendChild(opt);
			
		}
	

	function validateForm(){
	
		var schoolNames = jQuery("#schoolNames").val();
		var branchNames = jQuery("#branchNames").val();
		var selectClass = jQuery("#selectClass").val();
		var selectType = jQuery("#selectType").val();
		var uploadType = jQuery("#uploadType").val();
		
		
		if(schoolNames=="-1"){
		 setError("schoolNames","Please select valid School(s)");
			jQuery("#schoolNames").focus();
			return false;
		}
		
		if(branchNames=="-1"){
			 setError("branchNames","Please select  Branch(s)");
			jQuery("#branchNames").focus();
			return false;
		}
		
		if(selectClass=="-1"){
			 setError("selectClass","Please select  Class(s)");
			jQuery("#selectClass").focus();
			return false;
		}
		if(selectType=="-1"){
			 setError("selectType","Please select  Parent/Student/All");
			jQuery("#selectType").focus();
			return false;
		}
		
	if(uploadType=="-1"){
			 setError("uploadType","Please select  Upload type");
			jQuery("#uploadType").focus();
			return false;
		}
		
		if (uploadType == "Assignments") {
			var assignmentType = jQuery("#assignmentType").val();
			var selectSubject = jQuery("#selectSubject").val();
				if (assignmentType == "-1") {
						setError("assignmentType","Please select Assignment Type");
						jQuery("#assignmentType").focus();
			return false;
				}			
				if (selectSubject == "-1") {
						setError("selectSubject","Please select Subject(s)");
						jQuery("#selectSubject").focus();
			return false;
				}			
			
		}
			
			var file1  = jQuery("#fileUP").val();
		if(file1 == "" || file1 == undefined  || file1 == "undefined"){		
			setError("branchNames","Please select a file");
				jQuery("#fileUP").focus();
			return false;
		}
	
		var extension = file1.split('.').pop().toLowerCase();
		var allowed = ['pdf', 'doc', 'docx', 'xls', 'xlsx', 'txt','ppt','pptx','gif','csv','png','jpg','jpeg','dot','dotx','html','odm','ott','odt','rtf','xps'];
		
		if(allowed.indexOf(extension) === -1) {
		    // Not valid.
			setError("branchNames","Your selected "+ file1+"  extension wrong");
				jQuery("#fileUP").focus();
			return false;
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
		       jQuery("#schoolNames").val('Select School');
		       jQuery("#branchNames").val('Select Branch');
		       jQuery("#selectClass").val('Select Class');
		       jQuery("#selectType").val('Select');
		       jQuery("#uploadType").val('Select');
		       jQuery("#assignmentType").val('Select');
		       jQuery("#selectSubject").val('Select Subject');
		 /*    
		    $form.find('input:radio, input:checkbox')
		         .removeAttr('checked').removeAttr('selected'); */
		}


    </script>
   
    <div style="height:50px;"></div>
<div class="reg_mainCon">
   <form  method="post"  action="uploadDocActionName.action" name="uploaddocForm" enctype="multipart/form-data" onsubmit="return validateForm()"> 
    <fieldset>
    <legend><img src="img/list_add_user.PNG" class="img-circle">&nbsp;&nbsp;Upload Documents</legend>
    <div style="padding:20px;">
      <label style="color:#000;"></label>
   <table width="100%" border="0" cellspacing="0" cellpadding="0">
  
           <tr>
             <td colspan="3" style="text-align:right;"><button type="button" class="btn" onclick="editPreviousUploads(); return false;">Edit previous uploads</button> </td>
        </tr>
   <tr><td colspan="4" style="text-align: center;"><span id ="errorspan" style="color:red;font-size: 14px;" ></span>&nbsp;</td></tr>
        <tr>
                <td colspan="3"><label style="color:#000;"><b>Select Audience</b></label></td>
        </tr>
          <tr>
                <td><label style="color:#000;"><b>Display to</b></label></td>
                <td><select class="span4"  name="schoolNames" id="schoolNames" onchange="selectSchoolforBranches(this.value);">
                        <option value="-1" selected="selected">Select School</option>
                        <option value="0">ALL</option>
                       </select>                   
                 </td>
                <td><select class="span4" name="branchNames" id="branchNames" onchange="return selectBranchesforClasses(this.value);">
                        <option value="-1" selected="selected">Select Branch</option>
                        <option value="0">All</option>
                       </select>                   
                 </td>
        </tr>
        <tr>
                <td></td>
                <td><select class="span4"  name="selectClass" id="selectClass" onchange="return selectGradeSubject(this.value);">
                        <option value="-1"   selected="selected">Select Class</option>
                        <option value="0">ALL</option>
                       </select>                   
                 </td>
                <td><select class="span4" name="selectType" id="selectType" >
                        <option value="-1">Select</option>
                        <option value="All"   selected="selected">All</option>
                        <option value="Parents"> Parents</option>
                        <option value="Students">Students</option>
                       </select>                   
                 </td>                 
        </tr>
        <tr>
         <td><label style="color:#000;"><b>Upload Type</b></label></td>
                <td><select class="span4"   name="uploadType" id="uploadType" onchange="selectType1(this.value)">
                        <option value="-1"  selected="selected">Select</option>
                        <option value="Time table">Timetable</option>
                        <option value="Canteen menu">Canteen Menu</option>
                        <option value="Assignments">Assignments</option>
                        <option value="Calendars">Calendars</option>
                        <option value="Circular">Circular</option>
                       </select>                   
                 </td>
                <td>&nbsp;</td>
             
        </tr>
       
         <tr>
         <td><label style="color:#000;"><b>Assignment Type</b></label></td>
                <td><select class="span4" name="assignmentType"  id="assignmentType" disabled="disabled">
                        <option value="-1"  selected="selected">Select</option>
                        <option value="Holiday">Holiday</option>
                        <option value="Daily">Daily</option>
                        <option value="Weekend">Weekend</option>
                       </select>                   
                 </td>
                <td>&nbsp;</td>
             
        </tr>
          <tr>
         <td><label style="color:#000;"><b>Subject</b></label></td>
                <td><select class="span4"  name="selectSubject" id="selectSubject" disabled="disabled">
                        <option value="-1"  selected="selected">Select Subject</option>
                      </select>                   
                 </td>
                <td>&nbsp;</td>
             
        </tr>
         <tr>
             
        <td width="20%"><label style="color:#000;"><b>Upload</b></label></td>
          <td colspan="2">
          	<div class="fileupload fileupload-new" data-provides="fileupload" >
				  <div class="input-append">
				    <div class="uneditable-input span4"><i class="icon-file fileupload-exists"></i> <span class="fileupload-preview"></span></div><span class="btn btn-file">
				    <span class="fileupload-new">Select file</span><span class="fileupload-exists">Change</span>
				    <input type="file" name="fileUP" id ="fileUP"/></span><a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Remove</a>
				  </div>
</div>
          </td>
          </tr>
         <tr>
             <td colspan="3">
                <input class="span4" style="width:55px;" type="checkbox" placeholder=""  name="nty_email" id="nty_email">
                <label style="color:#000;line-height: 23px;font-size: 14px;vertical-align: 14px;padding-right: 20px; padding-left: 55px;"><b>Notify parents by email</b></label>
                </td>
        </tr>
        <tr>
             <td colspan="3" >
                <input class="span4" style="width:55px;" type="checkbox" placeholder=""  name="nty_sms" id="nty_sms"><label style="color:#000; padding-left: 55px;line-height: 23px;font-size: 14px;vertical-align: 14px;padding-right: 20px;"><b>Notify parents by sms</b></label></td>
        </tr>
       
  <tr>
            <td style="border:none;text-align:center;" colspan="3">
                        <!-- <button type="button" class="btn"
                            onclick="sendSmS(); return false;">Save</button> -->
                      <button type="submit" class="btn" >Save</button>
                    </td>
        </tr>

       </table>

    </div>
    </fieldset>
  </form>
</div>
<script type="text/javascript">
onloadmethods();
</script>

