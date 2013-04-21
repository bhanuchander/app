<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	    <link href="css/bootstrap.css" rel="stylesheet">
	    <style type="text/css">
	    .styledRadio {
			display: inline-block;
		}
		</style>

	    <script type="text/javascript" src="js/bootstrap-radio.js"></script>
	    
	      <script 	src="<%=request.getContextPath()%>/dwr/interface/SMSCreditsDWR.js"></script>
	      <script 	src="<%=request.getContextPath()%>/dwr/interface/SchoolMasterDWR.js"></script>
	      <script 	src="<%=request.getContextPath()%>/dwr/interface/BranchMasterDWR.js"></script>
	      <script 	src="<%=request.getContextPath()%>/dwr/interface/ClassMasterDWR.js"></script>
	    
	    <script type="text/javascript">
	    
	    $(function(){
		
			$('input:radio').screwDefaultButtons({
				image: 'url("img/radioSmall.jpg")',
				width: 20,
				height: 20
			});
			
				});
	    function disableOrEnable(val){
			if(val=='all'){
				document.getElementById('selectClass').disabled = true;
				document.getElementById('selectAll').disabled = false;
			}else{
					document.getElementById('selectAll').disabled = true;
					document.getElementById('selectClass').disabled = false;
			}
		}
	 function selectValue(value){	
		if(value=="-1"){
			alert('plz select value');
			}
	 }
	 
	 function schoolMasterList(){
	    
		   try{
		   
					alert("onload school master");
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
		   	
					alert("based school master getting branch master list--"+schoolID);
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
		 
	function selectBranchesforClasses(){
	   
	 	   
	   var branchID = jQuery("#branchNames").val();
	   var schoolID = jQuery("#schoolNames").val();

		removeAllOptions("selectClass");
					  
		if(branchID != '-1'){	   
		   try{
		   	var im_id = "<%=session.getAttribute("IM_ID")%>";	
		   	
					alert("based school master getting branch master list--"+branchID+"--"+schoolID);
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
	 	function getClassesList(){
	
			if (!document.getElementById("classRadio").checked) {
			alert("checkkk");			
			selectBranchesforClasses();

			}
		}

	 function onloadmethods(){
	 
	 schoolMasterList();
	
	 
	// classMaster();
	 }
	function classMaster(){
			//Process DWR/AJAX request here
				try{
				//alert("in alrttt--SMSCredits");
					
					var im_id = "<%=session.getAttribute("IM_ID")%>";					
					var sm_id = "<%=session.getAttribute("SM_ID")%>";				
					var bm_id = "<%=session.getAttribute("BM_ID")%>";						
					
					var listofClasses = document.getElementById('selectClass');
					
					alert(listofClasses+"::::::");
					
				     ClassMasterDWR.getClassMasterList(im_id,sm_id,bm_id,function(data){
					                                if (data == null) {														
					                                  alert("error");
					                                 
													} else {				
												//	alert(data+":::")		                                 
					                               for(var i = 0; i < data.length; i++) {
														  var opt = document.createElement("option");
														    var temp = data[i];
														    opt.value = temp[0];
														    opt.innerHTML = temp[1];
														    listofClasses.appendChild(opt);
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
	
	function getSMSCredits(){
	
	
	   var branchID = jQuery("#branchNames").val();
	   var schoolID = jQuery("#schoolNames").val();
	   
	   if(branchID != -1 && schoolID != -1){
	   smscredits(schoolID,branchID);
	   }
	
	}
	
	 function smscredits(schoolID,branchID){
	 				//Process DWR/AJAX request here
				try{
				//alert("in alrttt--SMSCredits");
					alert(branchID+"--")
				     SMSCreditsDWR.smsCreditsBalance(schoolID,branchID,function(data){
					                                if (data != "error" && data != null) {														
					                                   //alert("::"+data);
					                                   jQuery("#smscredits").val(data);
													} else {				
												//	alert(data+":::")		                                 
					                                   jQuery("#smscredits").val("0");				                          
													}
					                         }
					      ) ;   
					 }catch(e){
					 alert("incatch::"+e);
					        jQuery.log.info(e.message);
					        jQuery("#infoError").html("&nbsp;");
	        	     } 
	 
	 
	 }

	function limiter(){
		var tex = document.smsForm.smsbody.value;
		var len = tex.length;
		document.smsForm.limit.value = len;
	}
	function previewSmS(){
	alert('preview');
	}
	function previewSMSValidate(){
			var body =/^[A-Za-z0-9].+$/;
			var subj			=  jQuery("#smsbody").val().match(body);
			var selectAll			=  jQuery("#selectAll").val();
			var selectClass			=  jQuery("#selectClass").val();
			var radios = document.getElementsByName("radio1");
		    var formValid = false;
		     var i = 0;
		   	var schoolNames = jQuery("#schoolNames").val();
			var branchNames = jQuery("#branchNames").val();	
		
			if(schoolNames=="-1"){
				alertDialog('Please select valid School');
				jQuery("#schoolNames").focus();
				return false;
			}
			
			if(branchNames=="-1"){
				alertDialog('Please select valid Branch');
				jQuery("#branchNames").focus();
				return false;
			}    
		     
		    while (!formValid && i < radios.length) {
		        if (radios[i].checked) formValid = true;
		        i++;     
		          
		    }
		    if (!formValid){ 
			    alertDialog("Must check send to or select!");
			    return false;
		    }
		    if(i==1 && selectAll=="-1"){
				alertDialog('please select send to option');
				return false;
			}else if(i==2 && selectClass=="-1"){
				alertDialog('please select parent of select option');
				return false;
			}
	
		if(!subj){
			alertDialog('Please enter sms text');
			return false;
		}
		//alertDialog('All validations cleared');

	}
	
	function okAlertDialog () {
		$("#idAlertDialog").modal ('hide'); 
	};
	function alertDialog (prompt) {
		document.getElementById ("idAlertDialogPrompt").innerHTML = prompt;
		$("#idAlertDialog").modal ("show");
	}
	    
	
	
	   </script>
	
	<div style="height:50px;"></div>
<div class="reg_mainCon">

  <form action="previewSMS.action"	method="post"  name="smsForm"  onsubmit="return previewSMSValidate(this)">
  
    <fieldset>
    <legend><img src="img/list_add_user.PNG" class="img-circle">&nbsp;&nbsp;Send
        Sms</legend>
    <div style="padding:20px;">
      <label style="color:#000;"></label>
   <table width="100%" border="0" cellspacing="0" cellpadding="0">
   
   		<tr>
            <td colspan="2"><label><b style="color:#000;font-size: 18px;">Select Audience</b></label></td>
             <td>
             
             <label style="color:#000;text-align:right;padding-right: 60px"><b>SMS Credits :
              <input type=text style=width:55px;height:12px; name='smscredits' id='smscredits' readonly="readonly"></b></label>
             
             </td>
        </tr>
        <tr><td>&nbsp;</td></tr>
            <tr>
                <td colspan="4">
	               <table  width="100%">
	               <tr><td><label style="color:#000;"><b>School </b></label></td>
	                <td><select class="span3"  name="schoolNames" id="schoolNames" onchange="selectSchoolforBranches(this.value);">
	                        <option value="-1" selected="selected">Select</option>
	                       <!--  <option value="0">ALL</option> -->
	                       </select>                   
	                 </td><td><label style="color:#000;"><b>Branch </b></label></td>
	                <td><select class="span3" name="branchNames" id="branchNames" onchange="getSMSCredits();"><!-- selectBranchesforClasses(this.value) -->
	                        <option value="-1" selected="selected">Select</option>
	                      <!--   <option value="0">All</option> -->
	                       </select>                   
	                 </td>
	                 </tr></table>
	             </td>
        </tr>
         <tr><td>&nbsp;</td></tr>
        <tr>
                <td><input  type="radio" placeholder=""  name="radio1"   onchange="disableOrEnable('all')"	 checked></td>
                <td><label><b style="color:#000;font-size: 14px;">Send to</b></label></td>
          		<td><select class="span4"  type="text"  name="selectAll" placeholder="" id="selectAll" onchange="selectValue(this.value);"> 
						<option value="-1"  selected="selected">Select</option>
						<option value="AllParents">All parents</option>
                        <option value="AllTeachingStaff">All Teaching Staff</option>
                        <option value="AllNonTeachingStaff">All Non Teaching Staff</option>
               		</select>                    
                 </td>
        </tr>
        <tr>
                <td><input  type="radio" placeholder=""  name="radio1"  id="classRadio" onchange="disableOrEnable('class');" onclick="getClassesList();return false;"></td>
                <td><label style="color:#000;font-size: 14px;"><b>Select</b></label></td>
          		<td colspan="2"> <span style="color:black;font-weight:bold;font-size: 13px">Parents of &nbsp;&nbsp;   </span>
          		 <select class="span3"  name="selectClass"   id="selectClass" onchange="selectValue(this.value)" disabled="disabled"> 
						<option value="-1"  selected="selected">Select</option>
							<!-- <option value="Class-A">Class-A</option>
                            <option value="Class-B">Class-B</option>
                            <option value="Class-C">Class-C</option> -->
          		</select></td>
        </tr>
         <tr><td>&nbsp;</td></tr>
         <tr><td>&nbsp;</td></tr>
          <tr>
            <td colspan="3">
                <label style="color:#000;"><b>SMS Body</b></label>     
                <textarea style="width:96%;" rows="3"  name="smsbody" id="smsbody" onkeyup="limiter()" wrap="physical"></textarea>
                </td>
        </tr>
          <tr>
            <td colspan="2">
             <script type="text/javascript">
				document.write("<input type=text style=width:55px; name='limit' id='limit' size=4 readonly value='0'>");
			</script>
                </td>
                 <td>
            <label style="color:#000;text-align:right;"><b>New SMS per 120 characters will be sent</b></label>
                </td>
        </tr>
        
  <tr>
            <td style="border:none;text-align:center;" colspan="3">
                        <button type="submit" class="btn">Preview</button> 
<!--                         <button type="submit" class="btn" onclick="previewSmS(); return false;">Preview</button>  -->
                    </td>
        </tr>

       </table>

    </div>
    </fieldset>
  </form>
</div>


 <div id="idAlertDialog" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="windowTitleLabel" aria-hidden="true">
            <img src="img/alert.gif" width="34" height="28" alt="alert icon">
            <h3 id="idAlertDialogPrompt"></h3>
            <a href="#" class="btn btn-primary" onclick="okAlertDialog ();">OK</a>
            </div>
<script type="text/javascript">
onloadmethods();
</script>

