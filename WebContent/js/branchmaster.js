		
	function copyFromSchoolCall(){		
		
		if (!document.getElementById("br_chkbox").checked) {
			
			var schoolNames = jQuery("#sm_id_list").val();			
			
			if(schoolNames=="-1"){
				alertDialog('Please select  School');
				jQuery("#sm_id_list").focus();
				return false;
			}			
			
		var sm_sname			= document.getElementById("sm_id_list").value;
		BranchMasterDWR.copyfromSchool(sm_sname, function(data){
			
			if(data=="error"){
				alertDialog('No data available for this name');	
			}else{
				
				 var actnData = data.split("~");
			// alert(actnData[3]+"----");
				document.getElementById("br_address").value=actnData[0];
				document.getElementById("br_city").value=actnData[1];
				document.getElementById('br_country').value = actnData[2];	
				
				document.getElementById('br_state_selection').value = actnData[3];
//				document.getElementById('br_state_selection').selectedIndex = actnData[3];
				document.getElementById("br_cperson").value=actnData[4];
				document.getElementById("br_email").value=actnData[5];
				document.getElementById("br_mobile").value=actnData[6];
				document.getElementById("br_landline").value=actnData[7];				
			}
			
	      });
		
	}
}

	function validateBranchMaster(){
		
		var schoolNames = jQuery("#sm_id_list").val();			
		
		if(schoolNames=="-1"){
			setError("sm_id_list","Please select  School");
			jQuery("#sm_id_list").focus();
			return false;
		}		
		
		var patEmail	= /^([\w\-\.]+)@((\[([0-9]{1,3}\.){3}[0-9]{1,3}\])|(([\w\-]+\.)+)([a-zA-Z]{2,4}))$/;	var patSchoolname 		= "/^([a-zA-Z]+\s)*[a-zA-Z]*['. ]?[ ]?([a-zA-Z]+[.]?\s?)*[a-zA-Z]+$/";//later change
		
		var br_sname			= jQuery("#br_sname").val();
		var br_ssname		= jQuery("#br_ssname").val();
		var br_address		= jQuery("#br_address").val();
		var br_city			= jQuery("#br_city").val();
		var br_country		= jQuery("#br_country").val();
		var br_state_selection			= jQuery("#br_state_selection").val();
		var br_cperson	= jQuery("#br_cperson").val();
		var br_email			= jQuery("#br_email").val();
		var br_mobile		= jQuery("#br_mobile").val();
		var br_landline		= jQuery("#br_landline").val();
		

		
		var  br_active;
		 if ($('#br_active').is(":checked"))
					{br_active='Y';
					  // it is checked
		} else{br_active='N';}

		if (br_sname.search(/^([a-zA-Z]+\s)*[a-zA-Z]*['. ]?[ ]?([a-zA-Z]+[.]?\s?)*[a-zA-Z]+$/) == -1 || br_sname =="") {
				  // alert("Enter valid school Name");
				   setError("br_sname","Please enter valid Branch name");
	             jQuery("#br_sname").focus();
		         return false;
	          }
		
		    if (br_ssname.search(/[^a-zA-Z]+/) != -1 || br_ssname =="") {
				  // alert("Short Name should contain only characters");
				   setError("br_ssname","Please enter valid branch short name");
	              jQuery("#br_ssname").focus();
		         return false;
	          }
	          //if (insAddr.search(/^[a-zA-Z0-9\s,'-]*$/) != -1 || insAddr =="") {
	          if (br_address.search(/^[a-z-A-Z][a-zA-Z0-9\s,'-.]*$/)== -1 || br_address =="") {
				   //alert("Enter address in valid format");
				   setError("br_address","Enter address in valid format");
	              jQuery("#br_address").focus();
		         return false;
	          }
	          if (br_city.search(/^[a-zA-Z][a-zA-Z ]*['.]?[a-zA-Z ]+[a-zA-Z ]+$/) == -1 || br_city==""	)	{		 //  alert("Enter valid City Name");
				   setError("br_city","Enter valid city name");
	             jQuery("#br_city").focus();
		         return false;
	          }

			if(br_country == -1){
				setError("br_country","Please enter valid country");
				jQuery("#br_country").focus();
				return false;
			}
	      	if(br_state_selection==-1){
				setError("br_state_selection","Please select valid state");
				jQuery("#br_state_selection").focus();
				return false;
			}
			if(br_cperson.search(/^[a-zA-Z]([a-zA-Z]+\s)*[a-zA-Z]+$/) == -1 || br_cperson ==""){
				setError("br_cperson","Please enter valid contact name");
				jQuery("#br_cperson").focus();
				return false;
			}
			if(br_email.search(patEmail) == -1 || br_email ==""){
				setError("br_email","Please enter valid email id");
				jQuery("#br_email").focus();
				return false;
			}
			if(br_mobile.search(/^[0]?[789]\d{9}$/) == -1 || br_mobile ==""){
				setError("br_mobile","Please enter valid mobile number");
				jQuery("#br_mobile").focus();
				return false;
			}
			if(br_landline.search(/^\d{3,5}([\-]\d{6,8})?$/) == -1 || br_landline ==""){
				setError("br_landline","Please enter valid landline number");
				jQuery("#br_landline").focus();
				return false;
			}	
			
		    if(br_active=="N"){
	            //alert("Please select check box");
	            setError("br_active","Please select check box");
	            jQuery("#br_active").focus();
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
			errorDisp.animate({opacity: 0}, 4000);
	}	
	
 function resetForm($form) {
	    $form.find('input:text, input:password, input:file, textarea').val('');
	       jQuery("#sm_id_list").val('Select');
	       jQuery("#br_state_selection").val('Andhra Pradesh');
	       jQuery("#br_country").val('India');	    
	       
	    $form.find('input:radio, input:checkbox')
	         .removeAttr('checked').removeAttr('selected');
	}

	
	var flag1=1;//for initialize--ths logic all for confirmDialog...
	function saveSchoolMasterAndGo(flag){
		var retrnvalue=validateSchoolMasterForm();
		if(retrnvalue == "false" || retrnvalue == false)
		{
		return false; 
		}
		flag1=flag;
		confirmDialog ('Would you like to save?', alert);
		
		}

	

		
		function saveBranchMaster(){
			var retrnvalue=validateBranchMaster();
			if(retrnvalue == "false" || retrnvalue == false)
			{
			return false; 
			}		
			//do u want to save??
			confirmDialog ('Would you like to save?', alert);
		}
		

		// code for alert box
		function okAlertDialog () {
			$("#idAlertDialog").modal ('hide'); 
			};
		function alertDialog (prompt) {
			document.getElementById ("idAlertDialogPrompt").innerHTML = prompt;
			$("#idAlertDialog").modal ("show");
			}
		
		// code for confirm box
		var confirmDialogCallback;
		
		function closeConfirmDialog () {
			$("#idConfirmDialog").modal ('hide'); 
			};
		function okConfirmDialog () {
			$("#idConfirmDialog").modal ('hide'); 
			save();
			};
		function confirmDialog (prompt, callback) {
			document.getElementById ("idConfirmDialogPrompt").innerHTML = prompt;
			confirmDialogCallback = callback;
			$("#idConfirmDialog").modal ("show");
			}
		
		function save(){
			
			
			var schoolID			= document.getElementById("sm_id_list").value;
			var br_sname			= document.getElementById("br_sname").value;
			var br_ssname			= document.getElementById("br_ssname").value;
			var br_address			= document.getElementById("br_address").value;
			var br_city				= document.getElementById("br_city").value;
			var br_country			= document.getElementById("br_country").value;
			var br_state				= document.getElementById("br_state_selection").value;


			var br_cperson			= document.getElementById("br_cperson").value;
			var br_email			= document.getElementById("br_email").value;
			var br_mobile			= document.getElementById("br_mobile").value;
			var br_landline			= document.getElementById("br_landline").value;
			var isactive 			= document.getElementById("br_active").checked;
			BranchMasterDWR.saveBranchMaster(schoolID,br_sname, br_ssname,   br_address,  br_city,   br_country, 	br_state, br_cperson,br_email,br_mobile, br_landline,   isactive,
					function(data){				
				alertDialog(data);
				resetForm($('#branchFrom')); // by id, recommended
		      });
		
		}
		
