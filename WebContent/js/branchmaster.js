		
	function copyFromSchoolCall(){	
	
		if (!document.getElementById("br_chkbox").checked) {
		alert("checkkk");
		var sm_sname			= document.getElementById("sm_id_list").value;
		BranchMasterDWR.copyfromSchool(sm_sname, function(data){
			
			if(data=="error"){
				alertDialog('No data available for this name');	
			}else{
				
				 var actnData = data.split("~");
				 alert(actnData[3]+"----");
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

	/*function changeCountry(value){
			document.getElementById("displayStateinput").style.display="none";
			document.getElementById("displayStateselection").style.display="none";
			if(value == "India"){
				document.getElementById("displayStateselection").style.display="block";
			}
			else{
				document.getElementById("displayStateinput").style.display="block";
			}
			
			
		}*/
		

		
		function saveBranchMaster(){
			var retrnvalue=validateBranchMaster();
			if(retrnvalue == "false" || retrnvalue == false)
			{
			return false; 
			}
			
			/*var sm_sname			= document.getElementById("sm_sname").value;
			var sm_ssname			= document.getElementById("sm_ssname").value;
			var sm_address			= document.getElementById("sm_address").value;
			var sm_city				= document.getElementById("sm_city").value;
			var sm_country			= document.getElementById("sm_country").value;
			var sm_state			= '';
			if(sm_country=="India"){
			sm_state				= document.getElementById("sm_state_selection").value;
			}else{
			sm_state				= document.getElementById("sm_state_input").value;	
			}
			var sm_cperson			= document.getElementById("sm_cperson").value;
			var sm_email			= document.getElementById("sm_email").value;
			var sm_mobile			= document.getElementById("sm_mobile").value;
			var sm_landline			= document.getElementById("sm_landline").value;
			var isactive 			= document.getElementById("sm_active").checked;*/
		
			//do u want to save??
			confirmDialog ('Would you like to save?', alert);
			
			/*SchoolMasterDWR.saveSchoolMaster(sm_sname,sm_ssname,sm_address,sm_city,sm_country,sm_state,sm_cperson,sm_email,sm_mobile,sm_landline,isactive,function(data){	
				alertDialog(data);
		      });*/
			
		}
		
		function validateBranchMaster(){
			var patEmail	= /^([\w\-\.]+)@((\[([0-9]{1,3}\.){3}[0-9]{1,3}\])|(([\w\-]+\.)+)([a-zA-Z]{2,4}))$/;					
			var patName		=/^[a-zA-Z-. ]{2,25}$/;
			var patAddress		=/^[a-zA-Z0-9-.,~!@ #$%^&*()_+:"?]{2,25}$/;
			var num			= /^[0-9]{8,15}$/;	
			
			var sm_sname			= document.getElementById("br_sname").value.match(patName);
			var sm_ssname			= document.getElementById("br_ssname").value.match(patName);
			var sm_address			= document.getElementById("br_address").value.match(patAddress);
			var sm_city				= document.getElementById("br_city").value.match(patName);
			var sm_country			= document.getElementById("br_country").value.match(patName);
			var sm_state				= document.getElementById("br_state_selection").value;
		/*	if(sm_country=="India"){
			sm_state				= document.getElementById("br_state_selection").value.match(patName);
			}else{
			sm_state				= document.getElementById("br_state_input").value.match(patName);	
			}*/
			var sm_cperson			= document.getElementById("br_cperson").value.match(patName);
			var sm_email			= document.getElementById("br_email").value.match(patEmail);
			var sm_mobile			= document.getElementById("br_mobile").value.match(num);
			var sm_landline			= document.getElementById("br_landline").value.match(num);
				if(!sm_sname){
					alertDialog('Please enter valid Branch name');
					return false;
				}if(!sm_ssname){
					alertDialog('Please enter valid Branch short name');
					return false;
				}if(!sm_address){
					alertDialog('Please enter valid address');
					return false;
				}if(!sm_city){
					alertDialog('Please enter valid city');
					return false;
				}if(!sm_country){
					alertDialog('Please enter valid country');
					return false;
				}if(!sm_state){
					alertDialog('Please enter valid state');
					return false;
				}if(!sm_cperson){
					alertDialog('Please enter valid contact name');
					return false;
				}if(!sm_email){
					alertDialog('Please enter valid email id');
					return false;
				}if(!sm_mobile){
					alertDialog('Please enter valid mobile number');
					return false;
				}if(!sm_landline){
					alertDialog('Please enter valid landline number');
					return false;
				}	
		
		
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
			BranchMasterDWR.saveBranchMaster(schoolID,br_sname, br_ssname,   br_address,  br_city,   br_country, 	br_state, br_cperson,br_email,br_mobile, br_landline,   isactive,function(data){	
				alertDialog(data);
				document.getElementById("br_sname").value='';
				document.getElementById("br_ssname").value='';
				document.getElementById("br_address").value='';
				document.getElementById("br_city").value='';
				document.getElementById("br_cperson").value='';
				document.getElementById("br_email").value='';
				document.getElementById("br_mobile").value='';
				document.getElementById("br_landline").value='';
		
		      });
		
		}
		
